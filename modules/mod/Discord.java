package KeemaCurry.modules.mod;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.DiscordBot;

public class Discord extends Module{

	public Discord() {
		super("DiscordBot",Category.CLIENT);
	}
	@Override
	public void setup() {
		super.setup();
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventChat) {
			if(((EventChat) e).isSendChat()) {
				if(((EventChat) e).getMessage().indexOf("/bot token") == 0) {
					
					e.setCancelled(true);
					String[] st = ((EventChat) e).getMessage().split(" ");
					
					DiscordBot.setBOT_TOKEN(st[2]);
				}else {
					DiscordBot.say(((EventChat) e).getMessage());
				}
				
				
			}
		}
	}
}
