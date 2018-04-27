package uk.antiperson.resourceworld;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEvents implements Listener{

    private ResourceWorld rw;
    public BlockEvents(ResourceWorld rw){
        this.rw = rw;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(!rw.configManager.getConfig().getStringList("enabled-worlds").contains(event.getPlayer().getWorld().getName())){
            return;
        }
        if(rw.configManager.getConfig().getStringList("allow-break").contains(event.getBlock().getType().toString())){
            return;
        }
        if(player.hasPermission("ResourceWorld.Bypass")){
            return;
        }
        if(event.getBlock().getLocation().getY() > rw.configManager.getConfig().getInt("prevent-break-above")){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(!rw.configManager.getConfig().getStringList("enabled-worlds").contains(event.getPlayer().getWorld().getName())){
            return;
        }
        if(player.hasPermission("ResourceWorld.Bypass")){
            return;
        }
        event.setCancelled(true);
    }
}
