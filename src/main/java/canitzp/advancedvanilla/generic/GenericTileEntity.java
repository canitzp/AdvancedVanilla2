package canitzp.advancedvanilla.generic;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class GenericTileEntity extends TileEntity implements ISidedInventory {

    public int slot;
    public String name;
    public int stackLimit;
    public boolean playerUsable;
    public ItemStack slots[];
    public void initializeSlots(int itemAmount) {
        this.slots = new ItemStack[itemAmount];
    }
    public GenericTileEntity(int slot, String name, int stackLimit, boolean playerUsable){
        this.initializeSlots(slot);
        this.slot = slot;
        this.name = name;
        this.stackLimit = stackLimit;
        this.playerUsable = playerUsable;
    }



    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[slot];
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (slots[i] != null) {
            ItemStack stackAt;

            if (slots[i].stackSize <= j) {
                stackAt = slots[i];
                slots[i] = null;


                this.markDirty();
                return stackAt;
            } else {
                stackAt = slots[i].splitStack(j);
                if (slots[i].stackSize == 0) slots[i] = null;
                this.markDirty();
                return stackAt;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        this.slots[i] = stack;
        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return name;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return stackLimit;
    }



    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return playerUsable;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }
}
