package us.manniL.xapfeltortexp.LevelUpGames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandReg extends CommandBase {
	public CommandReg(LevelUpGamesMain pl) {
		super(pl);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLine, String[] args) {
		if (cmd.getName().equalsIgnoreCase("g")) {
			if (args.length > 0) {
				String s = "";
		        for (String sa : args) {
		        	s += sa + " ";
		        }
				
				try {
					s = s.trim();
		            int i = s.indexOf(' ');
		            String s1;
		            String as[];
		            if (i < 0) {
		                s1 = s;
		                as = new String[0];
		            } else {
		                s1 = s.substring(0, i).toLowerCase();
		                as = s.substring(i).trim().split(" ");
		            }
		            if (plugin.commands.containsKey(s1)) {
		                SubBase base = (SubBase)plugin.commands.get(s1);
		                if (base == null) {
		                	sender.sendMessage("Command class not found!");
		                    return true;
		                } else {
		                		base.run(sender, as);
			                	return true;
		                }
		            } else {
		            	sender.sendMessage("Write /lg for help!");
		            	return true;
		            }
		        } catch (Exception e) {
		        	e.printStackTrace();
		        	sender.sendMessage(e.getMessage().toString());
		            return true;
		        }
			} else {
				//Insert /lug overview here!
			}
		}
		return false;
	}

}
