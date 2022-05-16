package KeemaCurry.modules.mod;

import java.awt.Color;
import java.util.ArrayList;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.ScoreUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class MP extends Module{

	public MP() {
		super("MP",Category.HUD);
	}
	
	@Override
	public void setup() {
		this.x = 200;
		this.y = 100;
		
		Client.settings.rSetting(new Setting("Size", this, 1, 1, 100, false));
		super.setup();
	}
	
	float maxMP = 0;
	float MP = 0;
	
	FontRenderer fr = mc.fontRendererObj;
	
	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			
			MP = ScoreUtil.getScoreByObjective("MP", mc.player);
			if(maxMP <= MP) {
				maxMP = MP;
			}
			
			Gui.drawRect(x, y, x + (10 * Client.settings.getSettingsByMod(this).get(0).getValue_f()), y + 1,new Color(0,0,0,70).getRGB());
			Gui.drawRect(x, y, x + (10 * Client.settings.getSettingsByMod(this).get(0).getValue_f() * (MP / maxMP)), y + 1,new Color(215, 40, 235).getRGB());
		}
	}
}
