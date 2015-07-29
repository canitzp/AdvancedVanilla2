package canitzp.AdvancedLib.util;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockContainerMaker extends BlockContainer {
    private Class<? extends TileEntity> te = null;
    private int renderType = 0;
    private boolean isOpaque = false;
    private boolean renderAsNormalBlock = false;
    public BlockContainerMaker(String modid, String name, Material mat, SoundType sound, CreativeTabs tab, int hardness, String harvestTool, int toolStrenght, float light, Class<? extends TileEntity> te, int renderType, boolean isOpaque, boolean renderAsNormalBlock){
        super(mat);
        setBlockName(modid + "_" + name);
        setBlockTextureName(modid + ":" + name);
        setCreativeTab(tab);
        setHardness(hardness);
        setHarvestLevel(harvestTool, toolStrenght);
        setLightLevel(light);
        setStepSound(sound);
        this.te = te;
        this.renderType = renderType;
        this.isOpaque = isOpaque;
        this.renderAsNormalBlock = renderAsNormalBlock;
    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (rotation == 0) world.setBlockMetadataWithNotify(x, y, z, 0, 0);
        if (rotation == 1) world.setBlockMetadataWithNotify(x, y, z, 1, 3);
        if (rotation == 2) world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if (rotation == 3) world.setBlockMetadataWithNotify(x, y, z, 3, 3);
    }
    public int getRenderType() {
        return this.renderType;
    }

    public boolean isOpaqueCube() {
        return this.isOpaque;
    }

    public boolean renderAsNormalBlock() {
        return this.renderAsNormalBlock;
    }
    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        try {
            return te.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
