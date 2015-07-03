package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActuallyAdditions {
    public static void ActuallyAdditions(){
        Logger logger = LogManager.getLogger(AVStrings.name + " Integration Module");

        //MachineBlock:
        OreDictionary.registerOre("blockWoodMachineBlock", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockMisc"), 1, 4));
        OreDictionary.registerOre("blockMachineBlock", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockMisc"), 1, 5));
        OreDictionary.registerOre("blockMachineBlockResonant", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockMisc"), 1, 9));

        //Lamps:
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 0));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 1));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 2));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 3));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 4));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 5));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 6));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 7));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 8));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 9));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 10));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 11));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 12));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 13));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 14));
        OreDictionary.registerOre("poweredLamp", new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockColoredLamp"), 1, 15));


        //Crafting Receipes:
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockCompost")), "W W", "W W", "WCW", 'W', "plankWood", 'C', "blockWoodMachineBlock"));

        //Battery:
        OreDictionary.registerOre("itemBattery", new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemBattery"), 1, 0));


        logger.info("Loaded ActuallyAdditions Module without Problems.");
    }


}
