package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.*;

public class ThermalExpansion {
    public static void init(){ //Version: ThermalExpansion-[1.7.10]4.0.1-182
        //Recipes:
    }
    public static void postInit(){
        //Flux Capacitor:
        AVOreDictionary.AVODItem("itemBatteryLow", "ThermalExpansion:capacitor", 2);
        AVOreDictionary.AVODItem("itemBattery", "ThermalExpansion:capacitor", 3);
        AVOreDictionary.AVODItem("itemBatteryHigh", "ThermalExpansion:capacitor", 4);
        AVOreDictionary.AVODItem("itemBatteryVeryHigh", "ThermalExpansion:capacitor", 5);
        //Machine Frame:
        AVOreDictionary.AVODBlock("blockMachineBlock", "ThermalExpansion:Frame");
        AVOreDictionary.AVODBlock("blockMachineBlockHardened", "ThermalExpansion:Frame", 1);
        AVOreDictionary.AVODBlock("blockMachineBlockReinforced", "ThermalExpansion:Frame", 2);
        AVOreDictionary.AVODBlock("blockMachineBlockResonant", "ThermalExpansion:Frame", 3);
        //Sponges:
        AVOreDictionary.WildcardBlock("blockSponge", "ThermalExpansion:Sponge");
        //Coils:
        AVOreDictionary.AVODItem("coilAdvanced", "ThermalExpansion:material", 3);
        //Crafting Recipes:
        AVRecipe.AVODShapedItem("ThermalExpansion:capacitor", 4, " A ", "BCB", "ADA", 'A', "dustRedstone", 'B', "ingotElectrum", 'C', "itemBattery", 'D', "gemDiamond");

        AVLogger.AVinfo("Thermal Expansion");
    }
}
