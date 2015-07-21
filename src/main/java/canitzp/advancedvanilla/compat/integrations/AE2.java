package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVItem;
import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;

public class AE2 {
    public static void init(){ //Version: AppliedEnergistics-rv2-stable-9
        //Recipe:

        //Thaumcraft:
        //Certus Quartz:
        AVRecipe.AVThaumcraftAspects(new ItemStack(AVItem.getItemFromName("appliedenergistics2:item.ItemMultiMaterial"), 1, 0), Aspect.CRYSTAL, 1);
        //Charged Certus Quartz:
        AVRecipe.AVThaumcraftAspects(new ItemStack(AVItem.getItemFromName("appliedenergistics2:item.ItemMultiMaterial"), 1, 1), Aspect.CRYSTAL, 1);
        AVRecipe.AVThaumcraftAspects(new ItemStack(AVItem.getItemFromName("appliedenergistics2:item.ItemMultiMaterial"), 1, 1), Aspect.ENERGY, 1);
        //Flux Crystal:
        AVRecipe.AVThaumcraftAspects(new ItemStack(AVItem.getItemFromName("appliedenergistics2:item.ItemMultiMaterial"), 1, 7), Aspect.CRYSTAL, 2);
        AVRecipe.AVThaumcraftAspects(new ItemStack(AVItem.getItemFromName("appliedenergistics2:item.ItemMultiMaterial"), 1, 7), Aspect.ENERGY, 3);
        AVRecipe.AVThaumcraftAspects(new ItemStack(AVItem.getItemFromName("appliedenergistics2:item.ItemMultiMaterial"), 1, 7), Aspect.MECHANISM, 1);
    }
    public static void postInit(){
        //Quartz Blocks:
        AVOreDictionary.AVODBlock("blockQuartz", "appliedenergistics2:tile.BlockQuartz");
        AVOreDictionary.AVODBlock("blockChiseledQuartz", "appliedenergistics2:tile.BlockQuartzChiseled");
        AVOreDictionary.AVODBlock("blockPillarQuartz", "appliedenergistics2:tile.BlockQuartzPillar");
        //Glass:
        AVOreDictionary.AVODBlock("blockGlass", "appliedenergistics2:tile.BlockQuartzGlass");
        AVOreDictionary.AVODBlock("blockGlass", "appliedenergistics2:tile.BlockQuartzLamp");

        AVLogger.AVinfo("Applied Energistics 2");
    }
}
