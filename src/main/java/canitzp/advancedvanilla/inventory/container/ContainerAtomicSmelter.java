package canitzp.advancedvanilla.inventory.container;

import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;




public class ContainerAtomicSmelter extends Container {

    public ContainerAtomicSmelter(IInventory inventory, TileEntityAtomicSmelter te) {

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

