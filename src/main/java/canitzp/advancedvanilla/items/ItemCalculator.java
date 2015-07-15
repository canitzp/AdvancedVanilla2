package canitzp.advancedvanilla.items;

import canitzp.advancedvanilla.generic.GenericItem;
import canitzp.advancedvanilla.util.AVStrings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCalculator extends GenericItem {
    public ItemCalculator(String name, int maxStackSize) {
        super(name, maxStackSize);
    }
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) player.openGui(AVStrings.modid, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return stack;
    }
}
