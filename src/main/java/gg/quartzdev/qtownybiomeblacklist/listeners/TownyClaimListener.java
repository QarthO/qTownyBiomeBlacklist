package gg.quartzdev.qtownybiomeblacklist.listeners;

import com.palmergames.bukkit.towny.event.TownPreClaimEvent;
import com.palmergames.bukkit.towny.event.plot.changeowner.PlotClaimEvent;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.TownBlock;
import gg.quartzdev.qtownybiomeblacklist.qTownyBiomeBlacklist;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownyClaimListener implements Listener {

    qTownyBiomeBlacklist plugin;

    public TownyClaimListener(qTownyBiomeBlacklist plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onTownyClaim(TownPreClaimEvent event){
        Bukkit.getLogger().info("TownPreClaimEvent fired");
        TownBlock townBlock = event.getTownBlock();
        Coord coord = townBlock.getCoord();
        World world = townBlock.getWorld().getBukkitWorld();
        int x = coord.getX();
        int z = coord.getZ();

        int y = 100;

        Location townBlockLocation = new Location(world, x, y, z);

        Biome biome = townBlock.getWorld().getBukkitWorld().getBiome(townBlockLocation);


        Bukkit.getServer().getLogger().info(biome.name());
        if(biome.equals(Biome.FOREST)){
            event.setCancelled(true);
        } else
            return;
    }

    @EventHandler void onTownyPlotClaim(PlotClaimEvent event){
        Bukkit.getLogger().info("PlotClaimEvent fired");
    }

}
