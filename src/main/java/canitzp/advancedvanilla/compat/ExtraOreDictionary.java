package canitzp.advancedvanilla.compat;


import canitzp.advancedvanilla.compat.integrations.AE2;
import canitzp.advancedvanilla.compat.integrations.MineFactroyReloaded;
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

        //Mods
        if(Loader.isModLoaded("appliedenergistics2") && ConfigRegistry.AE2OreDictIntegrationEnabled) AE2.AE2();
        if(Loader.isModLoaded("MineFactoryReloaded") && ConfigRegistry.MFROreDictIntegrationEnabled) MineFactroyReloaded.MineFactroyReloaded();




    }
}
