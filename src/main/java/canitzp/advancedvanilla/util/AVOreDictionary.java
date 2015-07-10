package canitzp.advancedvanilla.util;


import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraftforge.oredict.OreDictionary.itemMatches;

public class AVOreDictionary extends OreDictionary{
    private static boolean hasInit = false;
    public static void AVODBlock(String entry, String block, int meta){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, meta));
    }
    public static void AVODBlock(String entry, String block){
        AVODBlock(entry, block, 0);
    }


    public static void AVODItem(String entry, String item, int meta){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, meta));
    }
    public static void AVODItem(String entry, String item){
        AVODItem(entry, item, 0);
    }

    public static void WildcardBlock(String entry, String block){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void WildcardItem(String entry, String item){
        OreDictionary.registerOre(entry, new ItemStack(AVItem.getItemFromName(item), 1, OreDictionary.WILDCARD_VALUE));
    }








}
