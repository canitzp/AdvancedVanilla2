package canitzp.advancedvanilla.compat;

import canitzp.advancedvanilla.compat.integrations.*;
import canitzp.advancedvanilla.registry.ConfigRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Integration {
    public static void init(){
        if(Loader.isModLoaded("ActuallyAdditions") && ConfigRegistry.ActuallyAdditionsIntegration) ActuallyAdditions.init();
        if(Loader.isModLoaded("appliedenergistics2") && ConfigRegistry.AE2Integration) AE2.init();
        if(Loader.isModLoaded("BuildCraft|Core") && Loader.isModLoaded("BuildCraft|Energy") && Loader.isModLoaded("BuildCraft|Builders") && Loader.isModLoaded("BuildCraft|Factory") && Loader.isModLoaded("BuildCraft|Robotics") && Loader.isModLoaded("BuildCraft|Silicon") && Loader.isModLoaded("BuildCraft|Transport") && ConfigRegistry.BuildCraftIntegration) Buildcraft.init();
        if(Loader.isModLoaded("EnderIO") && ConfigRegistry.EnderIOIntegration) EnderIO.init();
        if(Loader.isModLoaded("ExtraUtilities")) ExtraUtilities.init();
        if(Loader.isModLoaded("Forestry") && ConfigRegistry.ForestryIntegration) Forestry.init();
        if(Loader.isModLoaded("IC2") && ConfigRegistry.IC2Integration) IC2.init();
        if(Loader.isModLoaded("MineFactoryReloaded") && ConfigRegistry.MFRIntegration) MineFactroyReloaded.init();
        if(Loader.isModLoaded("ThermalExpansion") && ConfigRegistry.ThermalExpansionIntegration) ThermalExpansion.init();

        if(Loader.isModLoaded("Mekanism")) Mekanism.init();
        if(Loader.isModLoaded("OpenBlocks")) OpenBlocks.init();
        if(Loader.isModLoaded("Thaumcraft")) Thaumcraft.init();
    }
    public static void postInit(){
        //Vanilla
        OreDictionary.registerOre("blockChiseledQuartz", new ItemStack(Blocks.quartz_block, 1, 1));
        OreDictionary.registerOre("blockPillarQuartz", new ItemStack(Blocks.quartz_block, 1, 2));
        OreDictionary.registerOre("blockBricks", Blocks.brick_block);
        OreDictionary.registerOre("bucketLava", Items.lava_bucket);
        OreDictionary.registerOre("poweredLamp", Blocks.redstone_lamp);
        OreDictionary.registerOre("blockSponge", Blocks.sponge);
        OreDictionary.registerOre("blockGrass", Blocks.grass);
        OreDictionary.registerOre("blockFence", Blocks.fence);

        //Mods
        if(Loader.isModLoaded("ActuallyAdditions") && ConfigRegistry.ActuallyAdditionsIntegration) ActuallyAdditions.postInit();
        if(Loader.isModLoaded("appliedenergistics2") && ConfigRegistry.AE2Integration) AE2.postInit();
        if(Loader.isModLoaded("BuildCraft|Core") && Loader.isModLoaded("BuildCraft|Energy") && Loader.isModLoaded("BuildCraft|Builders") && Loader.isModLoaded("BuildCraft|Factory") && Loader.isModLoaded("BuildCraft|Robotics") && Loader.isModLoaded("BuildCraft|Silicon") && Loader.isModLoaded("BuildCraft|Transport") && ConfigRegistry.BuildCraftIntegration) Buildcraft.postInit();
        if(Loader.isModLoaded("EnderIO") && ConfigRegistry.EnderIOIntegration) EnderIO.postInit();
        if(Loader.isModLoaded("ExtraUtilities")) ExtraUtilities.postInit();
        if(Loader.isModLoaded("Forestry") && ConfigRegistry.ForestryIntegration) Forestry.postInit();
        if(Loader.isModLoaded("IC2") && ConfigRegistry.IC2Integration) IC2.postInit();
        if(Loader.isModLoaded("MineFactoryReloaded") && ConfigRegistry.MFRIntegration) MineFactroyReloaded.postInit();
        if(Loader.isModLoaded("ThermalExpansion") && ConfigRegistry.ThermalExpansionIntegration) ThermalExpansion.postInit();

        if(Loader.isModLoaded("Mekanism")) Mekanism.postInit();
        if(Loader.isModLoaded("OpenBlocks")) OpenBlocks.postInit();
        if(Loader.isModLoaded("Thaumcraft")) Thaumcraft.postInit();
    }
}
