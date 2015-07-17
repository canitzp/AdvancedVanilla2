package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class EnderIO {
    public static void init(){
        //Recipe:
    }
    public static void postInit(){//Glass:
        AVOreDictionary.WildcardBlock("blockGlass", "EnderIO:blockFusedQuartz");
        AVOreDictionary.AVODBlock("blockGlassHardened", "EnderIO:blockFusedQuartz", 2);
        AVOreDictionary.AVODBlock("blockGlassHardened", "EnderIO:blockFusedQuartz", 4);
        //Machine Parts:
        AVOreDictionary.AVODItem("blockMachineBlock", "EnderIO:itemMachinePart");
        AVOreDictionary.AVODItem("gearStone", "EnderIO:itemMachinePart", 1);

        AVLogger.AVinfo("EnderIO");
    }
}
