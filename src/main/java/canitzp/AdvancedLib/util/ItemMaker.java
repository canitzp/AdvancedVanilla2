package canitzp.AdvancedLib.util;

import net.minecraft.item.Item;

public class ItemMaker extends Item {

    public ItemMaker(String modid, String name){
        setTextureName(modid + ":" + name);
        setUnlocalizedName(modid + "_" + name);
    }
}
