package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class Buildcraft { //Version: BuildCraft-7.0.23

    public static void postInit(){
        CheckLoadedMods.modList.add("Buildcraft");
        //Chute:
        AVOreDictionary.AVODBlock("blockHopper", "BuildCraft|Factory:blockHopper");
        //Buckets:
        AVOreDictionary.AVODItem("bucketOil", "BuildCraft|Energy:bucketOil");

    }
}
