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

public class ItemScale extends Module{

	public ItemScale() {
		super("ItemScale",Category.CLIENT);
	}
	
	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("Scale", this, 0,0, 1, false));
		super.setup();
	}
}
