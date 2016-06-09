package de.canitzp.advancedvanilla.api;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author canitzp
 */
public class AdvancedVanillaApi{

    public static List<IBlockListener> blockListener = new ArrayList<>();

    public static void addBlockListener(IBlockListener listener){
        if(!blockListener.contains(listener)){
            blockListener.add(listener);
        } else {
            FMLLog.getLogger().info("[AdvancedVanillaApi]: Error while trying to register a IRecipeHandler! The Block is already defined! " + listener);
        }
    }

    public static void addBlockListener(Block block, IRecipeHandler handler){
        addBlockListener(new IBlockListener(){
            @Override
            public IRecipeHandler getHandlerFromBlock(World world, BlockPos pos, EntityPlayer player){
                return block.equals(world.getBlockState(pos).getBlock()) ? handler : null;
            }
        });
    }

    public static SaveFiles addSaveFile(String name){
        return EnumHelper.addEnum(SaveFiles.class, name.toUpperCase(), new Class[]{String.class}, name);
    }

    public enum SaveFiles{
        SHAPED_ORE("forge_shapedOre.recipes"),
        SHAPELESS_ORE("forge_shapelessOre.recipes");

        public File saveFile;
        SaveFiles(String file){
            this.saveFile = new File(Loader.instance().getConfigDir().getAbsolutePath() + File.separator + "advancedvanilla" + File.separator + "recipes" + File.separator + file);
        }
    }
}
