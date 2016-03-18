package de.canitzp.advancedvanilla;


import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVLogger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AdvancedVanilla.MODID, name = AdvancedVanilla.NAME, version = AdvancedVanilla.VERSION)
public class AdvancedVanilla {

    public static final String MODID = "advancedvanilla";
    public static final String VERSION = "@VERSION@";
    public static final String NAME = "AdvacnedVanilla";

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
