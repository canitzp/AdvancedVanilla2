package canitzp.advancedvanilla.generic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class GenericContainer extends Container {

    public int slots;
    public boolean canInteractWith;
    public GenericContainer(int slots, boolean canInteractWith){
        this.slots = slots;
        this.canInteractWith = canInteractWith;
    }
    @Override
     public boolean canInteractWith(EntityPlayer player) {
        return canInteractWith;
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        final int inventoryStart = slots;
        final int inventoryEnd = inventoryStart + 26;
        final int hotbarStart = inventoryEnd + 1;
        final int hotbarEnd = hotbarStart + 8;

        Slot theSlot = (Slot) this.inventorySlots.get(slot);
        if (theSlot.getHasStack()) {
            ItemStack currentStack = theSlot.getStack();
            ItemStack newStack = currentStack.copy();

            if (currentStack.getItem() != null) {
                if (slot <= hotbarEnd && slot >= inventoryStart) {
                    this.mergeItemStack(newStack, 0, 1, false);
                }

                if (slot <= hotbarEnd && slot >= hotbarStart) {
                    this.mergeItemStack(newStack, inventoryStart, inventoryEnd + 1, false);
                } else if (slot <= inventoryEnd && slot >= inventoryStart) {
                    this.mergeItemStack(newStack, hotbarStart, hotbarEnd + 1, false);
                } else if (slot < inventoryStart) {
                    this.mergeItemStack(newStack, inventoryStart, hotbarEnd + 1, false);
                }

                if (newStack.stackSize == 0) theSlot.putStack(null);
                else theSlot.onSlotChanged();
                if (newStack.stackSize == currentStack.stackSize) return null;
                theSlot.onPickupFromSlot(player, newStack);

                return currentStack;
            }
        }
        return null;
    }
}
