package KeemaCurry.ui.Recipe;

import java.util.ArrayList;
import java.util.List;

import KeemaCurry.ui.Recipe.elements.Recipe;
import KeemaCurry.ui.Recipe.elements.feature.RecipeSimatora;

public class RecipeManager {
	
	public List<Recipe> recipeList = new ArrayList();
	
	public RecipeManager() {
		recipeList.add(new RecipeSimatora());
	}
}
