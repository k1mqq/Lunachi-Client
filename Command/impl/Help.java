package KeemaCurry.Command.impl;

import KeemaCurry.Client;
import KeemaCurry.Command.Command;
import KeemaCurry.Command.CommandManager;
import KeemaCurry.modules.Module;

public class Help extends Command{

	public Help() {
		super("help", "このテキストを表示", "help", "h");
	}

	@Override
	public void onCommand(String[] args, String command) {
		for(Command c : CommandManager.commands) {
			Client.addChatMessage( c.name + " " + c.description + " " + "." + c.syntax);
		}
	}

}
