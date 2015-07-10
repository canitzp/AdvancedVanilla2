package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import net.minecraft.item.crafting.CraftingManager;

import java.util.List;

public class Mekanism {
    public static void init(){
        //Plastic Blocks:
        AVOreDictionary.WildcardBlock("blockPlastik", "Mekanism:PlasticBlock");

        //Plastic Fences:
        AVOreDictionary.WildcardBlock("blockFence", "Mekanism:PlasticFence");

        //Machine Block:
        AVOreDictionary.AVODBlock("blockMachineBlock", "Mekanism:BasicBlock", 8);

        //Crafting Recipe:




        AVLogger.AVinfo("Mekanism");
    }
}
