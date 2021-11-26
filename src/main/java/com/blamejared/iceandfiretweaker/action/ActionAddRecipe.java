package com.blamejared.iceandfiretweaker.action;

import com.blamejared.crafttweaker.api.item.IIngredient;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;

import javax.annotation.Nonnull;

public class ActionAddRecipe extends ActionDragonForgeBase {
    
    @Nonnull
    private final DragonForgeRecipe recipe;
    
    public ActionAddRecipe(@Nonnull DragonForgeRecipe recipe) {
        this.recipe = recipe;
    }
    
    @Override
    public void apply() {
        IafRecipeRegistry.ALL_FORGE_RECIPES.add(recipe);
        
        getRecipeList(recipe.getDragonType()).add(recipe);
    }
    
    @Override
    public String describe() {
        return String.format("Adding %s Dragon Forge Recipe, that outputs: %s, with blood: %s and input: %s", recipe.getDragonType(), recipe.getOutput(), IIngredient.fromIngredient(recipe.getBlood()), IIngredient.fromIngredient(recipe.getInput()));
    }
}
