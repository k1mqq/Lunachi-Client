package KeemaCurry.ui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.modules.mod.States;
import KeemaCurry.ui.assets.CategoryButton;
import KeemaCurry.ui.assets.ModuleButton;
import KeemaCurry.ui.assets.settings.Element;
import KeemaCurry.ui.assets.settings.Elements.CheckBox;
import KeemaCurry.ui.assets.settings.Elements.KeyBind;
import KeemaCurry.ui.assets.settings.Elements.Slider;
import KeemaCurry.utils.PlayerUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.world.GameType;

public class StatesUI extends GuiScreen{

	public StatesUI() {
	}
	
	public void initGui()
    {
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
		States statesMod =  (States) Client.getModuleByName("States");
		Gui.drawRect(150, 70, 600, 330, -1);
		
		
        int l2 = 8 + 0;//0 8
        int i3 = 8 * 1;//1 -1
        GlStateManager.scale(4, 4, 1);
        if(PlayerUtil.getSkinByName(mc.player.getName()) != null) {
	        mc.getTextureManager().bindTexture(PlayerUtil.getSkinByName(mc.player.getName()));
	        Gui.drawScaledCustomSizeModalRect((150 + 10) / 4, (70 + 10) / 4, 8.0F, (float)l2, 8, i3, 8, 8, 64.0F, 64.0F);
        }
        GlStateManager.scale(0.25, 0.25, 1);
        
        fontRendererObj.drawString(mc.player.getName() + (statesMod.toLevel - statesMod.xp), 150 + 50, 70 + 10, 0x00000000);
		
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
}
