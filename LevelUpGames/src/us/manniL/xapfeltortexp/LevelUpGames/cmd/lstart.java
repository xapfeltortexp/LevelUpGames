package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lstart extends SubBase {

	public lstart(LevelUpGamesMain pl) {
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
		if (!player.hasPermission("LevelUpGames.start")) {
			plugin.noPerms(player);
			return;
		}
		if (!this.plugin.toggle) {
			player.sendMessage(plugin.prefix + plugin.gray + "The LevelUpGames arent started yet.");
			return;
		}
		if (this.plugin.toggle) {
			player.sendMessage(plugin.prefix + plugin.gray + "You started the LevelUpGames.");

			for (int i = 0; i < this.plugin.players.size(); i++) {
				//Player teleport to the Random Spawn.s
			}
			this.plugin.toggle = false;
			this.plugin.start = true;
			return;
		}
	}

}
