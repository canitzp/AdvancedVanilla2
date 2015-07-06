package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class AE2 {
    public static void init(){


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
