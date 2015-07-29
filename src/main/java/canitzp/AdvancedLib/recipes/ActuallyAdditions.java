package canitzp.AdvancedLib.recipes;

import canitzp.AdvancedLib.util.NBTTC;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInterModComms;

public class ActuallyAdditions {

    public static void AACrusher(ItemStack input, ItemStack firstOutput, ItemStack secondOutput, int secondChance){
        NBTTC nbt = new NBTTC();
        nbt.setItemStack("input", input);
        nbt.setItemStack("outputOne", firstOutput);
        nbt.setItemStack("outputTwo", secondOutput);
        nbt.setInteger("secondChance", secondChance);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerCrusherRecipe", nbt);
    }
    public static void AACrusher(ItemStack input, ItemStack output){
        AACrusher(input, output, null, 0);
    }

    public static void AACoffeMachine(ItemStack input, int ID, int duration, int amplifier, int maxAmp){
        NBTTC nbt = new NBTTC();
        nbt.setItemStack("input", input);
        nbt.setInteger("id", ID);
        nbt.setInteger("duration", duration);
        nbt.setInteger("amplifier", amplifier);
        nbt.setInteger("maxAmp", maxAmp);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerCoffeeMachineRecipe", nbt);
    }

    public static void AABallOfHair(ItemStack output){
        NBTTC nbt = new NBTTC();
        nbt.setItemStack("output", output);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerBallOfHairRecipe", nbt);
    }

    public static void AATresureChest(ItemStack output, int chance, int minAmount, int maxAmount){
        NBTTC nbt = new NBTTC();
        nbt.setItemStack("output", output);
        nbt.setInteger("chance", chance);
        nbt.setInteger("minAmount", minAmount);
        nbt.setInteger("maxAmount", maxAmount);
        FMLInterModComms.sendMessage("ActuallyAdditions", "registerTreasureChestRecipe", nbt);
    }

}
