package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class Mekanism { //Version: Mekanism-1.7.10-8.1.5.252

    public static void postInit(){
        CheckLoadedMods.modList.add("Mekanism");
        //Plastic Blocks:
        AVOreDictionary.WildcardBlock("blockPlastik", "Mekanism:PlasticBlock");
        //Plastic Fences:
        AVOreDictionary.WildcardBlock("blockFence", "Mekanism:PlasticFence");
        //Machine Block:
        AVOreDictionary.AVODBlock("blockMachineBlock", "Mekanism:BasicBlock", 8);
    }
}
