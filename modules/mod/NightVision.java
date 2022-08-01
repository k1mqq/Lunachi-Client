package KeemaCurry.modules.mod;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class NightVision extends Module{

	public NightVision() {
		super("FullBlind",Category.CLIENT);
	}
	
	@Override
	public void setup() {
		super.setup();
	}
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			mc.gameSettings.gammaSetting = 100;
		}
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting =1;
		super.onDisable();
	}
}
