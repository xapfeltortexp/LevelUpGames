package LevelUpGames;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelUpGamesMain extends JavaPlugin {
	final Logger log = Logger.getLogger("Minecraft");
	public boolean toggle;
	public boolean start;
	public ArrayList<String> players = new ArrayList<String>();
	public int limit;
	public int HowMuchCanJoin;
	private LevelUpGamesCommands lugc;

	public void onEnable() {
		
		this.lugc = new LevelUpGamesCommands(this);
		getCommand("LevelUpGames").setExecutor(this.lugc);

		getConfig().options().copyDefaults(true);
		saveConfig();
		load_config();

		this.toggle = false;
		this.start = false;

		this.log.info("[LevelUpGames] Plugin successful enabled.");

		getServer().getPluginManager().registerEvents(new LevelUpGamesListener(this), this);
	}

	public void onDisable() {
		this.log.info("[LevelUpGames] Plugin successful disabled.");

		this.players.clear();
	}

	private void load_config() {
		this.HowMuchCanJoin = getConfig().getInt("LevelUpGames.HowMuchCanJoin", 20);
	}
}