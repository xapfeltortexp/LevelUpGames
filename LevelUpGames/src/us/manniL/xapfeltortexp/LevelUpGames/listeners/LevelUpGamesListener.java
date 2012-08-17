package us.manniL.xapfeltortexp.LevelUpGames.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import us.manniL.xapfeltortexp.LevelUpGames.LevelUpGamesMain;

public class LevelUpGamesListener implements Listener {
	private LevelUpGamesMain plugin;

	public LevelUpGamesListener(LevelUpGamesMain plugin) {
		this.plugin = LevelUpGamesMain.Instance;
	}
	@EventHandler
	public void onDeath(EntityDeathEvent e){
		
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		if(plugin.players.contains(e.getPlayer().getName())){
			e.getPlayer().teleport(e.getPlayer().getWorld().getSpawnLocation());
		}
	}
	
}