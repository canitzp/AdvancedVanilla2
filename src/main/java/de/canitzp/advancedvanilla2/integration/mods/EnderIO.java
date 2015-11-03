package de.canitzp.advancedvanilla2.integration.mods;

import de.canitzp.advancedvanilla2.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla2.util.AVLogger;
import de.canitzp.advancedvanilla2.util.AVOreDictionary;

@SuppressWarnings("unchecked")
public class EnderIO { //Version: EnderIO-1.7.10-2.3.0.415_beta

    public static void postInit(){
        CheckLoadedMods.modList.add("EnderIO");
        //Glass:

        //Machine Parts:
        AVOreDictionary.AVODItem("blockMachineBlock", "EnderIO:itemMachinePart");
        AVOreDictionary.AVODItem("gearStone", "EnderIO:itemMachinePart", 1);

    }
}
