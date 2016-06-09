package de.canitzp.advancedvanilla;


import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.proxy.CommonProxy;
import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import de.canitzp.advancedvanilla.util.AVLogger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AdvancedVanilla.MODID, name = AdvancedVanilla.NAME, version = AdvancedVanilla.VERSION)
public class AdvancedVanilla {

    public static final String MODID = "advancedvanilla";
    public static final String VERSION = "@VERSION@";
    public static final String NAME = "AdvancedVanilla";

    @Mod.Instance
    public static AdvancedVanilla instance;

    @SidedProxy(clientSide = "de.canitzp.advancedvanilla.proxy.ClientProxy", serverSide = "de.canitzp.advancedvanilla.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static boolean finishedStart = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        AVLogger.info("Start PreInitialization");
        proxy.preInit();
        CheckLoadedMods.preInitializeMods(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        AVLogger.info("Start Initialization");
        CheckLoadedMods.initializeMods(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        AVLogger.info("Start PostInitialization");
        CheckLoadedMods.postInitializeMods(event);
        RecipeHandler.postInit();
        AVLogger.info("Loading complete!");
        finishedStart = true;
    }

}
