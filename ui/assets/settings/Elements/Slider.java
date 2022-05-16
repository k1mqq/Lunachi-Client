package KeemaCurry.ui.assets.settings.Elements;

import java.awt.Color;

import KeemaCurry.Settings.Setting;
import KeemaCurry.ui.assets.settings.Element;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.math.MathHelper;

public class Slider extends Element{

	public Slider(float x, float y, Setting set) {
		super(x, y, set);
	}
	
	float buttonX = (x + 18 + (300 * (this.getSet().getValue_f() / (this.getSet().getMax() - this.getSet().getMin()))));
	float buttonY;
	
	boolean dragged = false;
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		FontUtil.normal.drawString(String.format("%.2f", this.getSet().getValue_f()), (int)x + 3, (int)y +7, new Color(1,0,0).getRGB());
		Gui.drawRect(x + 20, y + 11, x + 320, y + 12, new Color(0,0,0,100).getRGB());
		Gui.drawRect(x + 20, y + 11, x + 20 + (300 * (this.getSet().getValue_f() / (this.getSet().getMax() - this.getSet().getMin()))), y + 12, new Color(215, 40, 235,200).getRGB());
		buttonY = y + 9;
		buttonX = (x + 18 + (300 * (this.getSet().getValue_f() / (this.getSet().getMax() - this.getSet().getMin()))));
		Gui.drawRect(buttonX, buttonY, buttonX + 5, buttonY + 5, new Color(215, 40, 235).getRGB());
		
		
		float val = (this.getSet().getMax() - this.getSet().getMin()) / 300 * (mouseX - x - 20);
		if(dragged) {
			if(val >= this.getSet().getMin() && val <= this.getSet().getMax()) {
				this.getSet().setValue_f(val);
			}else if(val <= this.getSet().getMin()){
				this.getSet().setValue_f(this.getSet().getMin());
			}else if(val >= this.getSet().getMax()) {
				this.getSet().setValue_f(this.getSet().getMax());
			}
			
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if(mouseButton == 0 && isHovered(mouseX,mouseY))
			dragged = true;
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {
		dragged = false;
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x + 20 && mouseX <= x + 300&& mouseY >= y + 8 && mouseY <= y + 14;
	}
}
