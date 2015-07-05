package canitzp.advancedvanilla.registry;

import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfigRegistry {

    public static boolean AtomicSmelter, Calculator, AE2Integration, MFRIntegration;
    public static boolean ActuallyAdditionsIntegration, ThermalExpansionIntegration, EnderIOIntegration;
    public static boolean IC2Integration, BuildCraftIntegration, ForestryIntegration, ExtraUtilitiesIntegration;

    public static void ConfigRegistry(FMLPreInitializationEvent event){
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        //Blocks:
        AtomicSmelter = config.getBoolean("AtomicSmelter", "blocks:", true, "Is Atomic Smelter Enabled?");
        //Items:
        Calculator = config.getBoolean("Calculator", "items:", true, "Is Calculator Enabled?");
        //Integrations:
        AE2Integration = config.getBoolean("AE2Integration", "integration:", true, "Is Extra OreDictionary for AE2 enabled?");
        MFRIntegration = config.getBoolean("MFRIntegration", "integration:", true, "Is Extra OreDictionary for Minefactory Reloaded enabled?");
        ActuallyAdditionsIntegration = config.getBoolean("ActuallyAdditionsIntegration", "integration:", true, "Is Extra OreDictionary for ActuallyAdditions enabled?");
        ThermalExpansionIntegration = config.getBoolean("ThermalExpansionIntegration", "integration:", true, "Is Extra OreDictionary for Thermal Expansion enabled?");
        EnderIOIntegration = config.getBoolean("EnderIOIntegration", "integration:", true, "Is Extra OreDictionary for EnderIO enabled?");
        IC2Integration = config.getBoolean("IC2Integration", "integration:", true, "Is Integration for IC2 enabled?");
        BuildCraftIntegration = config.getBoolean("BuildCraftIntegration", "integration:", true, "Is Integration for Buildcraft enabled?");
        ForestryIntegration = config.getBoolean("ForestryIntegration", "integration:", true, "Is Integration for Forestry enabled?");
        ExtraUtilitiesIntegration = config.getBoolean("ExtraUtilitiesIntegration", "integration:", true, "Is Integration for ExtraUtilities enabled?");

        config.save();
        AVLogger.logger.info("Configurations Loaded");

    }
}
