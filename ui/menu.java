package KeemaCurry.ui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.ui.assets.CategoryButton;
import KeemaCurry.ui.assets.ModuleButton;
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

public class menu extends GuiScreen{
	public static ArrayList<CategoryButton> cButton = new ArrayList<CategoryButton>();
	public static ArrayList<ModuleButton> mButton = new ArrayList<ModuleButton>();
	
	public static ArrayList<Element> element = new ArrayList<Element>();
	
	public static Category selectedCategory;
	
	public static Module selectedModule;
	
	public menu() {
		int i = 0;
		
        for(Category c : Category.values()) {
        	cButton.add(new CategoryButton(50 * i + 160, 80, 40, 15, c));
        	
        	i++;
        }
        i=0;
        for(Module m : Client.modules) {
        	mButton.add(new ModuleButton(150, 10 * i + 190, 70, 10, m));
        	
        	i++;
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
		//this.buttonList.add(new GuiButton(99, sr.getScaledWidth() - 45, sr.getScaledHeight() -20, 45, 20 , "Back"));
//		for(Module m : Client.modules) {
//			this.buttonList.add(new GuiButton(count, 100,  this.height / 4 + 24 + -16 + count * 20, "Toggle : " + m.name));
//			count ++;
//		}
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
        //this.drawDefaultBackground();
		//this.drawCenteredString(fontRendererObj, mc.thePlayer.getName(), this.width / 2 +100, 30, -1);
		//GuiInventory.drawEntityOnScreen(this.width / 2 + 100, 100, 30, 0, 0,mc.thePlayer);
        //this.drawCenteredString(this.fontRendererObj, "MOD", 100, this.height / 4 - 10, 16777215);
        //this.drawString(fontRendererObj, Integer.toString(Client.job), this.width / 2 + 100, 100, -1);
        Gui.drawRect(150, 70, 600, 330, new Color(255,255,255,240).getRGB());
        Gui.drawRect(150, 65, 600, 70, new Color(215, 40, 235).getRGB());
        Gui.drawRect(150, 109, 600, 110, new Color(0,0,0,50).getRGB());
        Gui.drawRect(230, 110, 231, 330, new Color(0,0,0,50).getRGB());
        Gui.drawRect(585, 75, 595, 85, new Color(255,0,100).getRGB());
        FontUtil.normal.drawCenteredString("x", 590, 75, -1);
        FontUtil.normal.drawCenteredString(Client.name, 570, 320, new Color(215, 40, 235).getRGB());
        
       
        for(CategoryButton cb : cButton) {
        	cb.drawScreen(mouseX, mouseY, partialTicks);
        }
        int i = 0;
        for(ModuleButton mb : mButton) {
        	if(Client.getModuleByName(mb.module.getName()).getCategory() != selectedCategory)
        		continue;
        	mb.setY(10 * i + 110);
        	mb.drawScreen(mouseX, mouseY, partialTicks);
        	i++;
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
		for(CategoryButton cb : cButton) {
			cb.mouseClicked(mouseX, mouseY, mouseButton);
		}
		for(Element e : element) {
			if(e.getSet().module == selectedModule) {
				e.mouseClicked(mouseX, mouseY, mouseButton);
			}
        }
		for(ModuleButton mb : mButton) {
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
