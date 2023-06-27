package KeemaCurry.modules.mod;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;

public class TargetHUD extends Module{

	public TargetHUD() {
		super("TargetHUD",Category.HUD);
	}
	
	
	
	public void onEvent(Event e) {
		if(mc.pointedEntity != null && mc.pointedEntity instanceof EntityLivingBase){
			EntityLivingBase target = (EntityLivingBase) mc.pointedEntity;
			String name = target.getName();
			float hp = target.getHealth();
				
			if(e instanceof EventRenderGUI) {
				
				FontRenderer fr = mc.fontRendererObj;
				ScaledResolution sr = new ScaledResolution(mc);
	        	fr.drawStringWithShadow(name + " " + Float.toString(Math.round(hp*10f)/10f) + "\u00A7c\u2764", 1, 1, -1);
			}
		}
	}
}
