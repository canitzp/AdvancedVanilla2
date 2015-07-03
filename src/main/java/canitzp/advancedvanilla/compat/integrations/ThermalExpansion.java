package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThermalExpansion {
    public static void ThermalExpansion(){
        Logger logger = LogManager.getLogger(AVStrings.name + " Integration Module");

        //Flux Capacitor:
        OreDictionary.registerOre("itemBatteryLow", new ItemStack(AVItem.getItemFromName("ThermalExpansion:capacitor"), 1, 2));
        OreDictionary.registerOre("itemBattery", new ItemStack(AVItem.getItemFromName("ThermalExpansion:capacitor"), 1, 3));
        OreDictionary.registerOre("itemBatteryHigh", new ItemStack(AVItem.getItemFromName("ThermalExpansion:capacitor"), 1, 4));
        OreDictionary.registerOre("itemBatteryVeryHigh", new ItemStack(AVItem.getItemFromName("ThermalExpansion:capacitor"), 1, 5));

        //Machine Frame:
        OreDictionary.registerOre("blockMachineBlock", new ItemStack(Block.getBlockFromName("ThermalExpansion:Frame"), 1, 0));
        OreDictionary.registerOre("blockMachineBlockHardened", new ItemStack(Block.getBlockFromName("ThermalExpansion:Frame"), 1, 1));
        OreDictionary.registerOre("blockMachineBlockReinforced", new ItemStack(Block.getBlockFromName("ThermalExpansion:Frame"), 1, 2));
        OreDictionary.registerOre("blockMachineBlockResonant", new ItemStack(Block.getBlockFromName("ThermalExpansion:Frame"), 1, 3));

        //Crafting Receipes:
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AVItem.getItemFromName("ThermalExpansion:capacitor"),1 , 4), " A ", "BCB", "ADA", 'A', "dustRedstone", 'B', "ingotElectrum", 'C', "itemBattery", 'D', "gemDiamond"));

        logger.info("Loaded Thermal Expansion Module without Problems.");
    }
}
