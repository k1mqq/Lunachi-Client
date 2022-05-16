package KeemaCurry.Command.impl;

import KeemaCurry.Client;
import KeemaCurry.Command.Command;
import KeemaCurry.modules.Module;

public class Toggle extends Command{

	public Toggle() {
		super("Toggle", "機能の有効、無効の切り替え", "toggle <機能名>", "t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			
			boolean foundModule = false;
			
			for(Module m : Client.modules) {
				if(m.name.equalsIgnoreCase(moduleName)) {
					m.toggle();
					
					//Client.addChatMessage((m.isEnabled() ? "Enabled " : "Disabled ") + m.name);
					
					foundModule = true;
					break;
				}
			}
			
			if(!foundModule) {
				Client.addChatMessage("機能を見つけることができませんでした");//Could not find module
			}
		}
	}

}
