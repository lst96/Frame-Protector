package io.github.lst96.FrameProtector.Listener;
 
 import io.github.lst96.FrameProtector.FrameProtector;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
 
 public class ItemRemove implements Listener {
 
   public ItemRemove(FrameProtector instance) {
  }
 
   @EventHandler(priority=EventPriority.HIGHEST)
   public void onDestroyByEntity(HangingBreakByEntityEvent event) {
     if ((event.getRemover() instanceof Player)) {
       Player p = (Player)event.getRemover();
       if ((event.getEntity().getType() == EntityType.ITEM_FRAME)) {
    	if ((!p.isOp()) && (!p.hasPermission("frame.remove"))) {
           p.sendMessage(ChatColor.DARK_RED + "You are not allowed to remove this ItemFrame!");
           event.setCancelled(true);
           return;
         }
       } 
     }
   }
   @EventHandler(priority=EventPriority.HIGHEST)
   public void OnPlaceByEntity(HangingPlaceEvent event) {
	   Player p = (Player)event.getPlayer();
	   if ((event.getEntity().getType() == EntityType.ITEM_FRAME)) {
		   if ((!p.isOp()) && (!p.hasPermission("frame.place"))) {
		   p.sendMessage(ChatColor.DARK_RED + "You are not allowed to place this ItemFrame!");
		   event.setCancelled(true);
		   return;
	      }
	   }
   }
   @EventHandler
   public void ItemRemoval(EntityDamageByEntityEvent e) {
     if ((e.getDamager() instanceof Player)) {
       Player p = (Player)e.getDamager();
       if ((e.getEntity().getType() == EntityType.ITEM_FRAME)) {
        if ((!p.isOp()) && (!p.hasPermission("frame.item.remove"))) {
        	p.sendMessage(ChatColor.DARK_RED + "You are not allowed to remove items from this ItemFrame!");
        	e.setCancelled(true); 
       }
       }
     }   		   
     if ((e.getDamager() instanceof Projectile) && (e.getEntity().getType() == EntityType.ITEM_FRAME)) {   	
    	 e.setCancelled(true);    	 
     }
   }
  }
 

     