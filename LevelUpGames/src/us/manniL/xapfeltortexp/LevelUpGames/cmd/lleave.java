package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lleave extends SubBase {

	public lleave(LevelUpGamesMain pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[LevelUpGames] You are not a Player. Join the Server to perform some Commands.");
			return;
		}
		final Player player = (Player) sender;
		if (args.length > 1) {
			plugin.toMuchArgs(player);
			return;
		}
		if (!player.hasPermission("LevelUpGames.join")) {
			plugin.noPerms(player);
			return;
		}
		if (!this.plugin.players.contains(player.getName())) {
			player.sendMessage(plugin.prefix + plugin.gray + "You are not in the LevelUpGames. You cant leave.");
			return;
		}
		player.teleport(player.getWorld().getSpawnLocation());
		this.plugin.players.remove(player.getName());
		this.plugin.limit--;
		player.sendMessage(plugin.prefix + plugin.gray + "You leaved the LevelUpGames.");
		return;
	}

}
