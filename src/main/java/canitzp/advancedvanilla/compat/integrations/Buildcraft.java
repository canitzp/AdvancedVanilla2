package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Buildcraft {
    public static void Buildcraft(){

        //Chute:
        OreDictionary.registerOre("blockHopper", new ItemStack(Block.getBlockFromName("BuildCraft|Factory:blockHopper"), 1, 0));

        //Buckets:
        OreDictionary.registerOre("bucketOil", new ItemStack(AVItem.getItemFromName("BuildCraft|Energy:bucketOil"), 1, 0));

        AVLogger.AVinfo("BuildCraft");
    }
}
