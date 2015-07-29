package canitzp.AdvancedLib.api.ic2;

import java.util.Set;

import net.minecraftforge.fluids.Fluid;

public interface ILiquidAcceptManager {
	boolean acceptsFluid(Fluid fluid);
	Set<Fluid> getAcceptedFluids();
}
