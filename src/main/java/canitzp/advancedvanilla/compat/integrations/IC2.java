package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;
import canitzp.advancedvanilla.util.AVRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class IC2 { //Version: IndustrialCraft-2-2.2.744
    public static void init(){
        //Recipes:
        AVRecipe.AVICCompressor(new ItemStack(Items.dye, 10, 15),  new ItemStack(Items.bone, 1));
    }

    public static void postInit(){

        //Machine Block:
        AVOreDictionary.AVODBlock("blockMachineBlock", "IC2:blockMachine");

        //Wood:
        AVOreDictionary.AVODBlock("logWood", "IC2:blockRubWood");

        //Cobblestone:
        AVOreDictionary.AVODBlock("cobblestone", "IC2:blockBasalt");


        //Glass:
        AVOreDictionary.AVODBlock("blockGlass", "IC2:blockAlloyGlass");
        AVOreDictionary.AVODBlock("blockGlassHardened", "IC2:blockAlloyGlass");

        //Iridium:
        AVOreDictionary.AVODItem("ingotIridium", "IC2:itemOreIridium");
        AVOreDictionary.AVODItem("plateIridium", "IC2:itemPartIridium");



        AVLogger.AVinfo("IndustrialCraft 2");
    }
}
