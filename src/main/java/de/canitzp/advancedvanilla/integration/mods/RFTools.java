package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class RFTools { //Version: RFTools-4.01

    public static void postInit(){
        CheckLoadedMods.modList.add("RFTools");

        //Books:
        AVOreDictionary.AVODItem("itemBook", "rftools:rfToolsManualItem");
        AVOreDictionary.AVODItem("itemBook", "rftools:rfToolsManualDimensionItem");
        //Ore:
        AVOreDictionary.AVODBlock("oreDimensionalShard", "rftools:dimensionalShardBlock");
        //Dimlets:
        AVOreDictionary.WildcardItem("dimletControlCircuit", "rftools:dimletControlCircuitItem");
        AVOreDictionary.WildcardItem("dimletTypes", "rftools:dimletTypeControllerItem");
        AVOreDictionary.WildcardItem("dimletMemoryCircuit", "rftools:dimletMemoryUnitItem");
        AVOreDictionary.WildcardItem("dimletKnown", "rftools:knownDimlet");
    }
}
