package gg.quartzdev.qtownybiomeblacklist;

import gg.quartzdev.qtownybiomeblacklist.listeners.TownyClaimListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class qTownyBiomeBlacklist extends JavaPlugin {
    private static qTownyBiomeBlacklist instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new TownyClaimListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static qTownyBiomeBlacklist getInstance() {
        return instance;
    }
}
