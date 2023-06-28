package KeemaCurry.modules.mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class NiconicoChat extends Module{

	public NiconicoChat() {
		super("niconicoChat", Category.HUD);
	}
	
	@Override
	public void setup() {
		super.setup();
	}

	public List<nicoText> text = new ArrayList<nicoText>();
	ScaledResolution sr = new ScaledResolution(mc);
	
	@Override
	public void onEvent(Event e) {
		if(e instanceof EventChat) {
			if(!((EventChat) e).isSendChat()) {
				e.setCancelled(true);
				text.add(new nicoText(((EventChat) e).getMessage()));
			}
		}
		
		if(e instanceof EventRenderGUI) {
			for(nicoText message : text) {
				if(message.x == -1 * mc.fontRendererObj.getStringWidth(message.message)) {
					text.remove(message);
					return;
				}
				message.render();
			}
		}
		super.onEvent(e);
	}
}

class nicoText{

	ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	String message;
	int x;
	int y;

	Timer timer = new Timer();
	
	nicoText(String message){
		this.message = message;
		
		x = sr.getScaledWidth();
		Random random = new Random();
		y = random.nextInt(sr.getScaledWidth()/3);
	}
	
	void render() {
		Client.fr.drawString(message, x, y, -1);
		if(timer.hasTimeElapsed((long) 1, true)) {
			x-= 1;
		}
	}
}