package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import net.minecraft.item.crafting.CraftingManager;

import java.util.List;

public class Mekanism { //Version: Mekanism-1.7.10-8.1.5.246
    public static void init(){
        //Recipe:

    }
    public static void postInit(){
        //Plastic Blocks:
        AVOreDictionary.WildcardBlock("blockPlastik", "Mekanism:PlasticBlock");
        //Plastic Fences:
        AVOreDictionary.WildcardBlock("blockFence", "Mekanism:PlasticFence");
        //Machine Block:
        AVOreDictionary.AVODBlock("blockMachineBlock", "Mekanism:BasicBlock", 8);

        AVLogger.AVinfo("Mekanism");
    }
}
