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
        if(Loader.isModLoaded("appliedenergistics2") && ConfigRegistry.AE2OreDictIntegrationEnabled) AE2.AE2();
        if(Loader.isModLoaded("MineFactoryReloaded") && ConfigRegistry.MFROreDictIntegrationEnabled) MineFactroyReloaded.MineFactroyReloaded();
        if(Loader.isModLoaded("ActuallyAdditions") && ConfigRegistry.ActuallyAdditionsOreDictIntegrationEnabled) ActuallyAdditions.ActuallyAdditions();
        if(Loader.isModLoaded("ThermalExpansion") && ConfigRegistry.ThermalExpansionOreDictIntegrationEnabled) ThermalExpansion.ThermalExpansion();
        if(Loader.isModLoaded("EnderIO") && ConfigRegistry.EnderIOOreDictIntegrationEnabled) EnderIO.EnderIO();
        if(Loader.isModLoaded("IC2")) IC2.IC2();
        if(Loader.isModLoaded("BuildCraft|Core") && Loader.isModLoaded("BuildCraft|Energy") && Loader.isModLoaded("BuildCraft|Builders") && Loader.isModLoaded("BuildCraft|Factory") && Loader.isModLoaded("BuildCraft|Robotics") && Loader.isModLoaded("BuildCraft|Silicon") && Loader.isModLoaded("BuildCraft|Transport")) Buildcraft.Buildcraft();



    }
}
