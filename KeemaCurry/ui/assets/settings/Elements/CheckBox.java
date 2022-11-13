package KeemaCurry.ui.assets.settings.Elements;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.ui.assets.settings.Element;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.math.MathHelper;

public class CheckBox extends Element{

	public CheckBox(float x, float y, Setting set) {
		super(x, y, set);
	}
	
	int width = 10;
	int height = 10;
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if(isHovered(mouseX,mouseY)) {
			Gui.drawRect(x +70, y, x + 70 + width, y +height, new Color(0,0,0,30).getRGB());
		}else {
			Gui.drawRect(x +70, y, x + 70 + width, y +height, new Color(0,0,0,50).getRGB());
		}
		
		if(this.getSet().value_b) {
			Gui.drawRect(x + 72, y + 2, x + 70 + width - 2, y + height - 2, new Color(215, 40, 235).getRGB());
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if(isHovered(mouseX,mouseY)) {
			this.getSet().setValue_b(!this.getSet().isValue_b());
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x + 70 && mouseX <= x + 70+ width && mouseY >= y && mouseY <= y + height;
	}
}
