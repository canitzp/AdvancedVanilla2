package canitzp.advancedvanilla;

import canitzp.advancedvanilla.compat.Integration;
import canitzp.advancedvanilla.compat.multiMod.AVModpack;
import canitzp.advancedvanilla.inventory.GUIHandler;
import canitzp.advancedvanilla.proxy.CommonProxy;
import canitzp.advancedvanilla.recipes.AtomicSmelterRecipes;
import canitzp.advancedvanilla.registry.BlockRegistry;
import canitzp.advancedvanilla.registry.ConfigRegistry;
import canitzp.advancedvanilla.registry.ItemRegistry;
import canitzp.advancedvanilla.registry.RecipeRegistry;
import canitzp.advancedvanilla.util.AVInterMod;
import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.nbt.NBTTagCompound;

import java.io.IOException;

@Mod(modid = AVStrings.modid, version = AVStrings.version, name = AVStrings.name)


public class AdvancedVanilla {
    @SidedProxy(clientSide = AVStrings.clientSidedProxy, serverSide = AVStrings.serverSidedProxy)
    public static CommonProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        AVLogger.logger.info("PreInitialization");
        AVLogger.logger.info("Thanks for using " + AVStrings.name + "!");
        ConfigRegistry.ConfigRegistry(event);
        BlockRegistry.BlockRegistry();
        ItemRegistry.ItemRegistry();
        proxy.registerTileEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler(AVStrings.modid, new GUIHandler());

        AVLogger.logger.info("PreInitialization completed");
    }
    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        AVLogger.logger.info("Initialization");
        RecipeRegistry.init();
        AtomicSmelterRecipes.init();
        Integration.init();
        AVModpack.init();
        AVLogger.logger.info("Initialization completed");
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        AVLogger.logger.info("PostInitialization");
        Integration.postInit();
        AVLogger.logger.info("Loading " + AVStrings.name + " has completed!");
    }
    @EventHandler
    public void onIMCRecived(FMLInterModComms.IMCEvent event){
        AVInterMod.getIMC(event.getMessages());
    }


}