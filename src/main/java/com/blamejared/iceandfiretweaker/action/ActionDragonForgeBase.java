package com.blamejared.iceandfiretweaker.action;

import com.blamejared.crafttweaker.api.actions.IRuntimeAction;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class ActionDragonForgeBase implements IRuntimeAction {
    
    protected List<DragonForgeRecipe> getRecipeList(final @Nonnull String dragonType) {
        switch(dragonType) {
            case "fire":
                return IafRecipeRegistry.FIRE_FORGE_RECIPES;
            case "ice":
                return IafRecipeRegistry.ICE_FORGE_RECIPES;
            case "lightning":
                return IafRecipeRegistry.LIGHTNING_FORGE_RECIPES;
            default:
                throw new IllegalArgumentException("Unknown dragon type: " + dragonType);
        }
    }
    
}
