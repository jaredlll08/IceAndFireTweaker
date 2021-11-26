package com.blamejared.iceandfiretweaker.action;

import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.impl.item.MCItemStackMutable;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;

import javax.annotation.Nonnull;
import java.util.Iterator;

public class ActionRemoveRecipeFromAll extends ActionDragonForgeBase {
    
    @Nonnull
    private final IIngredient output;
    
    public ActionRemoveRecipeFromAll(final @Nonnull IIngredient output) {
        this.output = output;
    }
    
    @Override
    public void apply() {
        Iterator<DragonForgeRecipe> iterator = IafRecipeRegistry.ALL_FORGE_RECIPES.iterator();
        while(iterator.hasNext()) {
            DragonForgeRecipe recipe = iterator.next();
            if(output.matches(new MCItemStackMutable(recipe.getOutput()))) {
                IafRecipeRegistry.ICE_FORGE_RECIPES.remove(recipe);
                IafRecipeRegistry.FIRE_FORGE_RECIPES.remove(recipe);
                IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.remove(recipe);
                iterator.remove();
            }
        }
        
    }
    
    @Override
    public String describe() {
        return String.format("Removing Dragon Forge Recipes that output: %s", output.getCommandString());
    }
}
