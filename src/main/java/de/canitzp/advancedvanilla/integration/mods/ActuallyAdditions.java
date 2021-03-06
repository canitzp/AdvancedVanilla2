package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.integration.IMod;
import de.canitzp.advancedvanilla.util.AVItem;
import de.canitzp.advancedvanilla.util.AVOreDictionary;
import de.canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unchecked")
public class ActuallyAdditions implements IMod{ //Version: ActuallyAdditions-1.9-r30

    @Override
    public String getModName(){
        return "ActuallyAdditions";
    }

    public void postInit(){
        //MachineBlock:
        AVOreDictionary.AVODItem("blockMachineBlockWood", "ActuallyAdditions:blockMisc", 4);
        AVOreDictionary.AVODItem("blockMachineBlockStone", "ActuallyAdditions:blockMisc", 5);
        AVOreDictionary.AVODItem("blockMachineBlockResonant", "ActuallyAdditions:blockMisc", 9);
        //Lamps:
        AVOreDictionary.WildcardBlock("poweredLamp", "ActuallyAdditions:blockColoredLamp");
        //Buckets:
        AVOreDictionary.AVODItem("bucketOil", "ActuallyAdditions:itemBucketOil", 0);
        //Coils:
        AVOreDictionary.AVODItem("coilBasic", "ActuallyAdditions:itemMisc", 7);
        AVOreDictionary.AVODItem("coilAdvanced", "ActuallyAdditions:itemMisc", 8);
        //Crafting Recipes:
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockCompost", new Object[]{"A A", "A A", "ABA", 'A', "plankWood", 'B', new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockMisc"), 1, 4)}, new Object[]{"A A", "A A", "ABA", 'A', "plankWood", 'B', "blockMachineBlockWood"});
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockCanolaPress", new Object[]{}, new Object[]{ "ABA", "ACA", "ADA", 'A', "cobblestone", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"), 1, 13)), 'D', "coilAdvanced"});
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockFermentingBarrel", new Object[]{}, new Object[]{ "ABA", "ACA", "ADA", 'A', "logWood", 'B', "blockHopper", 'C', (new ItemStack(AVItem.getItemFromName("ActuallyAdditions:itemMisc"), 1, 13)), 'D', "blockWoodMachineBlock"});
        AVRecipe.AVODShapedBlock("ActuallyAdditions:blockInputter", new Object[]{ "AAA", "BCB", "AAA", 'A', "plankWood", 'B', "blockWoodMachineBlock", 'C', "blockHopper"});
        //Battery:
        AVOreDictionary.AVODItem("itemBattery", "ActuallyAdditions:itemBattery");
        AVOreDictionary.AVODItem("itemBatteryTier2", "ActuallyAdditions:itemBatteryDouble");
        AVOreDictionary.AVODItem("itemBatteryTier3", "ActuallyAdditions:itemBatteryTriple");
        AVOreDictionary.AVODItem("itemBatteryTier4", "ActuallyAdditions:itemBatteryQuadruple");
        AVOreDictionary.AVODItem("itemBatteryTier5", "ActuallyAdditions:itemBatteryQuintuple");
        //Book:
        AVOreDictionary.AVODItem("itemBook", "ActuallyAdditions:itemBooklet");
        //Seeds:
        AVOreDictionary.AVODItem("itemSeeds", "ActuallyAdditions:itemCoffeeSeed");
        AVOreDictionary.AVODItem("itemSeeds", "ActuallyAdditions:itemRiceSeed");
        AVOreDictionary.AVODItem("itemSeeds", "ActuallyAdditions:itemCanolaSeed");
        AVOreDictionary.AVODItem("itemSeeds", "ActuallyAdditions:itemFlaxSeed");
        //Fertilizer:
        AVOreDictionary.AVODItem("itemFertilizer", "ActuallyAdditions:itemFertilizer");
        //Jam:
        AVOreDictionary.WildcardItem("itemJam", "ActuallyAdditions:itemJam");
        //Food:
        AVOreDictionary.AVODItem("foodCheese", "ActuallyAdditions:itemFood", 0);
        AVOreDictionary.AVODItem("foodPumpkinStew", "ActuallyAdditions:itemFood", 1);
        AVOreDictionary.AVODItem("foodCarrotJuice", "ActuallyAdditions:itemFood", 2);
        AVOreDictionary.AVODItem("foodFishNChips", "ActuallyAdditions:itemFood", 3);
        AVOreDictionary.AVODItem("foodFrenchFries", "ActuallyAdditions:itemFood", 4);
        AVOreDictionary.AVODItem("foodFrenchFry", "ActuallyAdditions:itemFood", 5);
        AVOreDictionary.AVODItem("foodSpaghetti", "ActuallyAdditions:itemFood", 6);
        AVOreDictionary.AVODItem("foodNoodle", "ActuallyAdditions:itemFood", 7);
        AVOreDictionary.AVODItem("foodCakeChocolate", "ActuallyAdditions:itemFood", 8);
        AVOreDictionary.AVODItem("foodChocolate", "ActuallyAdditions:itemFood", 9);
        AVOreDictionary.AVODItem("foodToast", "ActuallyAdditions:itemFood", 10);
        AVOreDictionary.AVODItem("foodSandwichSubmarine", "ActuallyAdditions:itemFood", 11);
        AVOreDictionary.AVODItem("foodBigCookie", "ActuallyAdditions:itemFood", 12);
        AVOreDictionary.AVODItem("foodHamburger", "ActuallyAdditions:itemFood", 13);
        AVOreDictionary.AVODItem("foodPizza", "ActuallyAdditions:itemFood", 14);
        AVOreDictionary.AVODItem("foodBaguette", "ActuallyAdditions:itemFood", 15);
        AVOreDictionary.AVODItem("foodRice", "ActuallyAdditions:itemFood", 16);
        AVOreDictionary.AVODItem("foodBreadRice", "ActuallyAdditions:itemFood", 17);
        AVOreDictionary.AVODItem("foodDoughnut", "ActuallyAdditions:itemFood", 18);
        AVOreDictionary.AVODItem("foodToastChocolate", "ActuallyAdditions:itemFood", 19);
    }

}
