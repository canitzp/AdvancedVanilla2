package de.canitzp.advancedvanilla.integration;

import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author canitzp
 */
public interface IMod {

    default String getModName(){return null;}

    default void preInit(FMLPreInitializationEvent event){}

    default void init(FMLInitializationEvent event){}

    default void postInit(FMLPostInitializationEvent event){}

}
