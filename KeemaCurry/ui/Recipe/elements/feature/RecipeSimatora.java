package KeemaCurry.ui.Recipe.elements.feature;

import KeemaCurry.ui.Recipe.elements.Recipe;
import KeemaCurry.ui.Recipe.elements.RecipeItemType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemEndCrystal;

public class RecipeSimatora extends Recipe{

	public RecipeSimatora() {
		super("Simatora");
		this.recipe[0] = Item.REGISTRY.getObject(new ResourceLocation("end_crystal"));
		this.item[0] = new ItemArmor(ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.HEAD);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	
}
