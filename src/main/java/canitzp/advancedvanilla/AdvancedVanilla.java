package canitzp.advancedvanilla;

import canitzp.advancedvanilla.inventory.GUIHandler;
import canitzp.advancedvanilla.proxy.CommonProxy;
import canitzp.advancedvanilla.registry.BlockRegistry;
import canitzp.advancedvanilla.registry.ItemRegistry;
import canitzp.advancedvanilla.registry.ReceipeRegistry;
import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = AVStrings.modid, version = AVStrings.version, name = AVStrings.name)


public class AdvancedVanilla {
    @SidedProxy(clientSide = AVStrings.clientSidedProxy, serverSide = AVStrings.serverSidedProxy)
    public static CommonProxy proxy;
    Logger logger = LogManager.getLogger(AVStrings.name);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("PreInitialisation");
        BlockRegistry.BlockRegistry();
        ItemRegistry.ItemRegistry();
        proxy.registerTileEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler(AVStrings.modid, new GUIHandler());
    }


    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Initialisation");
        ReceipeRegistry.ReceipeRegistryInit();


    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        logger.info("PostInitialisation ");
        logger.info("Loading " + AVStrings.name+ " has completed!");
    }


}