package KeemaCurry.ui.Recipe.elements;

public enum RecipeItemType {
	ARMOR("Armor"),
	WEAPON("Weapon"),
	OTHER("Other");
	String name;
	
	
	RecipeItemType(String string) {
		this.name = string;
	}
}
