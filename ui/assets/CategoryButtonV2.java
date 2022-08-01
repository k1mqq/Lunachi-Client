package KeemaCurry.ui.assets;

import java.awt.Color;
import java.util.ArrayList;

import KeemaCurry.Client;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class CategoryButtonV2 {
	public float x;
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

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float y;
	public float width;
	public float height;
	public Category category;
	
	public boolean enable;
	
	public FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	
	public ArrayList<ModuleButtonV2> buttonList = new ArrayList<ModuleButtonV2>();
	
	public CategoryButtonV2(float x, float y, float width, float height, Category category) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.category = category;
		int count = 0;
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if(Client.menu.selectedCategory == category)
			enable = true;
		else
			enable = false;
		
		int color = new Color(0,0,0,70).getRGB();
		if(enable)
			color = new Color(215, 40, 235).getRGB();
		else if(isHovered(mouseX,mouseY))
			color = new Color(0,0,0,150).getRGB();
		
		Gui.drawRect(x, y, x + width, y + height, color);
		
		//fr.drawString(category.name(), (int)(x + x + width - fr.getStringWidth(category.name())) / 2,(int)(y + y + height - fr.FONT_HEIGHT) / 2,-1);
		FontUtil.normal.drawCenteredString(category.name(), x + (width / 2),y + (height / 2) - 2,-1);
	}
	
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if(isHovered(mouseX,mouseY))
			Client.menu.selectedCategory = category;
	}
	
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}
}
