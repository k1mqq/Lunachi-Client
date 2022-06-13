package KeemaCurry.modules.mod;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.DiscordBot;

public class Discord extends Module{

	public Discord() {
		super("DiscordBot",Category.CLIENT);
	}
	@Override
	public void setup() {
		
		Client.settings.rSetting(new Setting("Token", this, ""));
		Client.settings.rSetting(new Setting("Channel", this, ""));
		super.setup();
	}
	
	@Override
	public void onEnable() {
		if(Client.settings.getSettingsByMod(this).get(0).getValue_s() == null || Client.settings.getSettingsByMod(this).get(1).getValue_s() == null) {
			Client.addChatMessage("/bot token <ボットのトークン>でボットを指定、/bot channel <チャンネルのID>でチャンネルを指定してください");
		}else {
			DiscordBot.setBOT_TOKEN(Client.settings.getSettingsByMod(this).get(0).getValue_s());
			DiscordBot.setTEXT_CHANNEL(Client.settings.getSettingsByMod(this).get(1).getValue_s());
		}
		
		super.onEnable();
	}
	
	@Override
	public void setToggled(boolean parseBoolean) {
		super.setToggled(parseBoolean);
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	boolean flag = false;
	
	public void onEvent(Event e) {
		if(e instanceof EventChat) {
			if(!flag) {
				DiscordBot.setBOT_TOKEN(Client.settings.getSettingsByMod(this).get(0).getValue_s());
				DiscordBot.setTEXT_CHANNEL(Client.settings.getSettingsByMod(this).get(1).getValue_s());
				DiscordBot.login();
				flag = true;
			}
			if(((EventChat) e).isSendChat()) {
				if(((EventChat) e).getMessage().indexOf("/bot token") == 0) {
					
					e.setCancelled(true);
					String[] st = ((EventChat) e).getMessage().split(" ");
					
					DiscordBot.setBOT_TOKEN(st[2]);
					
					Client.settings.getSettingsByMod(this).get(0).setValue_s(st[2]);
					
				}else if(((EventChat) e).getMessage().indexOf("/bot channel") == 0) {
					e.setCancelled(true);
					String[] st = ((EventChat) e).getMessage().split(" ");
					
					DiscordBot.setTEXT_CHANNEL(st[2]);
					
					Client.settings.getSettingsByMod(this).get(1).setValue_s(st[2]);
					
				}else {
					try {
						DiscordBot.say("<" + mc.player.getName() + "> " + ((EventChat) e).getMessage());
					}catch (Exception ex) {
						Client.addChatMessage("§cエラーが発生しました。ボットのトークンとチャンネルを指定してください");
						ex.printStackTrace();
					}
					
				}
				
				
			}
		}
	}
}
