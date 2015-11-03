package de.canitzp.advancedvanilla2.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AVOreDictionary extends OreDictionary{
    public static void AVODBlock(String entry, String block, int meta){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, meta));
    }
    public static void AVODBlock(String entry, String block){
        AVODBlock(entry, block, 0);
    }
    public static void AVODBlock(String entry, Block block, int meta){
        OreDictionary.registerOre(entry, new ItemStack(block, 1, meta));
    }
    public static void AVODBlock(String entry, Block block){
        AVODBlock(entry, block, 0);
    }

    public static void AVODItem(String entry, String item, int meta){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, meta));
    }
    public static void AVODItem(String entry, String item){
        AVODItem(entry, item, 0);
    }
    public static void AVODItem(String entry, Item item, int meta){
        OreDictionary.registerOre(entry, new ItemStack(item, 1, meta));
    }
    public static void AVODItem(String entry, Item item){
        AVODItem(entry, item, 0);
    }

    public static void WildcardBlock(String entry, String block){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void WildcardBlock(String entry, Block block){
        OreDictionary.registerOre(entry, new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void WildcardItem(String entry, String item){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, OreDictionary.WILDCARD_VALUE));
    }
    public static void WildcardItem(String entry, Item item){
        OreDictionary.registerOre(entry, new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
    }

}
