package us.manniL.xapfeltortexp.LevelUpGames;

import java.util.logging.Logger;

import org.bukkit.command.CommandExecutor;

public abstract class CommandBase implements CommandExecutor {
    protected LevelUpGamesMain plugin;
    protected static Logger log;

	public CommandBase(LevelUpGamesMain pl) {
        this.plugin = pl;
        CommandBase.log = pl.getLogger();
    }
}