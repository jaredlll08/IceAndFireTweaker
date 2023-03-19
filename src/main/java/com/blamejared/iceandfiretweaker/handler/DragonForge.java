package com.blamejared.iceandfiretweaker.handler;

import com.blamejared.crafttweaker.api.*;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.github.alexthe666.iceandfire.entity.DragonType;
import com.github.alexthe666.iceandfire.recipe.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:iceandfire:dragonforge>
 */
@ZenRegister
@ZenCodeType.Name("mods.iceandfire.recipe.DragonForgeRecipeManager")
@Document("mods/IceAndFire/recipe/manager/DragonForgeRecipeManager")
public class DragonForge implements IRecipeManager<DragonForgeRecipe> {
    
    /**
     * Adds a new Fire Dragon Forge recipe.
     *
     * @param name     The name of the recipe
     * @param output   The output item
     * @param input    The input Ingredient
     * @param blood    The blood Ingredient
     * @param cookTime The cook time of the recipe
     *
     * @docParam name "fire_test"
     * @docParam output <item:minecraft:diamond>
     * @docParam input <item:minecraft:dirt>
     * @docParam blood <item:minecraft:apple>
     * @docParam cookTime 200
     */
    @ZenCodeType.Method
    public void addFireRecipe(String name, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        addRecipe(name, DragonType.FIRE.getName(), output, input, blood, cookTime);
    }
    
    /**
     * Adds a new Ice Dragon Forge recipe.
     *
     * @param name     The name of the recipe
     * @param output   The output item
     * @param input    The input Ingredient
     * @param blood    The blood Ingredient
     * @param cookTime The cook time of the recipe
     *
     * @docParam name "ice_test"
     * @docParam output <item:minecraft:diamond>
     * @docParam input <item:minecraft:dirt>
     * @docParam blood <item:minecraft:apple>
     * @docParam cookTime 200
     */
    @ZenCodeType.Method
    public void addIceRecipe(String name, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        addRecipe(name, DragonType.ICE.getName(), output, input, blood, cookTime);
    }
    
    /**
     * Adds a new Lightning Dragon Forge recipe.
     *
     * @param name     The name of the recipe
     * @param output   The output item
     * @param input    The input Ingredient
     * @param blood    The blood Ingredient
     * @param cookTime The cook time of the recipe
     *
     * @docParam name "lightning_test"
     * @docParam output <item:minecraft:diamond>
     * @docParam input <item:minecraft:dirt>
     * @docParam blood <item:minecraft:apple>
     * @docParam cookTime 200
     */
    @ZenCodeType.Method
    public void addLightningRecipe(String name, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        addRecipe(name, DragonType.LIGHTNING.getName(), output, input, blood, cookTime);
    }
    
    public void addRecipe(String name, String dragonType, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        ResourceLocation id = CraftTweakerConstants.rl(fixRecipeName(name));
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new DragonForgeRecipe(id, input.asVanillaIngredient(), blood.asVanillaIngredient(), output.getInternal(), dragonType, cookTime)));
    }
    
    @Override
    public RecipeType<DragonForgeRecipe> getRecipeType() {
        return IafRecipeRegistry.DRAGON_FORGE_TYPE;
    }
}
