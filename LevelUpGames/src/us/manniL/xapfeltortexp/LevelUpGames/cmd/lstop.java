package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lstop extends SubBase {

	public lstop(LevelUpGamesMain pl) {
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
		if (!player.hasPermission("LevelUpGames.stop")) {
			plugin.noPerms(player);
			return;
		}
		if (!this.plugin.start) {
			player.sendMessage(plugin.prefix + plugin.gray + "There are no LevelUpGames yet. So what should I Stop?");
			return;
		}
		if (this.plugin.start) {
			this.plugin.start = false;
			player.sendMessage(plugin.prefix + plugin.gray + "You stopped the LevelUpGames.");

			for (int i = 0; i < this.plugin.players.size(); i++) {
				Bukkit.getServer().getPlayer((String) plugin.players.get(i)).teleport(Bukkit.getServer().getPlayer((String) this.plugin.players.get(i)).getWorld().getSpawnLocation());
			}
			plugin.players.clear();
			this.plugin.limit = 0;
			return;
		}

	}

}
