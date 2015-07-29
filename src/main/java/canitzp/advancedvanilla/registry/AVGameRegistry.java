package canitzp.advancedvanilla.registry;


import cpw.mods.fml.common.registry.GameRegistry;

public class AVGameRegistry {
    public static void BlockGameRegistry(){

        if(ConfigRegistry.AtomicSmelter) GameRegistry.registerBlock(BlockRegistry.blockAtomicSmelter, "AtomicSmelter");

    }

    public static void ItemGameRegistry(){

        if(ConfigRegistry.Calculator) GameRegistry.registerItem(ItemRegistry.itemCalculator, "itemCalculator");

    }

}
