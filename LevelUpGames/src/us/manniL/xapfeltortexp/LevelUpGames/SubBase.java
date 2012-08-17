package us.manniL.xapfeltortexp.LevelUpGames;

import org.bukkit.command.CommandSender;

public abstract class SubBase {
	protected LevelUpGamesMain plugin;

	public SubBase(LevelUpGamesMain pl) {
			plugin = pl;
			this.plugin = LevelUpGamesMain.Instance;
	}

	public abstract void run(CommandSender sender, String[] args);
}
