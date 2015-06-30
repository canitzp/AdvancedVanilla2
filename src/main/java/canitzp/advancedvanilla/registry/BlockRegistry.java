package canitzp.advancedvanilla.registry;


import canitzp.advancedvanilla.blocks.AtomicSmelter;
import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRegistry {
    public static Block blockAtomicSmelter;
    public static void BlockRegistry(){
         blockAtomicSmelter = new AtomicSmelter(Material.iron, "AtomicSmelter",  1, "pickaxe", 1, Block.soundTypeMetal, 0, 4, new TileEntityAtomicSmelter());

        GameRegistry.registerBlock(blockAtomicSmelter, "AtomicSmelter");
    }
}
