package de.canitzp.advancedvanilla2.integration;

import cpw.mods.fml.common.Loader;
import de.canitzp.advancedvanilla2.integration.mods.Vanilla;
import de.canitzp.advancedvanilla2.util.AVConfig;
import de.canitzp.advancedvanilla2.util.AVLogger;

import java.util.ArrayList;

public class CheckLoadedMods {

    public static ArrayList modList = new ArrayList();
    public static boolean ActuallyAdditions, AE2, Buildcraft, EnderIO, ExtraUtilities, Forestry, IC2, Mekanism, MFR, TE, OpenBlocks, RFTools, BigReactors;

    public static void preInitializeMods(){
        if(Loader.isModLoaded("ActuallyAdditions")) ActuallyAdditions = true;
        if(Loader.isModLoaded("appliedenergistics2")) AE2 = true;
        if(Loader.isModLoaded("BuildCraft|Core")) Buildcraft = true;
        if(Loader.isModLoaded("EnderIO")) EnderIO = true;
        if(Loader.isModLoaded("ExtraUtilities")) ExtraUtilities = true;
        if(Loader.isModLoaded("Forestry")) Forestry = true;
        if(Loader.isModLoaded("IC2")) IC2 = true;
        if(Loader.isModLoaded("Mekanism")) Mekanism = true;
        if(Loader.isModLoaded("MineFactoryReloaded")) MFR = true;
        if(Loader.isModLoaded("ThermalExpansion")) TE = true;
        if(Loader.isModLoaded("OpenBlocks")) OpenBlocks = true;
        if(Loader.isModLoaded("rftools")) RFTools = true;
        if(Loader.isModLoaded("BigReactors")) BigReactors = true;
    }

    public static void initializeMods(){
        configChanger();
    }

    public static void postInitializeMods(){
        Vanilla.postInit();
        if(ActuallyAdditions) de.canitzp.advancedvanilla2.integration.mods.ActuallyAdditions.postInit();
        if(AE2) de.canitzp.advancedvanilla2.integration.mods.AE2.postInit();
        if(Buildcraft) de.canitzp.advancedvanilla2.integration.mods.Buildcraft.postInit();
        if(EnderIO) de.canitzp.advancedvanilla2.integration.mods.EnderIO.postInit();
        if(ExtraUtilities) de.canitzp.advancedvanilla2.integration.mods.ExtraUtilities.postInit();
        if(Forestry) de.canitzp.advancedvanilla2.integration.mods.Forestry.postInit();
        if(IC2) de.canitzp.advancedvanilla2.integration.mods.IC2.postInit();
        if(Mekanism) de.canitzp.advancedvanilla2.integration.mods.Mekanism.postInit();
        if(MFR) de.canitzp.advancedvanilla2.integration.mods.MineFactroyReloaded.postInit();
        if(TE) de.canitzp.advancedvanilla2.integration.mods.ThermalExpansion.postInit();
        if(OpenBlocks) de.canitzp.advancedvanilla2.integration.mods.OpenBlocks.postInit();
        if(RFTools) de.canitzp.advancedvanilla2.integration.mods.RFTools.postInit();
        if(BigReactors) de.canitzp.advancedvanilla2.integration.mods.BigReactors.postInit();
        AVLogger.info("Mod Integration:" + modList);
    }

    private static void configChanger(){
        if(ActuallyAdditions) de.canitzp.advancedvanilla2.integration.mods.ActuallyAdditions.configChanger();
        AVLogger.info("AdvancedVanilla2 changed " + AVConfig.changes + " Configuration Entries.");
    }

}
