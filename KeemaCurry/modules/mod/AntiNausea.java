package KeemaCurry.modules.mod;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class AntiNausea extends Module{

	public AntiNausea() {
		super("AntiNausea",Category.CLIENT);
	}
	
	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("Value", this, 0, 0, 0.5f, false));
		super.setup();
	}
}
