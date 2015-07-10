package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MineFactroyReloaded {
    public static void init(){

        //Bricks Blocks:
        AVOreDictionary.WildcardBlock("blockBricks", "MineFactoryReloaded:brick");

        //Conveyor Belts:
        AVOreDictionary.WildcardBlock("blockConveyerBelt", "MineFactoryReloaded:conveyor");

        //Machine Block:
        AVOreDictionary.AVODBlock("blockMachineBlock", "MineFactoryReloaded:machineblock");

        //Trees:
        AVOreDictionary.WildcardBlock("treeSapling", "MineFactoryReloaded:rubberwood.sapling");
        AVOreDictionary.WildcardBlock("logWood", "MineFactoryReloaded:rubberwood.log");
        AVOreDictionary.WildcardBlock("treeLeaves", "MineFactoryReloaded:rubberwood.leaves");


        //Crafting Receips:
        AVRecipe.AVODShapedBlock("MineFactoryReloaded:road", 1, "A A", " B ", "A A", 'A', (new ItemStack(Block.getBlockFromName("MineFactoryReloaded:road"), 1, 0)), 'B', "poweredLamp");

        //Replacement:


        AVLogger.AVinfo("Minefactory Reloaded");
    }
}
