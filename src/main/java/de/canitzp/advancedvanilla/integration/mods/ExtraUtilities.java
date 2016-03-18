package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class ExtraUtilities { //Version: ExtraUtilities-1.2.11

    public static void postInit(){
        CheckLoadedMods.modList.add("ExtraUtilities");
        //Conveyer Belt:
        AVOreDictionary.AVODBlock("blockConveyerBelt", "ExtraUtilities:conveyor");
        //Glass:
        AVOreDictionary.WildcardBlock("blockGlass", "ExtraUtilities:etherealglass");
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 4);
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 7);
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 8);
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 10);
        AVOreDictionary.AVODBlock("blockGlassHardened", "ExtraUtilities:decorativeBlock2", 5);
        AVOreDictionary.AVODBlock("blockGlassHardened", "ExtraUtilities:decorativeBlock2", 11);
        //Ingots:
        AVOreDictionary.AVODItem("ingotBedrockium", "ExtraUtilities:bedrockiumIngot");

    }
}
