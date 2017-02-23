package com.frash23.smashhit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

class SmashHitCommand implements CommandExecutor {
	private SmashHit plugin;

	SmashHitCommand(SmashHit pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		/* You can pry the section signs from my cold, dead hands */

		String subcmd = args.length < 1 ? "help" : args[0];
		switch (subcmd.toLowerCase()) {
		case "reload":
			plugin.reload();
			sender.sendMessage(new String[] { "SmashHit (Modified by Speentie8081)", "Fundamental plugin components reloaded" });
			return true;

		case "toggle":
			if (plugin.isListening()) {
				plugin.unregisterHitListener();
				sender.sendMessage(new String[] { "SmashHit (Modified by Speentie8081)", "Fundamental plugin components disabled" });
			} else {
				plugin.registerHitListener();
				sender.sendMessage(new String[] { "SmashHit (Modified by Speentie8081)", "Fundamental plugin components enabled" });
			}
			return true;

		case "debug":
			if (plugin.isDebug()) {
				plugin.unregisterDebugListener();
				sender.sendMessage(new String[] { "SmashHit (Modified by Speentie8081)", "Plugin debugging disabled" });
			} else {
				plugin.registerDebugListener();
				sender.sendMessage(new String[] { "SmashHit (Modified by Speentie8081)", "Plugin debugging enabled" });
			}
			return true;

		default:
			sender.sendMessage(new String[] { "SmashHit (Modified by Speentie8081)", "/" + label + " help - Displays this simple command listing", "/" + label + " reload - Restart the fundamental plugin components", "/" + label + " toggle - Enable or disable the hit interception", "/" + label + " debug - Enable or disable plugin debugging" });
			return true;
		}
	}
}
