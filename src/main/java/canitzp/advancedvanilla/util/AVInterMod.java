package canitzp.advancedvanilla.util;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class AVInterMod {
    public static int loaded = 0;
    public static void getIMC(List<FMLInterModComms.IMCMessage> get){
        for(FMLInterModComms.IMCMessage message : get){

            //ThermalExpansion:
            if(message.key.equalsIgnoreCase("ThermalExpansionPulveriser")){
                NBTTagCompound nbt = message.getNBTValue();
                if(nbt != null){
                    int energy = nbt.getInteger("energy");
                    ItemStack input = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("input"));
                    ItemStack firstOutput = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("firstOutput"));
                    ItemStack secondOutput = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("secondOutput"));
                    int secondOutputChance = nbt.getInteger("secondOutputChance");
                    if(energy > 0 && input != null && firstOutput != null && secondOutput == null){
                        loaded++;
                        AVRecipe.AVTEPulveriser(energy, input, firstOutput);
                    }
                    if(energy > 0 && input != null && firstOutput != null && secondOutput != null && secondOutputChance > 0){
                        loaded++;
                        AVRecipe.AVTEPulveriser(energy, input, firstOutput, secondOutput, secondOutputChance);
                    }
                }
            }
            if(message.key.equalsIgnoreCase("ThermalExpansionSagMill")){
                NBTTagCompound nbt = message.getNBTValue();
                if(nbt != null){
                    int energy = nbt.getInteger("energy");
                    ItemStack input = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("input"));
                    ItemStack firstOutput = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("firstOutput"));
                    ItemStack secondOutput = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("secondOutput"));
                    int secondOutputChance = nbt.getInteger("secondOutputChance");
                    if(energy > 0 && input != null && firstOutput != null && secondOutput == null){
                        loaded++;
                        AVRecipe.AVTESagmill(energy, input, firstOutput);
                    }
                    if(energy > 0 && input != null && firstOutput != null && secondOutput != null && secondOutputChance > 0){
                        loaded++;
                        AVRecipe.AVTESagmill(energy, input, firstOutput, secondOutput, secondOutputChance);
                    }
                }
            }

            //IndustrialCraft 2:
            if(message.key.equalsIgnoreCase("IC2Compressor")){
                NBTTagCompound nbt = message.getNBTValue();
                if(nbt != null){
                    ItemStack input = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("input"));
                    ItemStack output = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("output"));
                    loaded++;
                    if(input != null && output != null) AVRecipe.AVICCompressor(input, output);
                }
            }





        }
        AVLogger.AVIMC("Loaded " + loaded + " IMC Recipes.");
    }
}
