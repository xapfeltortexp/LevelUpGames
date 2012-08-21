package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.command.CommandSender;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lcredits extends SubBase {

	public lcredits(LevelUpGamesMain pl) {
		super(pl);
	}
	
	@Override
	public void run(CommandSender sender, String[] args) {
		if(args.length > 1) {
			plugin.toMuchArgs(sender);
			return;
		}
		sender.sendMessage(plugin.prefix + plugin.gray + "Plugin Developers:");
		sender.sendMessage(plugin.blue + "manniL - http://coding.evo-network.de/");
		sender.sendMessage(plugin.blue + "xapfeltortexp -  http://LostForce.com/");
		sender.sendMessage(plugin.blue + "Contact us!");
		return;
	}

}
