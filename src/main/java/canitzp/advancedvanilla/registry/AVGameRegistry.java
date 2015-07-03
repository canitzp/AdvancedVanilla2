package canitzp.advancedvanilla.registry;


import cpw.mods.fml.common.registry.GameRegistry;

public class AVGameRegistry {
    public static void BlockGameRegistry(){

        if(ConfigRegistry.isAtomicSmelterEnabled) GameRegistry.registerBlock(BlockRegistry.blockAtomicSmelter, "AtomicSmelter");
    }

    public static void ItemGameRegistry(){

        if(ConfigRegistry.isCalculatorEnabled) GameRegistry.registerItem(ItemRegistry.itemCalculator, "itemCalculator");

    }

}
