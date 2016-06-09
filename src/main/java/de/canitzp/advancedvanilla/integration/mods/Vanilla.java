package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.integration.IMod;
import de.canitzp.advancedvanilla.util.AVOreDictionary;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

@SuppressWarnings("unchecked")
public class Vanilla implements IMod{ //Version: Minecraft 1.7.10

    @Override
    public String getModName(){
        return "Vanilla";
    }

    public void postInit(){
        AVOreDictionary.AVODBlock("blockChiseledQuartz", Blocks.QUARTZ_BLOCK, 1);
        AVOreDictionary.AVODBlock("blockPillarQuartz", Blocks.QUARTZ_BLOCK, 2);
        AVOreDictionary.AVODBlock("blockBricks", Blocks.BRICK_BLOCK);
        AVOreDictionary.AVODItem("bucketLava", Items.LAVA_BUCKET);
        AVOreDictionary.AVODItem("bucketWater", Items.WATER_BUCKET);
        AVOreDictionary.AVODItem("bucket", Items.BUCKET);
        AVOreDictionary.AVODBlock("poweredLamp", Blocks.REDSTONE_LAMP);
        AVOreDictionary.AVODBlock("blockSponge", Blocks.SPONGE);
        AVOreDictionary.AVODBlock("blockGrass", Blocks.GRASS);
        AVOreDictionary.AVODBlock("blockFence", Blocks.OAK_FENCE);
        AVOreDictionary.AVODBlock("blockFence", Blocks.BIRCH_FENCE);
        AVOreDictionary.AVODBlock("blockFence", Blocks.SPRUCE_FENCE);
        AVOreDictionary.AVODBlock("blockFence", Blocks.JUNGLE_FENCE);
        AVOreDictionary.AVODBlock("blockFence", Blocks.ACACIA_FENCE);
        AVOreDictionary.AVODBlock("blockFence", Blocks.DARK_OAK_FENCE);
        AVOreDictionary.AVODItem("itemBook", Items.BOOK);
        AVOreDictionary.WildcardItem("itemBook", Items.ENCHANTED_BOOK);
        AVOreDictionary.WildcardBlock("carpet", Blocks.CARPET);
        //Food:
        AVOreDictionary.AVODItem("foodApple", Items.APPLE);
        AVOreDictionary.AVODItem("foodMushroomStew", Items.MUSHROOM_STEW);
        AVOreDictionary.AVODItem("foodBread", Items.BREAD);
        AVOreDictionary.AVODItem("foodPorkchopRaw", Items.PORKCHOP);
        AVOreDictionary.AVODItem("foodPorkchopCocked", Items.COOKED_PORKCHOP);
        AVOreDictionary.AVODItem("foodAppleGold", Items.GOLDEN_APPLE);
        AVOreDictionary.AVODItem("foodAppleEnchanted", Items.GOLDEN_APPLE, 1);
        AVOreDictionary.AVODItem("foodFishRaw", Items.FISH);
        AVOreDictionary.AVODItem("foodSalomonRaw", Items.FISH, 1);
        AVOreDictionary.AVODItem("foodClownfish", Items.FISH, 2);
        AVOreDictionary.AVODItem("foodPufferfish", Items.FISH, 3);
        AVOreDictionary.AVODItem("foodFishCocked", Items.COOKED_FISH);
        AVOreDictionary.AVODItem("foodSalomonCocked", Items.COOKED_FISH, 1);
        AVOreDictionary.AVODItem("foodCake", Items.CAKE);
        AVOreDictionary.AVODItem("foodCookie", Items.COOKIE);
        AVOreDictionary.AVODItem("foodMelon", Items.MELON);
        AVOreDictionary.AVODItem("foodBeefRaw", Items.BEEF);
        AVOreDictionary.AVODItem("foodBeefCocked", Items.COOKED_BEEF);
        AVOreDictionary.AVODItem("foodChickenRaw", Items.CHICKEN);
        AVOreDictionary.AVODItem("foodChickenCocked", Items.COOKED_CHICKEN);
        AVOreDictionary.AVODItem("foodRottenFlesh", Items.ROTTEN_FLESH);
        AVOreDictionary.AVODItem("foodSpiderEye", Items.SPIDER_EYE);
        AVOreDictionary.AVODItem("foodCarrot", Items.CARROT);
        AVOreDictionary.AVODItem("foodPotato", Items.POTATO);
        AVOreDictionary.AVODItem("foodPotatoCocked", Items.BAKED_POTATO);
        AVOreDictionary.AVODItem("foodPotatoPoisoned", Items.POISONOUS_POTATO);
        AVOreDictionary.AVODItem("foodCarrotGolden", Items.GOLDEN_CARROT);
        AVOreDictionary.AVODItem("foodPiePumpkin", Items.PUMPKIN_PIE);
    }

}
