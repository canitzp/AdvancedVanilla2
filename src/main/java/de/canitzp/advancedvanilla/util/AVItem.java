package de.canitzp.advancedvanilla.util;


import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class AVItem{
    public static Item getItemFromName(String name) {
        ResourceLocation loc = new ResourceLocation(name);
        if (Item.REGISTRY.containsKey(loc)) {
            return (Item)Item.REGISTRY.getObject(loc);
        }
        else {
            try {
                return (Item)Item.REGISTRY.getObjectById(Integer.parseInt(name));
            }
            catch (NumberFormatException numberformatexception) {
                return null;
            }
        }
    }
}
