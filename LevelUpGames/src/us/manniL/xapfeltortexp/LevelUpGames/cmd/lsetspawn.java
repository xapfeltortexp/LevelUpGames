package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;
import us.manniL.xapfeltortexp.LevelUpGames.SubBase;

public class lsetspawn extends SubBase {

	public lsetspawn(LevelUpGamesMain pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[LevelUpGames] You are not a Player. Join the Server to perform some Commands.");
			return;
		}
		Player p = (Player) sender;
		if(args.length >= 1){
		 plugin.toMuchArgs(p);
		}
		Location l = p.getLocation();
		int r = Integer.parseInt(args[0]);
		plugin.getConfig().set("RandomSpawnRadius", r);
		plugin.getConfig().set("RandomSpawn.x",l.getX());
		plugin.getConfig().set("RandomSpawn.y",l.getY());
		plugin.getConfig().set("RandomSpawn.z",l.getZ());
		plugin.getConfig().set("RandomSpawn.w", l.getWorld().getName());
		plugin.saveConfig();
		sender.sendMessage("Spawn set!");
	}

}
