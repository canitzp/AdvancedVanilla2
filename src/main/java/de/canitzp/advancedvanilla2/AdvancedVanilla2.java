package de.canitzp.advancedvanilla2;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.canitzp.advancedvanilla2.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla2.integration.multiMod.ConfigChanger;
import de.canitzp.advancedvanilla2.integration.multiMod.DisableOres;
import de.canitzp.advancedvanilla2.util.AVLogger;

@Mod(modid = Strings.modid, name = Strings.name, version = Strings.version)
public class AdvancedVanilla2 {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        CheckLoadedMods.preInitializeMods();
        DisableOres.preInit();
        AVLogger.info("Start PreInitialization");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        CheckLoadedMods.initializeMods();
        AVLogger.info("Start Initialization");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        CheckLoadedMods.postInitializeMods();
        AVLogger.info("Start PostInitialization - Loading complete!");
    }

}
