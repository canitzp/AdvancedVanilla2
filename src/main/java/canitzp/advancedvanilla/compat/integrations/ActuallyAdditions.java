package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;

public class ActuallyAdditions { //Version: ActuallyAdditions-1.7.10-0.0.7.3

    public static void init(){
        //Recipe:
        AVInterMod.AACoffeMachine(new ItemStack(Blocks.red_mushroom), 19, 10, 1, 1);

        AVRecipe.AVThaumcraftAspects(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockMisc"), 0, 4), Aspect.CLOTH, 1);

        AVLogger.AVIML("ActuallyAdditions");
    }

    public static void postInit(){
        //MachineBlock:
        AVOreDictionary.AVODItem("blockMachineBlockWood", "ActuallyAdditions:blockMisc", 4);
        AVOreDictionary.AVODItem("blockMachineBlockStone", "ActuallyAdditions:blockMisc", 5);
        AVOreDictionary.AVODItem("blockMachineBlockResonant", "ActuallyAdditions:blockMisc", 9);
        //Lamps:
        AVOreDictionary.WildcardBlock("poweredLamp", "ActuallyAdditions:blockColoredLamp");
        //Buckets:
        AVOreDictionary.AVODItem("bucketOil", "ActuallyAdditions:itemBucketOil", 0);
        //Coils:
        AVOreDictionary.AVODItem("coilAdvanced", "ActuallyAdditions:itemMisc", 8);
        //Crafting Receipes:
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockCompost", 0, "A A", "A A", "ABA", 'A', "plankWood", 'B', "blockWoodMachineBlock");
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockCanolaPress", 0, "ABA", "ACA", "ADA", 'A', "cobblestone", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"), 1, 13)), 'D', "coilAdvanced");
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockFermentingBarrel", 0, "ABA", "ACA", "ADA", 'A', "logWood", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"), 1, 13)), 'D', "blockWoodMachineBlock");
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockInputter", 0, "AAA", "BCB", "AAA", 'A', "plankWood", 'B', "blockWoodMachineBlock", 'C', "blockHopper");
        //Battery:
        AVOreDictionary.AVODItem("itemBattery", "ActuallyAdditions:itemBattery", 0);

        AVLogger.AVinfo("ActuallyAdditions");
    }





}
