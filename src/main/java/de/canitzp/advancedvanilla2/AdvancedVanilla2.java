package de.canitzp.advancedvanilla2;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.canitzp.advancedvanilla2.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla2.util.AVLogger;

@Mod(modid = Strings.modid, name = Strings.name, version = Strings.version)
public class AdvancedVanilla2 {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        AVLogger.info("Start PreInitialization");
        CheckLoadedMods.preInitializeMods();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        AVLogger.info("Start Initialization");
        CheckLoadedMods.initializeMods();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        AVLogger.info("Start PostInitialization");
        CheckLoadedMods.postInitializeMods();
        AVLogger.info("Loading complete!");
    }

}
