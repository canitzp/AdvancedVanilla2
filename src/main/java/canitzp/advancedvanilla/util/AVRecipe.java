package canitzp.advancedvanilla.util;


import cofh.api.modhelpers.ThermalExpansionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class AVRecipe {
    public static void AVODShapedBlock(String block, int meta,  Object... params){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.getBlockFromName(block), 1, meta), params));
    }


    public static void AVODShapedItem(String item, int meta,  Object... params){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AVItem.getItemFromName(item), 1, meta), params));
    }


    public static void AVTEPulveriser(int energy, ItemStack input, ItemStack firstOutput, ItemStack secondOutput, int secondChance){
        ThermalExpansionHelper.addPulverizerRecipe(energy, input, firstOutput, secondOutput, secondChance);
    }
    public static void AVTEPulveriser(int energy, ItemStack input, ItemStack output,){
        AVTEPulveriser(energy, input, output, null, 0);
    }
}
