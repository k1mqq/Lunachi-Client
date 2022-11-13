package KeemaCurry.ui.assets.settings;

import KeemaCurry.Settings.Setting;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class Element {
	public float x;
	public float y;
	String name;
	
	Setting set;
	
	public Setting getSet() {
		return set;
	}

	public void setSet(Setting set) {
		this.set = set;
	}

	public FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	
	public Element(float x, float y, Setting set) {
		this.x = x;
		this.y = y;
		this.set = set;
		this.name = set.getName();
	}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//fr.drawString(name, (int)x, (int)y, 0x00000000);
		FontUtil.normal.drawString(name, (int)x, (int)y, 0x00000000);
	}
	
	public void keyTyped(char typedChar, int keyCode) {
		
	}
	
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
	}
	public void mouseReleased(int mouseX, int mouseY, int state) {
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + 100 && mouseY >= y + 11 && mouseY <= y + 14;
	}
}
