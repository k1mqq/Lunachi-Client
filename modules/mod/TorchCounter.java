package KeemaCurry.modules.mod;

import java.util.ArrayList;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class TorchCounter extends Module{

	public TorchCounter() {
		super("TorchCounter",Category.HUD);
	}
	
	@Override
	public void setup() {
		this.x = 200;
		this.y = 100;
		super.setup();
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			int count = 0;
			for(int i = 0; i < 9*4; i++) {
				ItemStack is = mc.player.inventory.getStackInSlot(i);
				
				if(is == null || is.getItem() == null) continue;
				
				if(Block.getBlockFromItem(is.getItem()) instanceof BlockTorch) {
					count += is.stackSize;
				}
			}
			FontRenderer fr = mc.fontRendererObj;
			ScaledResolution sr = new ScaledResolution(mc);
        	fr.drawStringWithShadow("Torch x" + count, x - fr.getStringWidth("Torch�~" + count), y, -1);
		}
	}
}
