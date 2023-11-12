package gg.quartzdev.qtownybiomeblacklist;

import gg.quartzdev.qtownybiomeblacklist.listeners.TownyClaimListener;
import org.bstats.bukkit.Metrics;
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

        int pluginId = 20273; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);


        biomeBlacklist = loadBiomeBlacklist();
        DENY_MESSAGE = getConfig().getString("deny-msg", "You're not allowed to claim land in <biome>");
        getServer().getPluginManager().registerEvents(new TownyClaimListener(), instance);
        saveDefaultConfig();
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
