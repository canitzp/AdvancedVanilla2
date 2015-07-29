package canitzp.AdvancedLib.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

public class NBTTC extends NBTTagCompound {

    public void setItemStack(String name, ItemStack stack){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag(name, stack.writeToNBT(new NBTTagCompound()));
    }

    public void setItemStack(String name, FluidStack stack){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag(name, stack.writeToNBT(new NBTTagCompound()));
    }
}
