package canitzp.advancedvanilla.tileEntity;

import canitzp.advancedvanilla.receipes.AtomicSmelterReceipes;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;


public class TileEntityAtomicSmelter extends TileEntity implements ISidedInventory,IEnergyReceiver {


    public String name = "TileEntityAtomicSmelter";
    public ItemStack[] slots = new ItemStack[6];
    public EnergyStorage eStorage = new EnergyStorage(32000);
    public int workTime = 0;

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[i];
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
        if (this.slots[i] != null)
        {
            ItemStack itemstack;

            if (this.slots[i].stackSize <= j)
            {
                itemstack = this.slots[i];
                this.slots[i] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.slots[i].splitStack(j);

                if (this.slots[i].stackSize == 0)
                {
                    this.slots[i] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return this.getStackInSlot(i);
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        this.slots[i] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

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
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return true;
    }

    public void writeToNBT(NBTTagCompound nbt) {

        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.slots.length; ++i)
        {
            if (this.slots[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbt.setTag("Items", nbttaglist);

        this.eStorage.writeToNBT(nbt);
        super.writeToNBT(nbt);
    }

    public void readFromNBT(NBTTagCompound nbt) {

        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];


        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.slots.length)
            {
                this.slots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.eStorage.readFromNBT(nbt);
        super.readFromNBT(nbt);
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt){
        this.readFromNBT(pkt.func_148857_g());
    }





    //Energy:
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return this.eStorage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return this.eStorage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return this.eStorage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }



    //Brew:
    @Override
    public void updateEntity(){
        if(!worldObj.isRemote){
            if(workTime == 0 && eStorage.getEnergyStored() != 0){
                this.work();
            }
        }
    }
    public void work(){
        ArrayList<AtomicSmelterReceipes.RecipeAS> recipes = AtomicSmelterReceipes.recipes;
        for (AtomicSmelterReceipes.RecipeAS j : recipes) {
            ItemStack[] is = j.input;
            for (int k = 0; k < is.length; ++k) {
                if (slots[k + 1] != null && !slots[k + 1].isItemEqual(is[k])) {
                    return;
                }
                ItemStack iss = j.output;
                slots[0] = iss.copy();
                slots[k + 1] = null;
            }
        }
    }
}
