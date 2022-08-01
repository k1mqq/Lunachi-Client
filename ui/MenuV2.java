package KeemaCurry.ui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.ui.assets.CategoryButton;
import KeemaCurry.ui.assets.CategoryButtonV2;
import KeemaCurry.ui.assets.ModuleButton;
import KeemaCurry.ui.assets.ModuleButtonV2;
import KeemaCurry.ui.assets.settings.Element;
import KeemaCurry.ui.assets.settings.Elements.CheckBox;
import KeemaCurry.ui.assets.settings.Elements.KeyBind;
import KeemaCurry.ui.assets.settings.Elements.Slider;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class MenuV2 extends GuiScreen{
	public static ArrayList<CategoryButtonV2> cButton = new ArrayList<CategoryButtonV2>();
	public static ArrayList<ModuleButtonV2> mButton = new ArrayList<ModuleButtonV2>();
	
	public static ArrayList<Element> element = new ArrayList<Element>();
	
	public static Category selectedCategory;
	
	public static Module selectedModule;
	
	int x;
	int y;
	int yoko;
	int tate;
	
	public MenuV2() {
		int i = 0;
		int count = 0;
		
        for(Category c : Category.values()) {
        	CategoryButtonV2 cb = new CategoryButtonV2(x, y+(30*i), 40, 15, c);
        	cButton.add(cb);
        	count = 0;
        	i++;
        	for(Module m : Client.getModuleByCategory(c)) {
        		count ++;
        		mButton.add(new ModuleButtonV2(cb.getX(), 10 * count + cb.getY(), 70, 12, m));
        	}
        }
        
        i=0;
        for(Setting s : Client.settings.getSettings()) {
        	if(s.getMode() == "Float" || s.getMode() == "Int") {
        		element.add(new Slider(240,125,s));
        	}else if(s.getMode() == "Key") {
        		element.add(new KeyBind(240,125,s));
        	}else if(s.getMode() == "Boolean") {
        		element.add(new CheckBox(240,125,s));
        	}
        	
        	i++;
        }
	}
	
	public void initGui()
    {
		ScaledResolution sr = new ScaledResolution(mc);
		
		x = this.width / 5;
		y = this.height / 5;
		yoko = this.width / 5 * 4;
		tate = this.height / 5 * 4;
    }
	
	protected void actionPerformed(GuiButton button) throws IOException
    {
//		if(button.id != 99) {
//			Client.modules.get(button.id).toggle();
//		}else {
//			this.mc.displayGuiScreen(new GuiIngameMenu());
//		}
		super.actionPerformed(button);
    }
	
	public void updateScreen()
    {
        super.updateScreen();
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        GL11.glEnable(3008);
		//this.drawCenteredString(fontRendererObj, mc.thePlayer.getName(), this.width / 2 +100, 30, -1);
		//GuiInventory.drawEntityOnScreen(this.width / 2 + 100, 100, 30, 0, 0,mc.thePlayer);
        //this.drawCenteredString(this.fontRendererObj, "MOD", 100, this.height / 4 - 10, 16777215);
        //this.drawString(fontRendererObj, Integer.toString(Client.job), this.width / 2 + 100, 100, -1);
        Gui.drawRect(x, y, yoko, tate, new Color(255,255,255,240).getRGB());
        Gui.drawRect(x, y, yoko, y + 10, new Color(215, 40, 235).getRGB());
        //Gui.drawRect(x, y + 19, 600, y + 10, new Color(0,0,0,50).getRGB());
        Gui.drawRect(x + 100, y, x + 101,  tate, new Color(0,0,0,50).getRGB());
        Gui.drawRect(585, 75, 595, 85, new Color(255,0,100).getRGB());
        FontUtil.normal.drawCenteredString("x", 590, 75, -1);
        FontUtil.normal.drawCenteredString(Client.name, 570, 320, new Color(215, 40, 235).getRGB());
        
        int i = 0;
        int count = 0;
        int offset = 0;
        for(CategoryButtonV2 cb : cButton) {
        	cb.setX(x);
        	cb.setY(y + (i * 15) + 10 + count * 12);
        	cb.drawScreen(mouseX, mouseY, partialTicks);
        	i++;
        	if(selectedCategory != cb.getCategory()) {
        		continue;
        	}
        	for(ModuleButtonV2 mb : mButton) {
        		if(Client.getModuleByName(mb.module.getName()).getCategory() != cb.getCategory())
            		continue;
        		mb.setX(x);
        		mb.setY(cb.y + (count*12) + 15);
        		mb.drawScreen(mouseX, mouseY, partialTicks);
        		count++;
        	}
        }
        
        
        
        if(selectedModule != null) {
        	//this.drawString(fontRendererObj, selectedModule.getName(), 235, 115, 0x00000000);
        	FontUtil.normal.drawString(selectedModule.getName(), 235, 115, 0x00000000);
        	
        	if(element != null) {
        		int ii = 0;
        		for(Element e : element) {
        			if(e.getSet().module == selectedModule) {
        				e.setY(125 + ii*20);
        				e.drawScreen(mouseX, mouseY, partialTicks);
        				ii++;
        			}
	            }
        	}
        	 
        }
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		for(CategoryButtonV2 cb : cButton) {
			cb.mouseClicked(mouseX, mouseY, mouseButton);
		}
		for(Element e : element) {
			if(e.getSet().module == selectedModule) {
				e.mouseClicked(mouseX, mouseY, mouseButton);
			}
        }
		for(ModuleButtonV2 mb : mButton) {
			if(Client.getModuleByName(mb.module.getName()).getCategory() == selectedCategory)
				mb.mouseClicked(mouseX, mouseY, mouseButton);
		}
		
		if(mouseX >= 585 && mouseX <= 595 && mouseY >= 75 && mouseY <= 85) {
			Client.saveload.save();
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		for(Element e : element) {
			if(e.getSet().module == selectedModule) {
				e.mouseReleased(mouseX, mouseY, mouseY);
			}
        }
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		for(Element e : element) {
			if(e.getSet().module == selectedModule) {
				e.keyTyped(typedChar, keyCode);
			}
        }
		super.keyTyped(typedChar, keyCode);
	}
}
