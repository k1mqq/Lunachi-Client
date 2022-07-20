package KeemaCurry.utils;

import java.util.List;

import KeemaCurry.Client;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TabUtil {
	static ResourceLocation resourcelocation = new ResourceLocation("stone");
    static Item item = (Item)Item.REGISTRY.getObject(resourcelocation);
	public static void getSubItems(List<ItemStack> subItems) {
	}
}
