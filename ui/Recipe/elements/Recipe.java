package KeemaCurry.ui.Recipe.elements;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class Recipe {
	public String name;
	
	public Item[] recipe = new Item[9];
	
	public Item[] item = new Item[9];
	
	public RecipeItemType type;
	
	
	public Recipe(String name) {
		super();
		this.name = name;
	}

	public Item[] getRecipe() {
		return recipe;
	}

	public void setRecipe(Item[] recipe) {
		this.recipe = recipe;
	}

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.item = item;
	}

	public RecipeItemType getType() {
		return type;
	}

	public void setType(RecipeItemType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
