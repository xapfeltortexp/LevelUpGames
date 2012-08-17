package us.manniL.xapfeltortexp.LevelUpGames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import us.manniL.xapfeltortexp.LevelUpGames.cmd.LevelUpGamesCommands;
import us.manniL.xapfeltortexp.LevelUpGames.cmd.lkick;
import us.manniL.xapfeltortexp.LevelUpGames.cmd.ltoggle;
import us.manniL.xapfeltortexp.LevelUpGames.listeners.LevelUpGamesListener;

public class LevelUpGamesMain extends JavaPlugin {
	public static LevelUpGamesMain Instance;
	final Logger log = Logger.getLogger("Minecraft");
	public boolean toggle;
	public boolean start;
	public ArrayList<String> players = new ArrayList<String>();
	public int limit;
	public int HowMuchCanJoin;
	private LevelUpGamesCommands lugc;
	
	public ChatColor red = ChatColor.RED;
	public ChatColor blue = ChatColor.BLUE;
	public ChatColor gray = ChatColor.GRAY;
	
	public String prefix = this.blue + "[" + this.gray + "LevelUpGames" + this.blue + "] ";
	
	public HashMap<String, SubBase> commands = new HashMap<String, SubBase>();

	public void onEnable() {
		Instance=this;
		this.lugc = new LevelUpGamesCommands(this);
		getCommand("LevelUpGames").setExecutor(this.lugc);
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		load_config();

		this.toggle = false;
		this.start = false;

		this.log.info("[LevelUpGames] Plugin successful enabled.");

		getServer().getPluginManager().registerEvents(new LevelUpGamesListener(this), this);
		
		this.getCommand("lug").setExecutor(new CommandReg(this));
		commands.clear();
		commands.put("kick", new lkick(this));
		commands.put("toggle", new ltoggle(this));
	}

	public void onDisable() {
		this.log.info("[LevelUpGames] Plugin successful disabled.");

		this.players.clear();
	}

	private void load_config() {
		this.HowMuchCanJoin = getConfig().getInt("LevelUpGames.HowMuchCanJoin", 20);
	}
	public void noPerms(Player player) {
		player.sendMessage(this.prefix + this.gray + "You dont have Permissions.");
	}

	public void toMuchArgs(Player player) {
		player.sendMessage(this.prefix + this.gray + "Wrong Usage. Type /lug for all LevelUpGames Commands.");
	}
}