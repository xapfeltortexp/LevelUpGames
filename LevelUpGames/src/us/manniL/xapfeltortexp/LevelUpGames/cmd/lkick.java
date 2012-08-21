package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lkick extends SubBase {

	public lkick(LevelUpGamesMain pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[LevelUpGames] You are not a Player. Join the Server to perform some Commands.");
			return;
		}
		Player player = (Player) sender;
		if (args.length == 1) {
			plugin.toMuchArgs(player);
			return;
		}
		if (!player.hasPermission("LevelUpGames.kick")) {
			plugin.noPerms(player);
			return;
		}
		if (args[1].equalsIgnoreCase(player.getName())) {
			player.sendMessage(plugin.prefix + plugin.gray + "You cant kick yourself. Please try /lug leave.");
			return;
		}
		Player target = (Player) Bukkit.getServer().getPlayer(args[1]);
		if (target != null) {
			if (!this.plugin.players.contains(target.getName())) {
				player.sendMessage(plugin.prefix + plugin.gray + "This Player isnt in the LevelUpGames.");
				return;
			}
			target.teleport(target.getWorld().getSpawnLocation());
			this.plugin.players.remove(target.getName());
			this.plugin.limit--;
			player.sendMessage(plugin.prefix + plugin.gray + "You kicked " + plugin.blue + target.getName() + plugin.gray + " from the LevelUpGames.");
			return;
		} else {
			player.sendMessage(plugin.prefix + plugin.blue + args[0] + plugin.gray + " not found.");
			return;
		}

	}

}
