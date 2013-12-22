package io.github.lst96.FrameProtector.Commands;

import io.github.lst96.FrameProtector.FrameProtector;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ItemReload implements CommandExecutor {
	private FrameProtector plugin;
	
	public ItemReload(FrameProtector instance){
		this.plugin = instance;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	    if (commandLabel.equalsIgnoreCase("framereload")) {
	      if ((sender.isOp()) || (sender.hasPermission("frame.reload"))) {
	        plugin.reloadConfig();
	        sender.sendMessage(ChatColor.DARK_RED + "[Frame Protector]" + " " + ChatColor.RED + "Configuration Reloaded!");
	        return true;
	      }
	      sender.sendMessage(ChatColor.DARK_RED + "[Frame Protector]" + ChatColor.RED + " I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
	      return true;
	    }
	    return false;
	  }
}