package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ActuallyAdditions {
    public static void ActuallyAdditions(){

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

        //Buckets:
        OreDictionary.registerOre("bucketOil", new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemBucketOil"), 1, 0));

        //Coils:
        OreDictionary.registerOre("coilAdvanced", new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"), 1, 8));


        //Crafting Receipes:
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockCompost")), "A A", "A A", "ABA", 'A', "plankWood", 'B', "blockWoodMachineBlock"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockCanolaPress")), "ABA", "ACA", "ADA", 'A', "cobblestone", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"),1 , 13)), 'D', "coilAdvanced"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockFermentingBarrel")), "ABA", "ACA", "ADA", 'A', "logWood", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"),1 , 13)), 'D', "blockWoodMachineBlock"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockInputter")), "AAA", "BCB", "AAA", 'A', "plankWood", 'B', "blockWoodMachineBlock", 'C', "blockHopper"));

        //Battery:
        OreDictionary.registerOre("itemBattery", new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemBattery"), 1, 0));


        AVLogger.moduleLogger.info("Loaded ActuallyAdditions Module without Problems.");
    }


}
