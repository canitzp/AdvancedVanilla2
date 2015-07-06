package canitzp.advancedvanilla.util;


import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AVOreDictionary {
    public static void AVODBlock(String entry, String block, int meta){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, meta));
    }
    public static void AVODBlock(String entry, String block){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, 0));
    }


    public static void AVODItem(String entry, String item, int meta){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, meta));
    }
    public static void AVODItem(String entry, String item){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, 0));
    }

    public static void WildcardBlock(String entry, String block){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, Short.MAX_VALUE));
    }

    public static void WildcardItem(String entry, String item){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, Short.MAX_VALUE));
    }
}
