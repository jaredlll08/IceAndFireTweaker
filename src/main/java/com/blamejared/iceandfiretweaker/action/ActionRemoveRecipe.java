package com.blamejared.iceandfiretweaker.action;

import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.impl.item.MCItemStackMutable;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;

import javax.annotation.Nonnull;
import java.util.Iterator;

public class ActionRemoveRecipe extends ActionDragonForgeBase {
    
    @Nonnull
    private final String dragonType;
    @Nonnull
    private final IIngredient output;
    
    public ActionRemoveRecipe(final @Nonnull String dragonType, final @Nonnull IIngredient output) {
        this.dragonType = dragonType;
        this.output = output;
    }
    
    @Override
    public void apply() {
        
        Iterator<DragonForgeRecipe> iterator = IafRecipeRegistry.ALL_FORGE_RECIPES.iterator();
        while(iterator.hasNext()) {
            DragonForgeRecipe recipe = iterator.next();
            if(output.matches(new MCItemStackMutable(recipe.getOutput()))) {
                getRecipeList(dragonType).remove(recipe);
                iterator.remove();
            }
        }
        
    }
    
    @Override
    public String describe() {
        return String.format("Removing %s Dragon Forge Recipes that output: %s", dragonType, output.getCommandString());
    }
}
