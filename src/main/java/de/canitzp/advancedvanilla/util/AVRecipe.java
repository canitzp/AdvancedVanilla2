package de.canitzp.advancedvanilla.util;

import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AVRecipe {

    private static boolean isItemBlockEqual(ItemBlock input1, ItemBlock input2){
        return input1.getRegistryName().equals(input2.getRegistryName());
    }
    private static boolean isRecipeInputEqual(Object[] recipe1, Object[] recipe2){
        for (int i = 0; i < recipe1.length; i++) {
            Object obj = recipe1[i];
            if (!(obj == recipe2[i]) && (obj instanceof ItemStack && !(((ItemStack) obj).isItemEqual((ItemStack) recipe2[i])))){
                return false;
            }
        }
        return true;
    }

    //Vanilla:
    public static void AVODShapedBlock(String block, int amount, int meta,  Object[] paramsOld, Object[] paramsNew){
        if(paramsOld != null){
            List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
            List<IRecipe> toRemove = new ArrayList<>(), toAdd = new ArrayList<>();
            for (IRecipe rec : recipeList){
                if(rec instanceof ShapedOreRecipe){
                    if(rec.getRecipeOutput().getItem() instanceof ItemBlock){
                        if(isItemBlockEqual((ItemBlock) rec.getRecipeOutput().getItem(), (ItemBlock) Item.getItemFromBlock(Block.getBlockFromName(block)))){
                            if(isRecipeInputEqual(((ShapedOreRecipe) rec).getInput(), new ShapedOreRecipe((Block) null, paramsOld).getInput())){
                                toRemove.add(rec);
                                break;
                            }
                        }
                    }
                }
            }
            CraftingManager.getInstance().getRecipeList().removeAll(toRemove);
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName(block), amount, meta), paramsNew));
    }
    public static void AVODShapedBlock(String block, Object[] paramsOld, Object[] paramsNew){
        AVODShapedBlock(block, 1, 0, paramsOld, paramsNew);
    }
    public static void AVODShapedBlock(String block, Object[] params){
        AVODShapedBlock(block, null, params);
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


    /*
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
    */


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

    /*
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
    */




}
