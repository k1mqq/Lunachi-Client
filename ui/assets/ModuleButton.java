package KeemaCurry.ui.assets;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.ui.menu;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class ModuleButton {
	public float x;
	public float y;
	public float width;
	
	public boolean visible;
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float height;
	public Module module;
	
	public Module getModule() {
		return module;
	}

	public boolean enable;
	
	public FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	
	public ModuleButton(float x, float y, float width, float height, Module module) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.module = module;
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if(Client.menu.selectedModule == module)
			enable = true;
		else
			enable = false;
		
		int color;
		if(module.toggled)
			color = new Color(215, 40, 235,150).getRGB();
		else
			color = new Color(0,0,0,70).getRGB();
		
		Gui.drawRect(x, y, x + width, y + height, color);
		
		if(isHovered(mouseX,mouseY)) {
			Gui.drawRect(x, y, x + width, y + height, new Color(0,0,0,70).getRGB());
		}
		
		//fr.drawString(module.getName(), (int)x + 3,(int)y + 2,-1);
		FontUtil.normal.drawString(module.getName(), (int)x + 3,(int)y +1,-1);
		
		if(isHovered2(mouseX,mouseY))
			Gui.drawRect(x + width, y + height, x + width + 10, y + height - 10, new Color(0,0,0,70).getRGB());
		Gui.drawRect(x + width, y + height, x + width + 10, y + height - 10, new Color(0,0,0,70).getRGB());
		fr.drawString(">", (int)(x + width +4),  (int)(y + height - 10), -1);
	}
	
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if(isHovered(mouseX,mouseY)) {
			module.toggle();
		}else if(isHovered2(mouseX,mouseY)) {
			Client.menu.selectedModule = module;
		}
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}
	public boolean isHovered2(int mouseX, int mouseY) {
		return mouseX >= x + width && mouseX <= x + width +10 && mouseY >= y + height -10 && mouseY <= y + height;
	}
}
