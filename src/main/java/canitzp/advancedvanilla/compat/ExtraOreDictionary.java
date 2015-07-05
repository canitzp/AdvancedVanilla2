package canitzp.advancedvanilla.compat;


import canitzp.advancedvanilla.compat.integrations.*;
import canitzp.advancedvanilla.registry.ConfigRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExtraOreDictionary {
    public static void ExtraOreDictionary(){

        //Vanilla
        OreDictionary.registerOre("blockChiseledQuartz", new ItemStack(Blocks.quartz_block, 1, 1));
        OreDictionary.registerOre("blockPillarQuartz", new ItemStack(Blocks.quartz_block, 1, 2));
        OreDictionary.registerOre("blockBricks", Blocks.brick_block);
        OreDictionary.registerOre("bucketLava", Items.lava_bucket);
        OreDictionary.registerOre("poweredLamp", Blocks.redstone_lamp);
        OreDictionary.registerOre("blockSponge", Blocks.sponge);

        //Mods
        if(Loader.isModLoaded("appliedenergistics2") && ConfigRegistry.AE2Integration) AE2.init();
        if(Loader.isModLoaded("MineFactoryReloaded") && ConfigRegistry.MFRIntegration) MineFactroyReloaded.init();
        if(Loader.isModLoaded("ActuallyAdditions") && ConfigRegistry.ActuallyAdditionsIntegration) ActuallyAdditions.init();
        if(Loader.isModLoaded("ThermalExpansion") && ConfigRegistry.ThermalExpansionIntegration) ThermalExpansion.init();
        if(Loader.isModLoaded("EnderIO") && ConfigRegistry.EnderIOIntegration) EnderIO.init();
        if(Loader.isModLoaded("IC2") && ConfigRegistry.IC2Integration) IC2.init();
        if(Loader.isModLoaded("BuildCraft|Core") && Loader.isModLoaded("BuildCraft|Energy") && Loader.isModLoaded("BuildCraft|Builders") && Loader.isModLoaded("BuildCraft|Factory") && Loader.isModLoaded("BuildCraft|Robotics") && Loader.isModLoaded("BuildCraft|Silicon") && Loader.isModLoaded("BuildCraft|Transport") && ConfigRegistry.BuildCraftIntegration) Buildcraft.init();
        if(Loader.isModLoaded("Forestry") && ConfigRegistry.ForestryIntegration) Forestry.init();


    }
}
