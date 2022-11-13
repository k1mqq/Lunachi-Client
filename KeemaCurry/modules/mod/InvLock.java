package KeemaCurry.modules.mod;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventPacket;
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
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class InvLock extends Module{

	public InvLock() {
		super("InvLock",Category.CLIENT);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
	}
	
	
	public void onEvent(Event e) {
		if(e instanceof EventPacket) {
		}
	}
}
