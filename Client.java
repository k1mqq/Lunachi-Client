package KeemaCurry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.Event.listener.EventKey;
import KeemaCurry.Event.listener.EventPacket;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.Settings.SettingManager;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.modules.mod.AntiNausea;
import KeemaCurry.modules.mod.BossBar;
import KeemaCurry.modules.mod.BreakTime;
import KeemaCurry.modules.mod.Debag;
import KeemaCurry.modules.mod.Discord;
import KeemaCurry.modules.mod.EffectHUD;
import KeemaCurry.modules.mod.HudEditer;
import KeemaCurry.modules.mod.ItemScale;
import KeemaCurry.modules.mod.MP;
import KeemaCurry.modules.mod.NiconicoChat;
import KeemaCurry.modules.mod.NightVision;
import KeemaCurry.modules.mod.NoGlitchBlock;
import KeemaCurry.modules.mod.NoScoreboard;
import KeemaCurry.modules.mod.OutLine;
import KeemaCurry.modules.mod.PlayerHUD;
import KeemaCurry.modules.mod.Skill;
import KeemaCurry.modules.mod.SkillBind;
import KeemaCurry.modules.mod.SpawnerRenderer;
import KeemaCurry.modules.mod.TargetHUD;
import KeemaCurry.modules.mod.TorchCounter;
import KeemaCurry.modules.mod.UniqueItems;
import KeemaCurry.ui.menu;
import KeemaCurry.utils.DiscordRP;
import KeemaCurry.utils.SessionChanger;
import KeemaCurry.utils.SaveUtil.SaveLoad;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Client {
	public static String name = "Lunachi-Client", version = "2.3";
	
	public static List<Module> modules = new ArrayList<Module>();
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static SaveLoad saveload = new SaveLoad();
	
	//public static CommandManager commandmanager = new CommandManager(); 
	public static SettingManager settings;
	public static menu menu;
	
	public static FontRenderer fr = mc.fontRendererObj;
	public static DiscordRP dis; 
	
	public static int counter = 0;
	
	public static void startup() {
		settings = new SettingManager();
		Display.setTitle(name + " Ver" + version);
		FontUtil.bootstrap();
		
		//
		SessionChanger.getInstance().setUserOffline("KIMA238");
		modules.add(new Debag());
		
		//modules.add(new AutoBridging());
		modules.add(new SpawnerRenderer());
		modules.add(new PlayerHUD());
		modules.add(new EffectHUD());
		modules.add(new TorchCounter());
		modules.add(new TargetHUD());
		//modules.add(new TestMod());
		modules.add(new NoScoreboard());
		modules.add(new UniqueItems());
		modules.add(new NightVision());
		modules.add(new AntiNausea());
		modules.add(new OutLine());
		modules.add(new ItemScale());
		modules.add(new SkillBind());
		//modules.add(new States());
		modules.add(new HudEditer());
		modules.add(new NiconicoChat());
		modules.add(new Skill());
		modules.add(new MP());
		modules.add(new BossBar());
		modules.add(new Discord());
		//modules.add(new InvLock());
		modules.add(new BreakTime());
		modules.add(new NoGlitchBlock());
		
		modules.sort(Comparator.comparing(it -> it.name));
		saveload.load();
		menu = new menu();
		dis = new DiscordRP();
		dis.start();
	}
	
	public static void shutdown() {
		dis.shutdown();
		saveload.save();
	}
	
	public static void onEvent(Event e) {
		
		if(e instanceof EventChat) {
			if(((EventChat) e).isSendChat) {
			}else {
				System.out.println(((EventChat) e).getMessage());
			}
		}
		if(e instanceof EventKey) {
			if(((EventKey) e).getKey() == Keyboard.KEY_RSHIFT) {
				mc.displayGuiScreen(Client.menu);
			}
			if(((EventKey) e).getKey() == Keyboard.KEY_LSHIFT) {
				//getModuleByName("AutoBridging").toggle();
			}
		}
		if(e instanceof EventUpdate) {
			
		}
		if(e instanceof EventPacket) {
		}
		for(Module m : modules) {
			if(m.toggled) {
				m.onEvent(e);
			}
		}
	}
	
	public static void onRender() {
		for(Module m : modules) {
			if(m.toggled)
				m.onRender();
		}
	}
	
	public static void addChatMessage(String message) {
		message = "ÅòbÅòl[" + name + "]Åòr " + message;
		mc.player.addChatMessage(message);
	}

	public static Module getModuleByName(String string) {
		for(Module m : modules) {
			if(m.name.equalsIgnoreCase(string))
				return m;
		}
		return null;
	}
	
	public static List<Module> getModuleByCategory(Category c) {
		List<Module> list = new ArrayList<Module>();
		for(Module m : modules) {
			if(m.getCategory().equals(c))
				list.add(m);
		}
		return list;
	}
	public static List<Module> getEnableModule() {
		List<Module> list = new ArrayList<Module>();
		for(Module m : modules) {
			if(m.toggled)
				list.add(m);
		}
		return list;
	}
}
