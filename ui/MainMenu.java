package KeemaCurry.ui;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;

public class MainMenu extends GuiScreen{
	@Override
	public void initGui() {
		 this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2+80, 98, 20, I18n.format("menu.options", new Object[0])));
		 this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2, I18n.format("menu.singleplayer", new Object[0])));
	     this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 2 + 20, I18n.format("menu.multiplayer", new Object[0])));
	     this.buttonList.add(new GuiButton(4, this.width / 2 + 2, this.height / 2 + 80, 98, 20, I18n.format("menu.quit", new Object[0])));
	     this.buttonList.add(new GuiButton(100, this.width / 2 -100, this.height / 2+60, 98, 20, "TUSB公式"));
	     this.buttonList.add(new GuiButton(101, this.width / 2 +2, this.height / 2 + 60, 98, 20, "My Discord Server"));
	     this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, this.height / 2+90));
	     super.initGui();
	}
	
	Random random = new Random();
	int r = random.nextInt(3);
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("kima/tusb" + r + ".png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 5)
        {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
        }

        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiWorldSelection(this));
        }

        if (button.id == 2)
        {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        
        if (button.id == 4)
        {
            this.mc.shutdown();
        }
        
        if(button.id == 100) {
		    URI uri = null;
			try {
				uri = new URI("https://skyblock.jp/");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		    GuiScreen.openWebLink(uri);
        }
        if(button.id == 101) {
		    URI uri = null;
			try {
				uri = new URI("https://discord.gg/mmRVy6apBt");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		    GuiScreen.openWebLink(uri);
        }
        
        super.actionPerformed(button);
    }
}
