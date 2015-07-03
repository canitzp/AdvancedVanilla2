package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MineFactroyReloaded {
    public static void MineFactroyReloaded(){
        Logger logger = LogManager.getLogger(AVStrings.name + " Integration Module");

        //Bricks Blocks:
        OreDictionary.registerOre("blockBricks", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:brick"), 1, 0));
        OreDictionary.registerOre("blockBricks", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:brick"), 1, 1));
        OreDictionary.registerOre("blockBricks", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:brick"), 1, 2));
        OreDictionary.registerOre("blockBricks", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:brick"), 1, 3));
        OreDictionary.registerOre("blockBricks", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:brick"), 1, 4));
        OreDictionary.registerOre("blockBricks", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:brick"), 1, 5));

        //Conveyor Belts:
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 0));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 1));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 2));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 3));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 4));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 5));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 6));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 7));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 8));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 9));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 10));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 11));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 12));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 13));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 14));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 15));
        OreDictionary.registerOre("blockConveyerBelt", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:conveyor"), 1, 16));

        //Machine Block:
        OreDictionary.registerOre("blockMachineBlock", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:machineblock")));

        //Trees:
        OreDictionary.registerOre("treeSapling", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.sapling"), 1, 0));
        OreDictionary.registerOre("treeSapling", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.sapling"), 1, 1));
        OreDictionary.registerOre("treeSapling", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.sapling"), 1, 2));
        OreDictionary.registerOre("treeSapling", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.sapling"), 1, 3));

        OreDictionary.registerOre("logWood", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.log"), 1, 0));
        OreDictionary.registerOre("logWood", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.log"), 1, 1));

        OreDictionary.registerOre("treeLeaves", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.leaves"), 1, 0));
        OreDictionary.registerOre("treeLeaves", new ItemStack(Block.getBlockFromName("MineFactoryReloaded:rubberwood.leaves"), 1, 1));


        //Crafting Receips:
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName("MineFactoryReloaded:road"), 4, 1), "A A", " B ", "A A", 'A', (new ItemStack(Block.getBlockFromName("MineFactoryReloaded:road"), 1, 0)), 'B', "poweredLamp"));



        logger.info("Loaded Minefactory Reloaded Module without Problems.");
    }
}
