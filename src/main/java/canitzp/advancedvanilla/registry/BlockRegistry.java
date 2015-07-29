package canitzp.advancedvanilla.registry;


import canitzp.AdvancedLib.util.BlockContainerMaker;
import canitzp.advancedvanilla.blocks.AtomicSmelter;
import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

public class BlockRegistry {
    public static Block blockAtomicSmelter;
    public static void BlockRegistry(){
        blockAtomicSmelter = new AtomicSmelter(Material.iron, "AtomicSmelter",  1, "pickaxe", 1, Block.soundTypeMetal, 0, 4, new TileEntityAtomicSmelter());
        Block testBlock = new BlockContainerMaker(AVStrings.modid, "testBlock", Material.wood, Block.soundTypeAnvil, CreativeTabs.tabBlock, 3, "pickaxe", 1, 0F, TileEntityAtomicSmelter.class, 0, false, false);
        GameRegistry.registerBlock(testBlock, "testblock");

        AVGameRegistry.BlockGameRegistry();
    }
}
