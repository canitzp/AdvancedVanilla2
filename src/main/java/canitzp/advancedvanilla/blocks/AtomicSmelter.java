package canitzp.advancedvanilla.blocks;

import canitzp.advancedvanilla.generic.GenericBlockContainer;
import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AtomicSmelter extends GenericBlockContainer {
    public AtomicSmelter(Material material, String name, int hardness, String tool, int toolstrenght, SoundType sound, float ll, float res, TileEntity tec) {
        super(material, name, hardness, tool, toolstrenght, sound, ll, res, tec);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float f1, float f2, float f3)
    {
        if (!world.isRemote){
            player.openGui(AVStrings.modid, 1, world, x, y, z );
        }
        return true;
    }
}
