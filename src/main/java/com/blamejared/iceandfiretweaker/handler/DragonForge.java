package com.blamejared.iceandfiretweaker.handler;

import com.blamejared.crafttweaker.CraftTweaker;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.*;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.*;
import com.blamejared.crafttweaker.impl.item.MCItemStackMutable;
import com.github.alexthe666.iceandfire.entity.DragonType;
import com.github.alexthe666.iceandfire.recipe.*;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.iceandfire.DragonForgeRecipeManager")
public class DragonForge implements IRecipeManager {
    
    @ZenCodeType.Method
    public void addFireRecipe(String name, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        addRecipe(name, DragonType.FIRE.getName(), output, input, blood, cookTime);
    }
    
    @ZenCodeType.Method
    public void addIceRecipe(String name, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        addRecipe(name, DragonType.ICE.getName(), output, input, blood, cookTime);
    }
    
    @ZenCodeType.Method
    public void addLightningRecipe(String name, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        addRecipe(name, DragonType.LIGHTNING.getName(), output, input, blood, cookTime);
    }
    
    @ZenCodeType.Method
    public void addRecipe(String name, String dragonType, IItemStack output, IIngredient input, IIngredient blood, int cookTime) {
        ResourceLocation id = new ResourceLocation(CraftTweaker.MODID, fixRecipeName(name));
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new DragonForgeRecipe(id, input.asVanillaIngredient(), blood.asVanillaIngredient(), output.getInternal(), dragonType, cookTime)));
    }
    
    @ZenCodeType.Method
    public void removeFireRecipe(IIngredient output) {
        removeRecipe(DragonType.FIRE.getName(), output);
    }
    
    @ZenCodeType.Method
    public void removeIceRecipe(IIngredient output) {
        removeRecipe(DragonType.ICE.getName(), output);
    }
    
    @ZenCodeType.Method
    public void removeLightningRecipe(IIngredient output) {
        removeRecipe(DragonType.LIGHTNING.getName(), output);
    }
    
    @ZenCodeType.Method
    public void removeRecipe(String dragonType, IIngredient output) {
        CraftTweakerAPI.apply(new ActionRemoveRecipe(this, iRecipe -> {
            if(!(iRecipe instanceof DragonForgeRecipe)) {
                return false;
            }
            DragonForgeRecipe recipe = (DragonForgeRecipe) iRecipe;
            return recipe.getDragonType().equals(dragonType) && output.matches(new MCItemStackMutable(recipe.getRecipeOutput()));
        }));
    }
    
    @Override
    public IRecipeType<DragonForgeRecipe> getRecipeType() {
        return IafRecipeRegistry.DRAGON_FORGE_TYPE;
    }
    
}
