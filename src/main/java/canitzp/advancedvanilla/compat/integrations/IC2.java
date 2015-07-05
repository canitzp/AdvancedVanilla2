package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class IC2 {
    public static void init(){

        //Machine Block:
        OreDictionary.registerOre("blockMachineBlock", new ItemStack(Block.getBlockFromName("IC2:blockMachine"), 1, 0));

        //Wood:
        OreDictionary.registerOre("logWood", new ItemStack(Block.getBlockFromName("IC2:blockRubWood"), 1, 0));

        //Cobblestone:
        OreDictionary.registerOre("cobblestone", new ItemStack(Block.getBlockFromName("IC2:blockBasalt"), 1, 0));

        //Glass:
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("IC2:blockAlloyGlass"), 1, 0));
        OreDictionary.registerOre("blockGlassHardened", new ItemStack(Block.getBlockFromName("IC2:blockAlloyGlass"), 1, 0));

        //Iridium:
        OreDictionary.registerOre("ingotIridium", new ItemStack(AVItem.getItemFromName("IC2:itemOreIridium"), 1, 0));
        OreDictionary.registerOre("plateIridium", new ItemStack(AVItem.getItemFromName("IC2:itemPartIridium"), 1, 0));




        AVLogger.AVinfo("IndustrialCraft");
    }
}
