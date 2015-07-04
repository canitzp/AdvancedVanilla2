package canitzp.advancedvanilla.inventory.container;

import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;




public class ContainerAtomicSmelter extends Container {

    private int numRows;


    public ContainerAtomicSmelter(IInventory inventory, TileEntityAtomicSmelter te) {

        this.numRows = inventory.getSizeInventory() / 9;

        addSlotToContainer(new Slot(te, 1, 41, 7));
        addSlotToContainer(new Slot(te, 2, 75, 7));
        addSlotToContainer(new Slot(te, 3, 58, 24));
        addSlotToContainer(new Slot(te, 4, 41, 41));
        addSlotToContainer(new Slot(te, 5, 75, 41));

        addSlotToContainer(new SlotOutput(te, 0, 134, 24));



        //player
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 78 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 136));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(i);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (i < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }




    //New Class

    public class SlotOutput extends Slot {


        public SlotOutput(IInventory inventory, int id, int x, int y) {
            super(inventory, id, x, y);
        }


        @Override
        public boolean isItemValid(ItemStack stack) {
            return false;
        }


    }
}

