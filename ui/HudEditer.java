package KeemaCurry.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KeemaCurry.Client;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class HudEditer extends GuiScreen{

	public HudEditer() {
	}
	
	public List<Module> modules = new ArrayList<Module>();
	boolean dragging;
	Module select;
	
	public void initGui()
    {
		for(Module m : Client.getModuleByCategory(Category.HUD)) {
			if(m.toggled) {
				modules.add(m);
			}
		}
		super.initGui();
    }
	
	protected void actionPerformed(GuiButton button) throws IOException
    {
		super.actionPerformed(button);
    }
	
	public void updateScreen()
    {
        super.updateScreen();
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
		for(Module m : modules) {
			Client.fr.drawString(m.getName(), m.getX() + 5, m.getY() - 7, -1);
			Gui.drawRect(m.getX() - 3, m.getY() - 3, m.getX() + 3, m.getY() + 3, -1);
			if(isHovered(mouseX, mouseY, m)) {
				select = m;
			}
			if(select != null && dragging) {
				select.setX(mouseX);
				select.setY(mouseY);
			}
		}
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		dragging = true;
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		dragging = false;
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
	
	public boolean isHovered(int mouseX, int mouseY,Module m) {
		return mouseX >= m.x - 3 && mouseX <= m.x + 3 && mouseY >= m.y - 3 && mouseY <= m.y + 3;
	}
}
