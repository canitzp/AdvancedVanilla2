package canitzp.advancedvanilla.generic;


import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.item.Item;

public class GenericItem extends Item{


    public GenericItem(String name, int maxStackSize){
        setTextureName(AVStrings.texture + name);
        setUnlocalizedName(AVStrings.blockName + name);
        setMaxStackSize(maxStackSize);

    }


}
