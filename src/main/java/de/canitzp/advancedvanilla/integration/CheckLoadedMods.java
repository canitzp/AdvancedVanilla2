package de.canitzp.advancedvanilla.integration;

import de.canitzp.advancedvanilla.integration.mods.ActuallyAdditions;
import de.canitzp.advancedvanilla.integration.mods.VanillaNetherMetals;
import de.canitzp.advancedvanilla.integration.mods.Vanilla;
import de.canitzp.advancedvanilla.util.AVLogger;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.*;

public class CheckLoadedMods {

    public static List<String> modList = new ArrayList<>();
    public static Map<ModContainer, IMod> modsToIntegrate = new HashMap<>();
    public static Map<String, IMod> modsToLoad = new HashMap<>();

    public static void createModList(){
        modsToLoad.put("actuallyadditions", new ActuallyAdditions());
        modsToLoad.put("vanillanethermetals", new VanillaNetherMetals());


        modsToIntegrate.put(null, new Vanilla());
        for(Map.Entry<String, IMod> entry : modsToLoad.entrySet()){
            if(Loader.isModLoaded(entry.getKey())){
                modsToIntegrate.put(getModContainer(entry.getKey()), entry.getValue());
            }
        }
    }

    private static ModContainer getModContainer(String modid){
        for(ModContainer modContainer : Loader.instance().getActiveModList()){
            if(modContainer.getModId().equals(modid)){
                return modContainer;
            }
        }
        return null;
    }

    public static void preInitializeMods(FMLPreInitializationEvent event){
        createModList();
        for(IMod mod : modsToIntegrate.values()){
            mod.preInit(event);
        }
        /*
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
        */
    }

    public static void initializeMods(FMLInitializationEvent event){
        for(IMod mod : modsToIntegrate.values()){
            mod.init(event);
        }
    }

    public static void postInitializeMods(FMLPostInitializationEvent event){
        for(Map.Entry<ModContainer, IMod> entry : modsToIntegrate.entrySet()){
            entry.getValue().postInit(event);
            modList.add(entry.getValue().getModName() != null ? entry.getValue().getModName() : entry.getKey() != null ? entry.getKey().getModId() : "");
        }

        /*
        if(AE2) de.canitzp.advancedvanilla.integration.mods.AE2.postInit();
        if(Buildcraft) de.canitzp.advancedvanilla.integration.mods.Buildcraft.postInit();
        if(EnderIO) de.canitzp.advancedvanilla.integration.mods.EnderIO.postInit();
        if(ExtraUtilities) de.canitzp.advancedvanilla.integration.mods.ExtraUtilities.postInit();
        if(Forestry) de.canitzp.advancedvanilla.integration.mods.Forestry.postInit();
        if(IC2) de.canitzp.advancedvanilla.integration.mods.IC2.postInit();
        if(Mekanism) de.canitzp.advancedvanilla.integration.mods.Mekanism.postInit();
        if(MFR) de.canitzp.advancedvanilla.integration.mods.MineFactroyReloaded.postInit();
        if(TE) de.canitzp.advancedvanilla.integration.mods.ThermalExpansion.postInit();
        if(OpenBlocks) de.canitzp.advancedvanilla.integration.mods.OpenBlocks.postInit();
        if(RFTools) de.canitzp.advancedvanilla.integration.mods.RFTools.postInit();
        if(BigReactors) de.canitzp.advancedvanilla.integration.mods.BigReactors.postInit();
        */
        AVLogger.info("Loaded mod integrations: " + modList);
    }

}
