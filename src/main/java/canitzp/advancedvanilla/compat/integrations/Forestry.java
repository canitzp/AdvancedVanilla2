package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class Forestry {
    public static void init(){
        //Recipes:
        AVRecipe.AVForestrySqueezer(25, new ItemStack[]{new ItemStack(Blocks.sapling, 1, 0)}, new FluidStack(FluidRegistry.getFluid("seedoil"), 250));
    }
    public static void postInit(){
        //Glass:
        AVOreDictionary.WildcardBlock("blockGlass", "Forestry:stained");
        //Chipsets:
        AVOreDictionary.AVODItem("circuitBasic", "Forestry:chipsets", 0);
        AVOreDictionary.AVODItem("circuitAdvanced", "Forestry:chipsets", 3);

        AVLogger.AVinfo("Forestry");
    }
}
