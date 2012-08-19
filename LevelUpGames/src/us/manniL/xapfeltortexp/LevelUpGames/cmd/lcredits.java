package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lcredits extends SubBase {

	public lcredits(LevelUpGamesMain pl) {
		super(pl);
	}
	
	@Override
	public void run(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[LevelUpGames] You are not a Player. Join the Server to perform some Commands.");
			return;
		}
		final Player player = (Player) sender;
		if(args.length > 1) {
			plugin.toMuchArgs(player);
			return;
		}
		player.sendMessage(plugin.prefix + plugin.gray + "Plugin Developers:");
		player.sendMessage(plugin.blue + "manniL - http://coding.evo-network.de/");
		player.sendMessage(plugin.blue + "xapfeltortexp -  http://LostForce.com/");
		return;
	}

}
