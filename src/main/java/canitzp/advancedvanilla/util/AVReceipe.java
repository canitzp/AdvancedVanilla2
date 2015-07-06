package canitzp.advancedvanilla.util;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class AVReceipe {
    public static void AVODShapedBlock(String block, Object... params){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName(block)), params));
    }
}
