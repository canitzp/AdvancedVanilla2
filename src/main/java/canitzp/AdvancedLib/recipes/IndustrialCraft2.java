package canitzp.AdvancedLib.recipes;

import canitzp.AdvancedLib.api.ic2.RecipeInputItemStack;
import canitzp.AdvancedLib.api.ic2.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

public class IndustrialCraft2 {

    public static void Compressor(ItemStack input, ItemStack output){
        Recipes.compressor.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void Centrifuge(ItemStack input, ItemStack output){
        Recipes.centrifuge.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void BlockCutter(ItemStack input, ItemStack output){
        Recipes.blockcutter.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void Extractor(ItemStack input, ItemStack output){
        Recipes.extractor.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void Macerator(ItemStack input, ItemStack output){
        Recipes.macerator.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void OreWashing(ItemStack input, ItemStack output){
        Recipes.oreWashing.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void BlastFurnace(ItemStack input, ItemStack output){
        Recipes.blastfurance.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void Recycler(ItemStack input, ItemStack output){
        Recipes.recycler.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void MetalFormer(ItemStack input, ItemStack output, String type){
        if(type.equals("extruding")) Recipes.metalformerExtruding.addRecipe(new RecipeInputItemStack(input), null, output);
        if(type.equals("cutting")) Recipes.metalformerCutting.addRecipe(new RecipeInputItemStack(input), null, output);
        if(type.equals("rolling")) Recipes.metalformerRolling.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void CannerMachineBottle(ItemStack input, ItemStack output){
        Recipes.cannerBottle.addRecipe(new RecipeInputItemStack(input), null, output);
    }
    public static void CannerMachineEnriching(FluidStack input, FluidStack output){
        Recipes.cannerEnrich.addRecipe(input, null, output);
    }
    public static void MatterAmplifier(ItemStack stack, int amplifier){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("amplification", amplifier);
        Recipes.matterAmplifier.addRecipe(new RecipeInputItemStack(stack), nbt);
    }
    public static void ScrapboxDrops(ItemStack output, float chance){
        Recipes.scrapboxDrops.addDrop(output, chance);
    }
    public static void SemiFluidGenerator(String fluidName, int amount, double power){
        Recipes.semiFluidGenerator.addFluid(fluidName, amount, power);
    }
    public static void FluidHeatGenerator(String fluidName, int amount, int heat){
        Recipes.FluidHeatGenerator.addFluid(fluidName, amount, heat);
    }

}
