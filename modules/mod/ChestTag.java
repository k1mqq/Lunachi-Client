package KeemaCurry.modules.mod;

import java.awt.Color;

import KeemaCurry.Event.Event;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class ChestTag extends Module{

	public ChestTag() {
		super("ChestTags",Category.RENDER);
	}
	
	float f = 5;
	int color = new Color(255,255,47).getRGB();
	
	public void onRender() {
	}
	
	public void onEvent(Event e) {
		
	}
}
