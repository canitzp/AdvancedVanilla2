package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExtraUtilities {
    public static void init(){

        //Conveyer Belt:
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("ExtraUtilities:conveyor"), 1, 0));

        //Cursed Earth:
        OreDictionary.registerOre("dirt", new ItemStack(Block.getBlockFromName("ExtraUtilities:cursedearthside"), 1, 0));
        OreDictionary.registerOre("blockGrass", new ItemStack(Block.getBlockFromName("ExtraUtilities:cursedearthside"), 1, 0));

        //Glass:
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 0));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 1));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 2));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 3));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 4));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 5));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:etherealglass"), 1, 10));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:decorativeBlock2"), 1, 4));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:decorativeBlock2"), 1, 7));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:decorativeBlock2"), 1, 8));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("ExtraUtilities:decorativeBlock2"), 1, 10));

        OreDictionary.registerOre("blockGlassHardened", new ItemStack(Block.getBlockFromName("ExtraUtilities:decorativeBlock2"), 1, 5));
        OreDictionary.registerOre("blockGlassHardened", new ItemStack(Block.getBlockFromName("ExtraUtilities:decorativeBlock2"), 1, 11));

        //Ingots:
        OreDictionary.registerOre("ingotBedrockium", new ItemStack(AVItem.getItemFromName("ExtraUtilities:bedrockiumIngot"), 1, 0));

        AVLogger.AVinfo("ExtraUtilities");
    }
}
