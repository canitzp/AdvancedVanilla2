package canitzp.AdvancedLib.util;

import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMaker extends Block {

    public BlockMaker(String modid, String name, Material mat, SoundType sound) {
        super(mat);
        setBlockName(modid + "." + name);
        setBlockTextureName(modid + ":" + name);
        setStepSound(sound);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(1);
    }
    public BlockMaker(String modid, String name, Material mat, SoundType sound, CreativeTabs tab) {
        super(mat);
        setBlockName(modid + "_" + name);
        setBlockTextureName(modid + ":" + name);
        setCreativeTab(tab);
        setStepSound(sound);
        setHardness(1);
    }
    public BlockMaker(String modid, String name, Material mat, SoundType sound, CreativeTabs tab, int hardness, String harvestTool, int toolStrenght) {
        super(mat);
        setBlockName(modid + "_" + name);
        setBlockTextureName(modid + ":" + name);
        setCreativeTab(tab);
        setHardness(hardness);
        setHarvestLevel(harvestTool, toolStrenght);
        setStepSound(sound);
    }
    public BlockMaker(String modid, String name, Material mat, SoundType sound, CreativeTabs tab, int hardness, String harvestTool, int toolStrenght, float light) {
        super(mat);
        setBlockName(modid + "_" + name);
        setBlockTextureName(modid + ":" + name);
        setCreativeTab(tab);
        setHardness(hardness);
        setHarvestLevel(harvestTool, toolStrenght);
        setLightLevel(light);
        setStepSound(sound);
    }


}
