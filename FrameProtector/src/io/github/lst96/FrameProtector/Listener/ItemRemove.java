package io.github.lst96.FrameProtector.Listener;

import io.github.lst96.FrameProtector.FrameProtector;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ItemRemove implements Listener {

	public ItemRemove(FrameProtector instance) {
	}

	@EventHandler
	public void ItemRemoval(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (e.getEntity().getType() == EntityType.ITEM_FRAME) {
				if (!p.hasPermission("frame.remove")) {
					e.setCancelled(true);
					p.sendMessage(ChatColor.DARK_RED + "You are not allowed to remove items from ItemFrame!");
					return;
				}
			}
		}
	}
}
