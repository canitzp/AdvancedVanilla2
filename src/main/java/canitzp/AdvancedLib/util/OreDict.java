package canitzp.AdvancedLib.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict extends OreDictionary {

    public static void Block(String entry, String block, int meta){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, meta));
    }
    public static void Block(String entry, String block){
        Block(entry, block, 0);
    }

    public static void Item(String entry, String item, int meta){
        OreDictionary.registerOre(entry, new ItemStack(getItemFromName(item), 1, meta));
    }
    public static void Item(String entry, String item){
        Item(entry, item, 0);
    }

    public static void WildcardBlock(String entry, String block){
        OreDictionary.registerOre(entry, new ItemStack(Block.getBlockFromName(block), 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void WildcardItem(String entry, String item){
        OreDictionary.registerOre(entry, new ItemStack(getItemFromName(item), 1, OreDictionary.WILDCARD_VALUE));
    }

    public static Item getItemFromName(String name)
    {
        if (Item.itemRegistry.containsKey(name))
        {
            return (Item)Item.itemRegistry.getObject(name);
        }
        else
        {
            try
            {
                return (Item)Item.itemRegistry.getObjectById(Integer.parseInt(name));
            }
            catch (NumberFormatException numberformatexception)
            {
                return null;
            }
        }
    }
}
