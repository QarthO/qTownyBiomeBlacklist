package gg.quartzdev.qtownybiomeblacklist.listeners;

import com.palmergames.bukkit.towny.event.TownPreClaimEvent;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.TownBlock;
import gg.quartzdev.qtownybiomeblacklist.qTownyBiomeBlacklist;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class TownyClaimListener implements Listener {

    qTownyBiomeBlacklist plugin;

    public TownyClaimListener(qTownyBiomeBlacklist plugin){
        Bukkit.getLogger().info("Registering Towny Events");
        this.plugin = plugin;
    }

    @EventHandler(priority  = EventPriority.HIGHEST)
    public void onTownyClaim(TownPreClaimEvent event){
        Bukkit.getLogger().info("TownPreClaimEvent fired");
        TownBlock townBlock = event.getTownBlock();

        if(this.getBiomeFromTownBlock(townBlock) == Biome.OCEAN){
            Bukkit.getLogger().info("Cancelling TownPreClaimEvent because biome is ocean");
            event.setCancelled(true);
        }

    }

    public Biome getBiomeFromTownBlock(TownBlock townBlock){

        World world = townBlock.getWorld().getBukkitWorld();
        Coord coord = townBlock.getCoord();

        int x = coord.getX();
        int z = coord.getZ();
        int y = 100;

        Location townBlockLocation = new Location(world, x, y, z);
        return world.getBiome(townBlockLocation);
    }
}
