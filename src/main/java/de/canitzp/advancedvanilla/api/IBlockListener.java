package de.canitzp.advancedvanilla.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author canitzp
 */
public interface IBlockListener{

    IRecipeHandler getHandlerFromBlock(World world, BlockPos pos, EntityPlayer player);

}
