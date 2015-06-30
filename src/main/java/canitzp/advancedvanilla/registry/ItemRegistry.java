package canitzp.advancedvanilla.registry;

import canitzp.advancedvanilla.items.ItemCalculator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegistry {
    public static Item itemCalculator;
    public static void ItemRegistry(){
        itemCalculator = new ItemCalculator("itemCalculator", 1);

        GameRegistry.registerItem(itemCalculator, "itemCalculator");
    }
}
