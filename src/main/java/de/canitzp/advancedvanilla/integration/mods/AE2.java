package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class AE2 { //Version: AppliedEnergistics-rv2-stable-10

    public static void postInit(){
        CheckLoadedMods.modList.add("AE2");

        //Quartz Blocks:
        AVOreDictionary.AVODBlock("blockQuartz", "appliedenergistics2:tile.BlockQuartz");
        AVOreDictionary.AVODBlock("blockChiseledQuartz", "appliedenergistics2:tile.BlockQuartzChiseled");
        AVOreDictionary.AVODBlock("blockPillarQuartz", "appliedenergistics2:tile.BlockQuartzPillar");
        //Glass:
        AVOreDictionary.AVODBlock("blockGlass", "appliedenergistics2:tile.BlockQuartzGlass");
        AVOreDictionary.AVODBlock("blockGlass", "appliedenergistics2:tile.BlockQuartzLamp");

    }
}
