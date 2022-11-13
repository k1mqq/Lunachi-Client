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

public class OutLine extends Module{

	public OutLine() {
		super("OutLine",Category.RENDER);
	}
	public void setup() {
		Client.settings.rSetting(new Setting("Red", this, 1f,0, 1, false));
		Client.settings.rSetting(new Setting("Green", this, 1f,0, 1, false));
		Client.settings.rSetting(new Setting("Blue", this, 1f,0, 1, false));
		Client.settings.rSetting(new Setting("Alpha", this, 0.4f, 0, 1, false));
		Client.settings.rSetting(new Setting("BoxAlpha", this, 0.1f, 0, 1, false));
	}
}
