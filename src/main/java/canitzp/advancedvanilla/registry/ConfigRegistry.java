package canitzp.advancedvanilla.registry;

import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfigRegistry {

    public static boolean isAtomicSmelterEnabled, isCalculatorEnabled, AE2OreDictIntegrationEnabled, MFROreDictIntegrationEnabled;

    public static void ConfigRegistry(FMLPreInitializationEvent event){
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        isAtomicSmelterEnabled = config.getBoolean("AtomicSmelter_On", "blocks:", true, "Is Atomic Smelter Enabled?");
        isCalculatorEnabled = config.getBoolean("Calculator_On", "items:", true, "Is Calculator Enabled?");
        AE2OreDictIntegrationEnabled = config.getBoolean("AE2OreDictIntegrationEnabled", "integration:", true, "Is Extra OreDictionary for AE2 enabled?");
        MFROreDictIntegrationEnabled = config.getBoolean("MineFactoryReloadedOreDictIntegrationEnabled", "integration:", true, "Is Extra OreDictionary for Minefactory Reloaded enabled?");

        config.save();
        Logger logger = LogManager.getLogger(AVStrings.name);
        logger.info("Configurations Loaded");

    }
}
