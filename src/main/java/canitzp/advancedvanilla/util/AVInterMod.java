package canitzp.advancedvanilla.util;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class AVInterMod {

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


    public static void getIMC(List<FMLInterModComms.IMCMessage> get){
        for(FMLInterModComms.IMCMessage message : get){
            if(message.key.equalsIgnoreCase("ThermalExpansionPulveriser")){
                NBTTagCompound nbt = message.getNBTValue();
                if(nbt != null){
                    int energy = nbt.getInteger("energy");
                    ItemStack input = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("input"));
                    ItemStack firstOutput = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("firstOutput"));
                    ItemStack secondOutput = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("secondOutput"));
                    int secondOutputChance = nbt.getInteger("secondOutputChance");
                    if(energy > 0 && input != null && firstOutput != null && secondOutput == null){
                        AVRecipe.AVTEPulveriser(energy, input, firstOutput);
                    }
                    if(energy > 0 && input != null && firstOutput != null && secondOutput != null && secondOutputChance > 0){
                        AVRecipe.AVTEPulveriser(energy, input, firstOutput, secondOutput, secondOutputChance);
                    }
                }
            }
        }
    }
}
