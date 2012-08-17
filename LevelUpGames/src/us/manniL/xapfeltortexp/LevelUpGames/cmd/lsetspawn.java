package us.manniL.xapfeltortexp.LevelUpGames.cmd;

import java.util.Random;

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
		int r = Integer.parseInt(args[0])+1;
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
		plugin.getConfig().set("RandomSpawnRadius", r-1);
		plugin.getConfig().set("RandomSpawn.x",l.getX());
		plugin.getConfig().set("RandomSpawn.y",l.getY());
		plugin.getConfig().set("RandomSpawn.z",l.getZ());
		plugin.saveConfig();
		sender.sendMessage("");
	}

}
