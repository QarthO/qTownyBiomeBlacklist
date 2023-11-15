package gg.quartzdev.qtownybiomeblacklist;

import com.palmergames.bukkit.towny.TownySettings;
import gg.quartzdev.qtownybiomeblacklist.listeners.TownyClaimListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class qTownyBiomeBlacklist extends JavaPlugin {
    private static qTownyBiomeBlacklist instance;
    private Collection<Biome> biomeBlacklist;
    private String DENY_MESSAGE;

    public static qTownyBiomeBlacklist getInstance() {
        return instance;
    }

    public Collection<Biome> getBiomeBlacklist(){
        return biomeBlacklist;
    }

    public String getDenyMessage(){
        return DENY_MESSAGE;
    }

    @Override
    public void onEnable() {
        instance = this;

//        setup bstats metrics
        int pluginId = 20273;
        Metrics metrics = new Metrics(this, pluginId);

        if(TownySettings.getTownBlockSize() != 16){
            getLogger().severe("This plugin currently only supports TownBlock Sizes of 16. Keeping bugging @QarthO on discord until he adds support.");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }

//        load options from config
        saveDefaultConfig();
        biomeBlacklist = loadBiomeBlacklist();
        DENY_MESSAGE = getConfig().getString("deny-msg", "You're not allowed to claim land in <biome>");

//        register town land claim listener
        getServer().getPluginManager().registerEvents(new TownyClaimListener(), instance);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Collection<Biome> loadBiomeBlacklist(){
        this.getLogger().info("Loading blacklisted biomes from config...");
        Collection<Biome> biomeBlacklist = new ArrayList<>();
        List<?> blacklistedBiomesList = getConfig().getList("blacklisted-biomes");
        if(blacklistedBiomesList == null) return biomeBlacklist;
        int blacklistedBiomeCount = 0;
        for(Object obj : blacklistedBiomesList){
            String biomeName = (String) obj;
            try {
                Biome biome = Biome.valueOf(biomeName);
                biomeBlacklist.add(biome);
                blacklistedBiomeCount++;
                this.getLogger().info("- Added: " + biome.name());
            } catch(IllegalArgumentException e){
                this.getLogger().severe("Error: '" + biomeName + "' is not a valid biome");
            }
        }
        this.getLogger().info("Loaded " + blacklistedBiomeCount + " blacklisted biomes");
        return biomeBlacklist;
    }
}
