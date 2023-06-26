package KeemaCurry.modules.mod;

import java.util.ArrayList;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EffectHUD extends Module{

	public EffectHUD() {
		super("EffectHUD",Category.HUD);
	}
	
	
	
	@Override
	public void setup() {
		x = 100;
		y = 100;
		
		Client.settings.rSetting(new Setting("Sort UP", this, false));
		Client.settings.rSetting(new Setting("Sort Right", this, false));
		super.setup();
	}
	
	
	
	public void onEvent(Event e) {
		FontRenderer fr = mc.fontRendererObj;
		ScaledResolution sr = new ScaledResolution(mc);
		
		int up = (Client.settings.getSettingsByMod(this).get(0).value_b ? -1 : +1);
		int right = (Client.settings.getSettingsByMod(this).get(1).value_b ? 1 : 0);
		
            if(e instanceof EventRenderGUI) {
            	ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
		
			int count = 1;
			for(PotionEffect effect : mc.player.getActivePotionEffects()) {
				Potion potion = effect.getPotion();
				String s1 = I18n.format(potion.getName(), new Object[0]);
	
				if(s1.equals("Health Boost"))
					continue;
	            if (effect.getAmplifier() == 1)
	            {
	                s1 = s1 + " " + I18n.format("enchantment.level.2", new Object[0]);
	            }
	            else if (effect.getAmplifier() == 2)
	            {
	                s1 = s1 + " " + I18n.format("enchantment.level.3", new Object[0]);
	            }
	            else if (effect.getAmplifier() == 3)
	            {
	                s1 = s1 + " " + I18n.format("enchantment.level.4", new Object[0]);
	            }
            	
            	//fr.drawStringWithShadow(s1 + " ��7" + Potion.getPotionDurationString(effect, 1.0F), sr.getScaledWidth() - fr.getStringWidth(s1 + " " + Potion.getPotionDurationString(effect, 1.0F)), sr.getScaledHeight() - (10 * count), potion.getLiquidColor());
            	fr.drawStringWithShadow(s1 + " \u00A7f" + Potion.getPotionDurationString(effect, 1.0F), x - (fr.getStringWidth(s1 + " " + Potion.getPotionDurationString(effect, 1.0F)) * right), y + (10 * count * up), potion.getLiquidColor());
            	count++;
            }
		}
	}
}
