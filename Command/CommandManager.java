package KeemaCurry.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import KeemaCurry.Command.impl.Help;
import KeemaCurry.Command.impl.Outline;
import KeemaCurry.Command.impl.Toggle;
import KeemaCurry.Command.impl.state;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.modules.Module;

public class CommandManager {

	public static List<Command> commands = new ArrayList<Command>();
	
	public String prefix = ".";
	
	public CommandManager(){
		setup();
	}
	
	public void setup() {
		commands.add(new Toggle());
		commands.add(new Help());
		commands.add(new state());
		commands.add(new Outline());
	}
	
	public void handleChat(EventChat event) {
		String message = event.getMessage();
		
		if(!message.startsWith(prefix))
			return;
		
		event.setCancelled(true);
		
		message = message.substring(prefix.length());
		
		if(message.split(" ").length > 0) {
			String commandName = message.split(" ")[0];
			
			for(Command c : commands) {
				if(c.aliases.contains(commandName) || c.name.equalsIgnoreCase(commandName)) {
					c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
				}
			}
		}
	}
	
	public static Command getCommand(String string) {
		for(Command m : commands) {
			if(m.name.equalsIgnoreCase(string))
				return m;
		}
		return null;
	}
}
