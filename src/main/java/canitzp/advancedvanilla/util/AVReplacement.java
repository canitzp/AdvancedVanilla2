package canitzp.advancedvanilla.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AVReplacement {
    public AVReplacement(ItemStack stack, String oreDictName) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Map<ItemStack, String> replacements = new HashMap<ItemStack, String>();
        replacements.put(stack, oreDictName);
        ItemStack[] replaceStacks = replacements.keySet().toArray(new ItemStack[replacements.keySet().size()]);

        for(Object obj : recipes) {

            ShapedRecipes recipe = (ShapedRecipes) obj;
            ItemStack output = recipe.getRecipeOutput();
            ItemStack[] is = recipe.recipeItems;
            if (containsMatch(true, is, replaceStacks)) {
                recipes.remove(recipe);
                recipes.add(new ShapedOreRecipe(output, replacements));
            }

        }
    }
    private static boolean containsMatch(boolean strict, ItemStack[] inputs, ItemStack... targets)
    {
        for (ItemStack input : inputs)
        {
            for (ItemStack target : targets)
            {
                if (OreDictionary.itemMatches(target, input, strict))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
