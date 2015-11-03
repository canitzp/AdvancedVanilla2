package de.canitzp.advancedvanilla2.util;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.advancedvanilla2.util.AVItem;
import forestry.api.recipes.RecipeManagers;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.util.ArrayList;
import java.util.List;

public class AVRecipe {
    //Vanilla:
    public static void AVODShapedBlock(String block, int meta,  Object... params){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName(block), 1, meta), params));
    }


    public static void AVODShapedItem(String item, int meta,  Object... params){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AVItem.getItemFromName(item), 1, meta), params));
    }

    //Thermal Expansion:
    public static void AVTEPulveriser(int energy, ItemStack input, ItemStack firstOutput, ItemStack secondOutput, int secondChance){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("energy", energy);
        nbt.setTag("input", input.writeToNBT(new NBTTagCompound()));
        nbt.setTag("primaryOutput", firstOutput.writeToNBT(new NBTTagCompound()));
        if(secondOutput != null) nbt.setTag("secondaryOutput", secondOutput.writeToNBT(new NBTTagCompound())); nbt.setInteger("secondaryChance", secondChance);
        FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", nbt);

    }
    public static void AVTEPulveriser(int energy, ItemStack input, ItemStack output){
        AVTEPulveriser(energy, input, output, null, 0);
    }



    public static void AVTESagmill(int energy, ItemStack input, ItemStack firstOutput, ItemStack secondOutput, int secondChance){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("energy", energy);
        nbt.setTag("input", input.writeToNBT(new NBTTagCompound()));
        nbt.setTag("primaryOutput", firstOutput.writeToNBT(new NBTTagCompound()));
        if(secondOutput != null) nbt.setTag("secondaryOutput", secondOutput.writeToNBT(new NBTTagCompound())); nbt.setInteger("secondaryChance", secondChance);
        FMLInterModComms.sendMessage("ThermalExpansion", "SawmillRecipe", nbt);
    }
    public static void AVTESagmill(int energy, ItemStack input, ItemStack output){
        AVTESagmill(energy, input, output, null, 0);
    }




    //IndustrialCraft 2:
    public static void AVICCompressor(ItemStack input, ItemStack output){
        Recipes.compressor.addRecipe(new RecipeInputItemStack(input), null, output);
        //Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(Items.dye, 5, 15)), null, new ItemStack(Items.bone, 1));
    }
    public static void AVICCentrifuge(ItemStack input, ItemStack output){
        Recipes.centrifuge.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void AVICBlockCutter(ItemStack input, ItemStack output){
        Recipes.blockcutter.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void AVICExtractor(ItemStack input, ItemStack output){
        Recipes.extractor.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void AVICMacerator(ItemStack input, ItemStack output){
        Recipes.macerator.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void AVICOreWashing(ItemStack input, ItemStack output){
        Recipes.oreWashing.addRecipe(new RecipeInputItemStack(input), null, output);
    }

    //Forestry:
    public static void AVForestrySqueezer(int timePerItem, ItemStack[] input, FluidStack fluid){
        RecipeManagers.squeezerManager.addRecipe(timePerItem, input, fluid);
    }

    //Thaumcraft:
    public static void AVThaumcraftAspects(ItemStack input, Aspect aspect, int menge){
        if(Loader.isModLoaded("Thaumcraft")) ThaumcraftApi.registerObjectTag(input, new AspectList().add(aspect, menge));
    }
    public static void AVThaumcraftCrucible(String key, ItemStack result, Object catalyst, AspectList tags){
        ThaumcraftApi.addCrucibleRecipe(key, result, catalyst, tags);
    }


    //Mekanism:
    public static void ACMekanismCrusher(ItemStack input, ItemStack output){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("input", input.writeToNBT(new NBTTagCompound()));
        nbt.setTag("output", output.writeToNBT(new NBTTagCompound()));
        FMLInterModComms.sendMessage("mekanism", "CrusherRecipe", nbt);
    }
    public static void AVMekanismEnrichmentChamber(ItemStack input, ItemStack output){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("input", input.writeToNBT(new NBTTagCompound()));
        nbt.setTag("output", output.writeToNBT(new NBTTagCompound()));
        FMLInterModComms.sendMessage("mekanism", "EnrichmentChamberRecipe", nbt);
    }


    public static void AACrusher(ItemStack input, ItemStack firstOutput, ItemStack secondOutput, int secondChance){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("input", input.writeToNBT(new NBTTagCompound()));
        nbt.setTag("outputOne", firstOutput.writeToNBT(new NBTTagCompound()));
        nbt.setTag("outputTwo", secondOutput.writeToNBT(new NBTTagCompound()));
        nbt.setInteger("secondChance", secondChance);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerCrusherRecipe", nbt);
    }
    public static void AACrusher(ItemStack input, ItemStack output){
        AACrusher(input, output, null, 0);
    }

    public static void AACoffeMachine(ItemStack input, int ID, int duration, int amplifier, int maxAmp){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("input", input.writeToNBT(new NBTTagCompound()));
        nbt.setInteger("id", ID);
        nbt.setInteger("duration", duration);
        nbt.setInteger("amplifier", amplifier);
        nbt.setInteger("maxAmp", maxAmp);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerCoffeeMachineRecipe", nbt);
    }

    public static void AABallOfHair(ItemStack output){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("output", output.writeToNBT(new NBTTagCompound()));
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerBallOfHairRecipe", nbt);
    }

    public static void AATresureChest(ItemStack output, int chance, int minAmount, int maxAmount){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("output", output.writeToNBT(new NBTTagCompound()));
        nbt.setInteger("chance", chance);
        nbt.setInteger("minAmount", minAmount);
        nbt.setInteger("maxAmount", maxAmount);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerTreasureChestRecipe", nbt);
    }




}
