package KeemaCurry.utils;

import javax.security.auth.login.LoginException;

import KeemaCurry.Client;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.ClientType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.minecraft.client.Minecraft;

public class DiscordBot extends ListenerAdapter{

	
	
	private static JDA jda = null;
    private static String BOT_TOKEN;
    
    private static String TEXT_CHANNEL;
	
    public static String getTEXT_CHANNEL() {
		return TEXT_CHANNEL;
	}



	public static void setTEXT_CHANNEL(String tEXT_CHANNEL) {
		TEXT_CHANNEL = tEXT_CHANNEL;
	}



	public static String getBOT_TOKEN() {
		return BOT_TOKEN;
	}



	public static void setBOT_TOKEN(String bOT_TOKEN) {
		BOT_TOKEN = bOT_TOKEN;
		login();
	}

	public static TextChannel tc = null;
    
	public static void login() {
	        try {
	            jda = JDABuilder.createDefault(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES)
	            		.addEventListeners(new DiscordBot())
	                    .setRawEventsEnabled(true)
	                .build();
	        } catch (LoginException e) {
	        e.printStackTrace();
	    }
	}
	
	 
	
	public static void say(String message) {
		tc = jda.getTextChannelById(TEXT_CHANNEL);
		tc.sendMessage(message).queue();
	}
	
	public static void logout() {
		jda.shutdownNow();
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(!event.getAuthor().isBot() && Client.getModuleByName("DiscordBot").isEnabled() && event.getChannel() == jda.getTextChannelById(TEXT_CHANNEL)){
			String message = "Åò1Åòl[Discord]Åòr " + "<" + event.getAuthor().getName() + "> " + event.getMessage().getContentRaw();
			Minecraft.getMinecraft().player.addChatMessage(message);
		}
		
		super.onMessageReceived(event);
	}
}
