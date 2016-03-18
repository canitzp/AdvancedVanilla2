package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

@SuppressWarnings("unchecked")
public class Vanilla { //Version: Minecraft 1.7.10

    public static void postInit(){
        CheckLoadedMods.modList.add("Vanilla");
        AVOreDictionary.AVODBlock("blockChiseledQuartz", Blocks.quartz_block, 1);
        AVOreDictionary.AVODBlock("blockPillarQuartz", Blocks.quartz_block, 2);
        AVOreDictionary.AVODBlock("blockBricks", Blocks.brick_block);
        AVOreDictionary.AVODItem("bucketLava", Items.lava_bucket);
        AVOreDictionary.AVODItem("bucketWater", Items.water_bucket);
        AVOreDictionary.AVODItem("bucket", Items.bucket);
        AVOreDictionary.AVODBlock("poweredLamp", Blocks.redstone_lamp);
        AVOreDictionary.AVODBlock("blockSponge", Blocks.sponge);
        AVOreDictionary.AVODBlock("blockGrass", Blocks.grass);
        AVOreDictionary.AVODBlock("blockFence", Blocks.oak_fence);
        AVOreDictionary.AVODBlock("blockFence", Blocks.birch_fence);
        AVOreDictionary.AVODBlock("blockFence", Blocks.spruce_fence);
        AVOreDictionary.AVODBlock("blockFence", Blocks.jungle_fence);
        AVOreDictionary.AVODBlock("blockFence", Blocks.acacia_fence);
        AVOreDictionary.AVODBlock("blockFence", Blocks.dark_oak_fence);
        AVOreDictionary.AVODItem("itemBook", Items.book);
        AVOreDictionary.WildcardItem("itemBook", Items.enchanted_book);
        AVOreDictionary.WildcardBlock("carpet", Blocks.carpet);
        //Food:
        AVOreDictionary.AVODItem("foodApple", Items.apple);
        AVOreDictionary.AVODItem("foodMushroomStew", Items.mushroom_stew);
        AVOreDictionary.AVODItem("foodBread", Items.bread);
        AVOreDictionary.AVODItem("foodPorkchopRaw", Items.porkchop);
        AVOreDictionary.AVODItem("foodPorkchopCocked", Items.cooked_porkchop);
        AVOreDictionary.AVODItem("foodAppleGold", Items.golden_apple);
        AVOreDictionary.AVODItem("foodAppleEnchanted", Items.golden_apple, 1);
        AVOreDictionary.AVODItem("foodFishRaw", Items.fish);
        AVOreDictionary.AVODItem("foodSalomonRaw", Items.fish, 1);
        AVOreDictionary.AVODItem("foodClownfish", Items.fish, 2);
        AVOreDictionary.AVODItem("foodPufferfish", Items.fish, 3);
        AVOreDictionary.AVODItem("foodFishCocked", Items.cooked_fish);
        AVOreDictionary.AVODItem("foodSalomonCocked", Items.cooked_fish, 1);
        AVOreDictionary.AVODItem("foodCake", Items.cake);
        AVOreDictionary.AVODItem("foodCookie", Items.cookie);
        AVOreDictionary.AVODItem("foodMelon", Items.melon);
        AVOreDictionary.AVODItem("foodBeefRaw", Items.beef);
        AVOreDictionary.AVODItem("foodBeefCocked", Items.cooked_beef);
        AVOreDictionary.AVODItem("foodChickenRaw", Items.chicken);
        AVOreDictionary.AVODItem("foodChickenCocked", Items.cooked_chicken);
        AVOreDictionary.AVODItem("foodRottenFlesh", Items.rotten_flesh);
        AVOreDictionary.AVODItem("foodSpiderEye", Items.spider_eye);
        AVOreDictionary.AVODItem("foodCarrot", Items.carrot);
        AVOreDictionary.AVODItem("foodPotato", Items.potato);
        AVOreDictionary.AVODItem("foodPotatoCocked", Items.baked_potato);
        AVOreDictionary.AVODItem("foodPotatoPoisoned", Items.poisonous_potato);
        AVOreDictionary.AVODItem("foodCarrotGolden", Items.golden_carrot);
        AVOreDictionary.AVODItem("foodPiePumpkin", Items.pumpkin_pie);
    }

}
