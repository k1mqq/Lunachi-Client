package KeemaCurry.modules.mod;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventPacket;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.Timer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.play.server.SPacketTitle;

public class Skill extends Module{

	public Skill() {
		super("Skill",Category.CLIENT);
	}
	
	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("”EŽÒ", this, false));
		super.setup();
	}
	
	Timer timer = new Timer();
	float count = 0;
	int color = new Color(0,255,255).getRGB();
	@Override
	public void onEvent(Event e) {
		
		
		if(Client.settings.getSettingsByMod(this).get(0).isValue_b()){
			ScaledResolution sr = new ScaledResolution(mc);
			SPacketTitle title;
			
			
			if(e instanceof EventPacket){
				if(((EventPacket) e).getPacket() instanceof SPacketTitle) {
					title = (SPacketTitle) ((EventPacket) e).getPacket();
					if(title.getMessage() != null) {
						if(title.getMessage().getFormattedText().indexOf("Pyon") != -1) {
							count = 3.5f;
							color=new Color(0,255,255).getRGB();
							
						}
						if(title.getMessage().getFormattedText().indexOf("HIT") != -1) {
							count = 2f;
							color= new Color(255,0,0).getRGB();
						}
					}
				}
			}
			
			if(e instanceof EventRenderGUI) {
				Gui.drawRect(sr.getScaledWidth() / 2 + 65, sr.getScaledHeight() / 2 + 27, sr.getScaledWidth() / 2 + 65+ count * 19, sr.getScaledHeight() / 2 + 27 +1, color);
				
			}
			if(count > 0 && timer.hasTimeElapsed((long) 500, true)) {
				count-= 0.5f;
			}
		}
		super.onEvent(e);
	}
}
