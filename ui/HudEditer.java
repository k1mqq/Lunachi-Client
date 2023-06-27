package KeemaCurry.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import KeemaCurry.Client;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

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
//		final float scaleFactor = getScaleFactor();
//        GL11.glPushMatrix();
//        GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
//        mouseX = (int) (mouseX / scaleFactor);
//        mouseY = (int) (mouseY / scaleFactor);
		for(Module m : modules) {
			Client.fr.drawString(m.getName(), m.getX() + 5, m.getY() - 7, -1);
			Gui.drawRect(m.getX() - 3, m.getY() - 3, m.getX() + 3, m.getY() + 3, -1);
			if(isHovered(mouseX, mouseY, m)) {
				select = m;
			}else {
				select = null;
			}
			if(select != null && dragging) {
				select.setX(mouseX);
				select.setY(mouseY);
			}
		}
		//GL11.glPopMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		final float scaleFactor = getScaleFactor();
        mouseX = (int) (mouseX / scaleFactor);
        mouseY = (int) (mouseY / scaleFactor);
		dragging = true;
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		final float scaleFactor = getScaleFactor();
        mouseX = (int) (mouseX / scaleFactor);
        mouseY = (int) (mouseY / scaleFactor);
		dragging = false;
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
	
	public boolean isHovered(int mouseX, int mouseY,Module m) {
//		final float scaleFactor = getScaleFactor();
//        mouseX = (int) (mouseX / scaleFactor);
//        mouseY = (int) (mouseY / scaleFactor);
		return mouseX >= m.x - 3 && mouseX <= m.x + 3 && mouseY >= m.y - 3 && mouseY <= m.y + 3;
	}
	public float getScaleFactor() {
        float n;
        switch (new ScaledResolution(mc).getScaleFactor()) {
            case 1: {
                n = 0.5f;
                break;
            }
            case 3: {
                n = 1.5f;
                break;
            }
            case 4: {
                n = 2.0f;
                break;
            }
            default: {
                n = 1.0f;
                break;
            }
        }
        return 1.0f / n;
    }
}
