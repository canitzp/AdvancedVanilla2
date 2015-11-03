package de.canitzp.advancedvanilla2.integration.mods;

import de.canitzp.advancedvanilla2.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla2.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class OpenBlocks { //Version: OpenBlocks-1.7.10-1.4.4

    public static void postInit(){
        CheckLoadedMods.modList.add("OpenBlocks");
        //Sponge:
        AVOreDictionary.AVODBlock("blockSponge", "OpenBlocks:sponge");
        //Elevator:
        AVOreDictionary.WildcardBlock("blockElevator", "OpenBlocks:elevator");
    }
}
