package canitzp.AdvancedLib.recipes;

import canitzp.AdvancedLib.util.NBTTC;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraftforge.fluids.FluidStack;

public class ThermalExpansion {

    //Furnace:
    public static void Furnace(int energy, ItemStack input, ItemStack output){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("output", output);
        FMLInterModComms.sendMessage("ThermalExpansion", "FurnaceRecipe", nbt);
    }

    //Pulverizer:
    public static void Pulverizer(int energy, ItemStack input, ItemStack primaryOutput) {Pulverizer(energy, input, primaryOutput, null, 0);}
    public static void Pulverizer(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("primaryOutput", primaryOutput);
        nbt.setItemStack("secondaryOutput", secondaryOutput);
        nbt.setInteger("secondaryChance", secondaryChance);
        FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", nbt);
    }

    //Sawmill:
    public static void Sawmill(int energy, ItemStack input, ItemStack primaryOutput) {
        Sawmill(energy, input, primaryOutput, null, 0);}
    public static void Sawmill(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("primaryOutput", primaryOutput);
        nbt.setItemStack("secondaryOutput", secondaryOutput);
        nbt.setInteger("secondaryChance", secondaryChance);
        FMLInterModComms.sendMessage("ThermalExpansion", "SawmillRecipe", nbt);
    }

    //Smelter:
    public static void Smelter(int energy, ItemStack input, ItemStack primaryOutput) {
        Smelter(energy, input, primaryOutput, null, 0);}
    public static void Smelter(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("primaryOutput", primaryOutput);
        nbt.setItemStack("secondaryOutput", secondaryOutput);
        nbt.setInteger("secondaryChance", secondaryChance);
        FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", nbt);
    }

    //Crucible:
    public static void Crucible(int energy, ItemStack input, FluidStack output){
        NBTTC nbt =  new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("output", output);
        FMLInterModComms.sendMessage("ThermalExpansion", "CrucibleRecipe", nbt);
    }

    //Transposer:
    public static void TransposerFill(int energy, ItemStack input, ItemStack output, FluidStack fluid, boolean reversible){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("output", output);
        nbt.setItemStack("fluid", fluid);
        nbt.setBoolean("reversible", reversible);
        FMLInterModComms.sendMessage("ThermalExpansion", "TransposerFillRecipe", nbt);
    }
    public static void TransposerExtract(int energy, ItemStack input, ItemStack output, FluidStack fluid, int chance, boolean reversible){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("output", output);
        nbt.setItemStack("fluid", fluid);
        nbt.setInteger("chance", chance);
        nbt.setBoolean("reversible", reversible);
        FMLInterModComms.sendMessage("ThermalExpansion", "TransposerExtractRecipe", nbt);
    }

    //Charger:
    public static void Charger(int energy, ItemStack input, ItemStack output){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("input", input);
        nbt.setItemStack("output", output);
        FMLInterModComms.sendMessage("ThermalExpansion", "ChargerRecipe", nbt);
    }

    //Insolator:
    public static void Insolator(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack output){
        Insolator(energy, primaryInput, secondaryInput, output, null, 0);
    }
    public static void Insolator(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setItemStack("primaryInput", primaryInput);
        nbt.setItemStack("secondaryInput", secondaryInput);
        nbt.setItemStack("primaryOutput", primaryOutput);
        nbt.setItemStack("secondaryOutput", secondaryOutput);
        nbt.setInteger("secondaryChance", secondaryChance);
        FMLInterModComms.sendMessage("ThermalExpansion", "InsolatorRecipe", nbt);
    }

    //Dynamo Fuel:
    public static void MagmaticFuel(String fluidName, int energy){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setString("fluidName", fluidName);
        FMLInterModComms.sendMessage("ThermalExpansion", "MagmaticFuel", nbt);
    }
    public static void CompressionFuel(String fluidName, int energy){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setString("fluidName", fluidName);
        FMLInterModComms.sendMessage("ThermalExpansion", "CompressionFuel", nbt);
    }
    public static void ReactantFuel(String fluidName, int energy){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setString("fluidName", fluidName);
        FMLInterModComms.sendMessage("ThermalExpansion", "ReactantFuel", nbt);
    }
    public static void Coolant(String fluidName, int energy){
        NBTTC nbt = new NBTTC();
        nbt.setInteger("energy", energy);
        nbt.setString("fluidName", fluidName);
        FMLInterModComms.sendMessage("ThermalExpansion", "Coolant", nbt);
    }
}
