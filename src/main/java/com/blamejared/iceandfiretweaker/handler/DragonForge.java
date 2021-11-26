package com.blamejared.iceandfiretweaker.handler;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.iceandfiretweaker.action.ActionAddRecipe;
import com.blamejared.iceandfiretweaker.action.ActionRemoveRecipe;
import com.blamejared.iceandfiretweaker.action.ActionRemoveRecipeFromAll;
import com.github.alexthe666.iceandfire.entity.DragonType;
import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.iceandfire.DragonForge")
public class DragonForge {
    
    @ZenCodeType.Method
    public static void addFireRecipe(IItemStack output, IIngredient input, IIngredient blood) {
        addRecipe(DragonType.FIRE.getName(), output, input, blood);
    }
    
    @ZenCodeType.Method
    public static void addIceRecipe(IItemStack output, IIngredient input, IIngredient blood) {
        addRecipe(DragonType.ICE.getName(), output, input, blood);
    }
    
    @ZenCodeType.Method
    public static void addLightningRecipe(IItemStack output, IIngredient input, IIngredient blood) {
        addRecipe(DragonType.LIGHTNING.getName(), output, input, blood);
    }
    
    @ZenCodeType.Method
    public static void addRecipe(String dragonType, IItemStack output, IIngredient input, IIngredient blood) {
        CraftTweakerAPI.apply(new ActionAddRecipe(new DragonForgeRecipe(input.asVanillaIngredient(), blood.asVanillaIngredient(), output.getInternal(), dragonType)));
    }
    
    @ZenCodeType.Method
    public static void removeFireRecipe(IIngredient output) {
        removeRecipe(DragonType.FIRE.getName(), output);
    }
    
    @ZenCodeType.Method
    public static void removeIceRecipe(IIngredient output) {
        removeRecipe(DragonType.ICE.getName(), output);
    }
    
    @ZenCodeType.Method
    public static void removeLightningRecipe(IIngredient output) {
        removeRecipe(DragonType.LIGHTNING.getName(), output);
    }
    
    @ZenCodeType.Method
    public static void removeRecipe(String dragonType, IIngredient output) {
        CraftTweakerAPI.apply(new ActionRemoveRecipe(dragonType, output));
    }
    
    @ZenCodeType.Method
    public static void removeRecipe(IIngredient output) {
        CraftTweakerAPI.apply(new ActionRemoveRecipeFromAll(output));
    }
    
}
