package canitzp.advancedvanilla.inventory.container;

import canitzp.advancedvanilla.generic.GenericContainer;
import canitzp.advancedvanilla.tileEntity.TileEntityAtomicSmelter;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;


public class ContainerAtomicSmelter extends GenericContainer {

    public int slots;

    public ContainerAtomicSmelter(int slots, boolean canInteractWith, IInventory inventory, TileEntityAtomicSmelter te) {
        super(slots, canInteractWith);
        this.slots = slots;




        addSlotToContainer(new Slot(te, 0, 36, 6));


        //player
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 68 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 126));
        }
    }




    //New Class

    public class SlotOutput extends Slot {


        public SlotOutput(IInventory inventory, int id, int x, int y) {
            super(inventory, id, x, y);
        }

        @Override
        public void onSlotChanged() {


            if (inventory.getStackInSlot(0) == null) {
                for (int k = 1; k < slots; k++) inventory.setInventorySlotContents(k, null);
            } else {
                for (int k = 1; k < slots; k++) {
                    if (inventory.getStackInSlot(k) == null) {
                        inventory.setInventorySlotContents(k, null);
                    }
                    if (inventory.getStackInSlot(k) != null) {
                        inventory.setInventorySlotContents(0, null);
                    }
                }
            }
        super.onSlotChanged();
        }


    }
}

