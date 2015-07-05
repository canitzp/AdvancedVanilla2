package canitzp.advancedvanilla.util;


import net.minecraft.item.Item;

public class AVItem{
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
