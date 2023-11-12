package gg.quartzdev.qtownybiomeblacklist;

import gg.quartzdev.qtownybiomeblacklist.listeners.TownyClaimListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class qTownyBiomeBlacklist extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new TownyClaimListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
