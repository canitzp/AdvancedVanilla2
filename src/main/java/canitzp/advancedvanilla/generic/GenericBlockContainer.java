package canitzp.advancedvanilla.generic;


import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GenericBlockContainer extends BlockContainer {

    public TileEntity tec = null;

    public GenericBlockContainer(Material material, String name, int hardness, String tool, int toolstrenght, SoundType sound, float ll, float res, TileEntity tec) {
        super(material);
        setBlockName(AVStrings.blockName + name);
        setBlockTextureName(AVStrings.texture + name);
        setHardness(hardness);
        setHarvestLevel(tool, toolstrenght);
        setStepSound(sound);
        setLightLevel(ll);
        setResistance(res);
        this.tec = tec;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
        int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (rotation == 0) world.setBlockMetadataWithNotify(x, y, z, 2, 0);
        if (rotation == 1) world.setBlockMetadataWithNotify(x, y, z, 1, 3);
        if (rotation == 2) world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        if (rotation == 3) world.setBlockMetadataWithNotify(x, y, z, 3, 3);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {

            return tec;

    }
}
