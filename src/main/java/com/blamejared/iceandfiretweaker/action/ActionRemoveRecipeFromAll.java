package com.blamejared.iceandfiretweaker.action;

import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.impl.item.MCItemStackMutable;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeRegistry;

import javax.annotation.Nonnull;
import java.util.*;

public class ActionRemoveRecipeFromAll extends ActionDragonForgeBase {

    @Nonnull
    private final IIngredient output;

    private final Map<String, List<DragonForgeRecipe>> removedRecipes = new HashMap<>();

    public ActionRemoveRecipeFromAll(final @Nonnull IIngredient output) {
        this.output = output;
    }

    @Override
    public void apply() {
        Iterator<DragonForgeRecipe> iterator = IafRecipeRegistry.ALL_FORGE_RECIPES.iterator();
        while (iterator.hasNext()) {
            DragonForgeRecipe recipe = iterator.next();
            if (output.matches(new MCItemStackMutable(recipe.getOutput()))) {
                if (IafRecipeRegistry.ICE_FORGE_RECIPES.remove(recipe)) {
                    removedRecipes.computeIfAbsent(recipe.getDragonType(), (s) -> new ArrayList<>()).remove(recipe);
                }
                if (IafRecipeRegistry.FIRE_FORGE_RECIPES.remove(recipe)) {
                    removedRecipes.computeIfAbsent(recipe.getDragonType(), (s) -> new ArrayList<>()).remove(recipe);
                }
                if (IafRecipeRegistry.LIGHTNING_FORGE_RECIPES.remove(recipe)) {
                    removedRecipes.computeIfAbsent(recipe.getDragonType(), (s) -> new ArrayList<>()).remove(recipe);
                }
                iterator.remove();
            }
        }

    }

    @Override
    public String describe() {
        return String.format("Removing Dragon Forge Recipes that output: %s", output.getCommandString());
    }

    @Override
    public void undo() {
        for (String type : removedRecipes.keySet()) {
            for (DragonForgeRecipe recipe : removedRecipes.get(type)) {
                List<DragonForgeRecipe> recipeList = getRecipeList(type);
                recipeList.add(recipe);
                IafRecipeRegistry.ALL_FORGE_RECIPES.add(recipe);
            }
        }
    }

    @Override
    public String describeUndo() {
        return String.format("Undoing removal of Dragon Forge Recipes that output: %s", output.getCommandString());
    }
}
