package canitzp.AdvancedLib.energy;

import canitzp.AdvancedLib.api.cofh.EnergyStorage;
import canitzp.AdvancedLib.api.cofh.IEnergyProvider;
import canitzp.AdvancedLib.api.ic2.IEnergySource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class AllEnergyProvider extends TileEntity implements IEnergyProvider, IEnergySource {

    public int EUPerTick = 32;
    public int EUTier = 1;

    public AllEnergyProvider EUPerTick(int EUPerTick){
        this.EUPerTick = EUPerTick;
        return this;
    }
    public AllEnergyProvider EUTier(int EUTier){
        this.EUTier = EUTier;
        return this;
    }

    private int energyRF, energyEU;
    public void producingEnergyRF(int energy){
        this.energyRF = energy;
        this.energyEU = energyRF * 25 / 3;
    }
    public void producingEnergyEU(int energy){
        this.energyEU = energy;
        this.energyRF = energy * 3 / 25;
    }
    public EnergyStorage storage = new EnergyStorage(energyRF);

    //RF
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return this.storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return this.storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return this.storage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }


    //EU
    @Override
    public double getOfferedEnergy() {
        return Math.min(energyEU, EUPerTick);
    }

    @Override
    public void drawEnergy(double amount) {

    }

    @Override
    public int getSourceTier() {
        return EUTier;
    }

    @Override
    public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
        return true;
    }
}
