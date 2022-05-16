package KeemaCurry.ui.assets.settings.Elements;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.ui.assets.settings.Element;
import net.minecraft.client.gui.Gui;

public class KeyBind extends Element{

	public KeyBind(float x, float y, Setting set) {
		super(x, y, set);
	}
	
	boolean hovered;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int color = -1;
		if(isHovered(mouseX, mouseY)) {
			hovered = true;
			color = new Color(0,0,0,30).getRGB();
		}else {
			hovered = false;
			color = new Color(0,0,0,50).getRGB();
		}
		Gui.drawRect(x + 100, y, x + 120, y+10, color);
		fr.drawString(Keyboard.getKeyName(this.getSet().value_key), (int)x + 108, (int)y, 0x00000000);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	public void keyTyped(char typedChar, int keyCode) {
		if(hovered && keyCode != 1) {
			this.getSet().value_key = keyCode;
		}
		super.keyTyped(typedChar, keyCode);
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x + 100 && mouseX <= x + 120&& mouseY >= y && mouseY <= y + 10;
	}
}
