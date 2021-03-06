package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;
import de.canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unchecked")
public class MineFactroyReloaded { //Version: MineFactoryReloaded-[1.7.10]2.8.0-104

    public static void postInit(){
        CheckLoadedMods.modList.add("MFR");
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
        //Crafting Recipes:
        AVRecipe.AVODShapedBlock("MineFactoryReloaded:road", new Object[]{"A A", " B ", "A A", 'A', (new ItemStack(Block.getBlockFromName("MineFactoryReloaded:road"), 1, 0)), 'B', "poweredLamp"}, new Object[]{"A A", " B ", "A A", 'A', (new ItemStack(Block.getBlockFromName("MineFactoryReloaded:road"), 1, 0)), 'B', "poweredLamp"});

    }
}
