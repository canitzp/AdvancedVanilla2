package de.canitzp.advancedvanilla.proxy;

import de.canitzp.advancedvanilla.api.AdvancedVanillaApi;
import de.canitzp.advancedvanilla.api.IBlockListener;
import de.canitzp.advancedvanilla.api.IRecipeHandler;
import de.canitzp.advancedvanilla.recipechanger.FileLoader;
import de.canitzp.advancedvanilla.recipechanger.RecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import java.util.Map;

/**
 * @author canitzp
 */
public class GuiHandler implements IGuiHandler{

    public static final int RECIPE_CHANGER = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch(ID){
            case RECIPE_CHANGER:{
                IRecipeHandler handler = getIRecipeHandlerFromBlock(world, player, x, y, z);
                return new RecipeHandler(handler, player);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch(ID){
            case RECIPE_CHANGER:{
                IRecipeHandler handler = getIRecipeHandlerFromBlock(world, player, x, y, z);
                return new RecipeHandler.RecipeHandlerGui(new RecipeHandler(handler, player), handler, player);
            }
        }
        return null;
    }

    private IRecipeHandler getIRecipeHandlerFromBlock(World world, EntityPlayer player, int x, int y, int z){
        for(IBlockListener listener : AdvancedVanillaApi.blockListener){
            IRecipeHandler handler = listener.getHandlerFromBlock(world, new BlockPos(x, y, z), player);
            if(handler != null){
                return handler;
            }
        }
        return null;
    }
}
