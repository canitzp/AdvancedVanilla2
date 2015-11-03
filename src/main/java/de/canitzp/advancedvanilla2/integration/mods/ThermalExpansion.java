package de.canitzp.advancedvanilla2.integration.mods;

import de.canitzp.advancedvanilla2.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla2.util.AVOreDictionary;
import de.canitzp.advancedvanilla2.util.AVRecipe;

@SuppressWarnings("unchecked")
public class ThermalExpansion { //Version: ThermalExpansion-[1.7.10]4.0.3B1-218

    public static void postInit(){
        CheckLoadedMods.modList.add("ThermalExpansion");

        //Flux Capacitor:
        AVOreDictionary.AVODItem("itemBattery", "ThermalExpansion:capacitor", 2);
        AVOreDictionary.AVODItem("itemBatteryTier2", "ThermalExpansion:capacitor", 3);
        AVOreDictionary.AVODItem("itemBatteryTier3", "ThermalExpansion:capacitor", 4);
        AVOreDictionary.AVODItem("itemBatteryTier4", "ThermalExpansion:capacitor", 5);
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

    }
}
