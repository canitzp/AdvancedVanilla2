package canitzp.advancedvanilla.tileEntity;

import canitzp.advancedvanilla.recipes.AtomicSmelterRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAtomicSmelter extends TileEntity implements ISidedInventory {
    ItemStack slots[] = new ItemStack[6];
    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.slots[i] != null) {
            ItemStack itemstack;

            if (this.slots[i].stackSize <= j) {
                itemstack = this.slots[i];
                this.slots[i] = null;
                return itemstack;
            } else {
                itemstack = this.slots[i].splitStack(j);

                if (this.slots[i].stackSize == 0) {
                    this.slots[i] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        slots[i] =  stack;
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }

    @Override
    public void updateEntity(){ //isItemEqual
        if(!worldObj.isRemote){
            ItemStack isarray = AtomicSmelterRecipes.getOutputsFromInput(new ItemStack[]{slots[1], slots[2], slots[3], slots[4], slots[5]});
            if(isarray != null){
                slots[0] = isarray.copy();
                slots[0].stackSize = isarray.stackSize;
                for(int i = 0; ;i++){

                }
            }

        }
    }
}
