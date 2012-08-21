package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
			Bukkit.broadcastMessage(plugin.prefix + plugin.gray + "The LevelUpGames Started! Good Luck!");
			for (int i = 0; i < this.plugin.players.size(); i++) {
					int r = plugin.getConfig().getInt("RandomSpawnRadius");
					Player p = Bukkit.getPlayer(plugin.players.get(i));
					Random r1 = new Random();
					Random r2 = new Random();
					int z = r1.nextInt(r);
					int x = r2.nextInt(r);
					int sign1 = r1.nextInt(2);
					int sign2 = r2.nextInt(2);
					if(sign1 == 1){
						z = -(z);
					}
					if(sign2 == 1){
						x = -(x);
					}
					p.teleport(new Location(Bukkit.getWorld(plugin.getConfig().getString("RandomSpawn.w")), x, plugin.getConfig().getDouble("RandowmSpawn.y"), z));
				}
			this.plugin.toggle = false;
			this.plugin.start = true;
			return;
		}
	}

}
