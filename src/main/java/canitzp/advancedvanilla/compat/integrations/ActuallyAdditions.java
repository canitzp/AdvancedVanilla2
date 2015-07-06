package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import canitzp.advancedvanilla.util.AVReceipe;
import net.minecraft.item.ItemStack;

public class ActuallyAdditions {
    public static void init(){

        //MachineBlock:
        AVOreDictionary.AVODItem("blockMachineBlockWood", "ActuallyAdditions:blockMisc", 4);
        AVOreDictionary.AVODItem("blockMachineBlock", "ActuallyAdditions:blockMisc", 5);
        AVOreDictionary.AVODItem("blockMachineBlockResonant", "ActuallyAdditions:blockMisc", 9);

        //Lamps:
        AVOreDictionary.WildcardBlock("poweredLamp", "ActuallyAdditions:blockColoredLamp");

        //Buckets:
        AVOreDictionary.AVODItem("bucketOil", "ActuallyAdditions:itemBucketOil", 0);

        //Coils:
        AVOreDictionary.AVODItem("coilAdvanced", "ActuallyAdditions:itemMisc", 8);

        //Crafting Receipes:
        AVReceipe.AVODShapedBlock("ActuallyAdditions:blockCompost", "A A", "A A", "ABA", 'A', "plankWood", 'B', "blockWoodMachineBlock");
        AVReceipe.AVODShapedBlock("ActuallyAdditions:blockCanolaPress", "ABA", "ACA", "ADA", 'A', "cobblestone", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"),1 , 13)), 'D', "coilAdvanced");
        AVReceipe.AVODShapedBlock("ActuallyAdditions:blockFermentingBarrel", "ABA", "ACA", "ADA", 'A', "logWood", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"), 1, 13)), 'D', "blockWoodMachineBlock");
        AVReceipe.AVODShapedBlock("ActuallyAdditions:blockInputter", "AAA", "BCB", "AAA", 'A', "plankWood", 'B', "blockWoodMachineBlock", 'C', "blockHopper");

        //Battery:
        AVOreDictionary.AVODItem("itemBattery", "ActuallyAdditions:itemBattery", 0);


        AVLogger.AVinfo("ActuallyAdditions");
    }


}
