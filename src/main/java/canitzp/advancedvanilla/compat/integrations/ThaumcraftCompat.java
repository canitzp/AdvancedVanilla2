package canitzp.advancedvanilla.compat.integrations;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftCompat {
    public static void aspects(){
        if(Loader.isModLoaded("ActuallyAdditions")){
            //ThaumcraftApi.registerObjectTag(new ItemStack(Block.getBlockFromName("ActuallyAdditions:blockMisc"), 0, 4), new AspectList().add(Aspect.CLOTH, 1));
        }

    }

}
