package gg.quartzdev.qtownybiomeblacklist.listeners;

import com.palmergames.bukkit.towny.TownySettings;
import com.palmergames.bukkit.towny.event.TownPreClaimEvent;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.TownBlock;
import gg.quartzdev.qtownybiomeblacklist.qTownyBiomeBlacklist;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.Collection;

public class TownyClaimListener implements Listener {

    qTownyBiomeBlacklist plugin;
    Collection<Biome> biomeBlacklist;
    String DENY_MESSAGE;

    public TownyClaimListener(){
        Bukkit.getLogger().info("Registering Towny Events");
        this.plugin = qTownyBiomeBlacklist.getInstance();
        this.biomeBlacklist = plugin.getBiomeBlacklist();
        this.DENY_MESSAGE = plugin.getDenyMessage();
    }

    @EventHandler(priority  = EventPriority.HIGHEST)
    public void onTownyClaim(TownPreClaimEvent event){

//        plugin should already be disabled, but just incase they changed townblocksize while server is running
        if(TownySettings.getTownBlockSize() != 16){
            plugin.getLogger().severe("This plugin currently only supports TownBlock Sizes of 16. Keeping bugging @QarthO on discord until he adds support.");
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            return;
        }

//        gets the TownBlock
        TownBlock townBlock = event.getTownBlock();

//        checks if there is a blacklisted biome
        Biome biome = containsBlackListedBiome(townBlock);
        if(biome == null) return;

//        cancels the event and messages the player
        event.setCancelMessage(this.DENY_MESSAGE.replaceAll("<biome>", biome.name()));
        event.setCancelled(true);

    }

    public Biome containsBlackListedBiome(TownBlock townBlock){

//        gets the world the TownBlock is in
        World world = townBlock.getWorld().getBukkitWorld();
        if(world == null)
            return null;

//        gets the chunk object of the TownBlock
        Coord coord = townBlock.getCoord();
        int x = coord.getX();
        int z = coord.getZ();
        Chunk chunk = world.getChunkAt(x, z);

//        checks if the chunk contains a blacklisted biome
        for(Biome biome : this.biomeBlacklist){
            if(chunk.contains(biome))
                return biome;
        }
        return null;
    }
}
