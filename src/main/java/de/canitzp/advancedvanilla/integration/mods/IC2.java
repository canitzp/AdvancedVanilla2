package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class IC2 { //Version: IndustrialCraft-2-2.2.774

    public static void postInit(){
        CheckLoadedMods.modList.add("IC2");

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

    }
}
