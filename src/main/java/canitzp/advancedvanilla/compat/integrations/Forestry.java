package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Forestry {
    public static void init(){

        //Glass:
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 0));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 1));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 2));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 3));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 4));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 5));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 6));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 7));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 8));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 9));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 10));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 11));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 12));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 13));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 14));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("Forestry:stained"), 1, 15));

        //Chipsets:
        OreDictionary.registerOre("circuitBasic", new ItemStack(AVItem.getItemFromName("Forestry:chipsets"), 1, 0));
        OreDictionary.registerOre("circuitAdvanced", new ItemStack(AVItem.getItemFromName("Forestry:chipsets"), 1, 3));


        AVLogger.AVinfo("Forestry");
    }
}
