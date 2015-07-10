package canitzp.advancedvanilla.recipes;


import canitzp.advancedvanilla.registry.BlockRegistry;
import canitzp.advancedvanilla.registry.ItemRegistry;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class AtomicSmelterReceipes {
    public static ArrayList<RecipeAS> recipes = new ArrayList<RecipeAS>();

    public static void init() {
        addRecipe(new ItemStack[]{ new ItemStack(BlockRegistry.blockAtomicSmelter), new ItemStack(BlockRegistry.blockAtomicSmelter), new ItemStack(BlockRegistry.blockAtomicSmelter), new ItemStack(BlockRegistry.blockAtomicSmelter), new ItemStack(BlockRegistry.blockAtomicSmelter)}, new ItemStack(ItemRegistry.itemCalculator));
    }

    public static void addRecipe(ItemStack[] input, ItemStack output) {
        recipes.add(new RecipeAS(input, output));
    }

    public static RecipeAS getRecipeForInput(ItemStack[] input) {
        for (RecipeAS recipe : recipes) {
            if (input != null && input.equals(recipe.input)) return recipe;
        }
        return null;
    }

    public static ItemStack[] getOutputsFromInput(ItemStack[] input) {
        RecipeAS recipe = getRecipeForInput(input);
        if (recipe != null) {
            return new ItemStack[]{recipe.output};
        }
        return null;
    }

    public static class RecipeAS {

        public final ItemStack[] input;
        public final ItemStack output;

        public RecipeAS(ItemStack[] input, ItemStack output) {
            this.input = input;
            this.output = output;
        }
    }
}
