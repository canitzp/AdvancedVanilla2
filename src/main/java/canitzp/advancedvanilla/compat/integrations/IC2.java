package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class IC2 {
    public static void init(){

        //Machine Block:
        AVOreDictionary.AVODBlock("blockMachineBlock", "IC2:blockMachine");

        //Wood:
        AVOreDictionary.AVODBlock("logWood", "IC2:blockRubWood");

        //Cobblestone:
        AVOreDictionary.AVODBlock("cobblestone", "IC2:blockBasalt");


        //Glass:
        AVOreDictionary.AVODBlock("blockGlass", "IC2:blockAlloyGlass");
        AVOreDictionary.AVODBlock("blockGlassHardened", "IC2:blockAlloyGlass");

        //Iridium:
        AVOreDictionary.AVODItem("ingotIridium", "IC2:itemOreIridium");
        AVOreDictionary.AVODItem("plateIridium", "IC2:itemPartIridium");



        AVLogger.AVinfo("IndustrialCraft 2");
    }
}
