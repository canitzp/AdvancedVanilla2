package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AE2 {
    public static void AE2(){


        //Quartz Blocks:
        OreDictionary.registerOre("blockQuartz", new ItemStack(Block.getBlockFromName("appliedenergistics2:tile.BlockQuartz")));
        OreDictionary.registerOre("blockChiseledQuartz", new ItemStack(Block.getBlockFromName("appliedenergistics2:tile.BlockQuartzChiseled")));
        OreDictionary.registerOre("blockPillarQuartz", new ItemStack(Block.getBlockFromName("appliedenergistics2:tile.BlockQuartzPillar")));

        //Glass:
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("appliedenergistics2:tile.BlockQuartzGlass")));
        OreDictionary.registerOre("blockGlass", new ItemStack(Block.getBlockFromName("appliedenergistics2:tile.BlockQuartzLamp")));

        AVLogger.AVinfo("Applied Energistics 2");
    }
}
