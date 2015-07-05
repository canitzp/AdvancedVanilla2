package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class EnderIO {
    public static void EnderIO(){

        //Glass:
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 0));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 2));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 3));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 4));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 5));
        OreDictionary.registerOre("blockGlassHardened", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 2));
        OreDictionary.registerOre("blockGlassHardened", new ItemStack(Block.getBlockFromName("EnderIO:blockFusedQuartz"), 1, 4));


        //Machine Parts:
        OreDictionary.registerOre("blockMachineBlock", new ItemStack(AVItem.getItemFromName("EnderIO:itemMachinePart"), 1, 0));
        OreDictionary.registerOre("gearStone", new ItemStack(AVItem.getItemFromName("EnderIO:itemMachinePart"), 1, 1));

        AVLogger.AVinfo("EnderIO");
    }
}
