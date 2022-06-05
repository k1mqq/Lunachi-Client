package KeemaCurry.utils;

import javax.security.auth.login.LoginException;

import KeemaCurry.Client;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordRP {

	boolean runnning = true;
	long created = 0;
	
	public void start() {
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			@Override
			public void apply(DiscordUser user) {
                Client.dis.update("Playing TUSB with Lunachi-!!", "");
			}
		}).build();
		
		DiscordRPC.discordInitialize("972421929443151882", handlers, true);
		
		new Thread(() -> {
			while(runnning) {
				DiscordRPC.discordRunCallbacks();
			}
		}).start();
	}
	
	public void shutdown() {
		runnning = false;
		DiscordRPC.discordShutdown();
	}
	
	
	public void update(String firstLine, String secondLine) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("main", "tokaruto");
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
}
