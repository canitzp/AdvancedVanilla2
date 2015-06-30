package canitzp.advancedvanilla.registry;

import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
    public static void TileEntityRegistry(){
        GameRegistry.registerTileEntity(TileEntityAtomicSmelter.class, "TileEntityAtomicSmelter");

    }
}
