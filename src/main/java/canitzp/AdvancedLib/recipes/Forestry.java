package canitzp.AdvancedLib.recipes;

import canitzp.AdvancedLib.api.forestry.RecipeManagers;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

public class Forestry {

    public static void Carpender(int time, ItemStack output, Object ... obj){
        RecipeManagers.carpenterManager.addRecipe(time, null, output, obj);
    }
    public static void Carpender(int time, ItemStack output, FluidStack fluid, Object ... obj){
        RecipeManagers.carpenterManager.addRecipe(time,fluid, null, output, obj);
    }
    public static void Centrifuge(int time, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, float secondChance){
        Map<ItemStack, Float> map = new HashMap<ItemStack, Float>();
        map.put(primaryOutput, 100F);
        map.put(secondaryOutput, secondChance);
        RecipeManagers.centrifugeManager.addRecipe(time, input, map);
    }
    public static void Fermenter(ItemStack input, FluidStack inputLiquid, int fermentationValue, float modifier, FluidStack output){
        RecipeManagers.fermenterManager.addRecipe(input, fermentationValue, modifier, output, inputLiquid);
    }
    public static void Moistener(int time, ItemStack input, ItemStack output){
        RecipeManagers.moistenerManager.addRecipe(input, output, time);
    }
    public static void Squeezer(int time, ItemStack input, FluidStack output){
        ItemStack[] array = new ItemStack[]{input};
        RecipeManagers.squeezerManager.addRecipe(time, array, output);
    }
    public static void Still(int cyclesPerUnit, FluidStack input, FluidStack output){
        RecipeManagers.stillManager.addRecipe(cyclesPerUnit, input, output);
    }
    public static void FabricatorRecipe(ItemStack plan, FluidStack fluid, ItemStack output, Object... obj){
        RecipeManagers.fabricatorManager.addRecipe(plan, fluid, output, obj);
    }
    public static void FabricatorSmelting(ItemStack input, FluidStack output, int heatPoint){
        RecipeManagers.fabricatorManager.addSmelting(input, output, heatPoint);
    }
}
