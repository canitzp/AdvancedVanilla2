package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class OpenBlocks {
    public static void init(){
        //Sponge:
        AVOreDictionary.AVODBlock("blockSponge", "OpenBlocks:sponge");

        //Elevator:
        AVOreDictionary.WildcardBlock("blockElevator", "OpenBlocks:elevator");


        AVLogger.AVinfo("OpenBlocks");
    }
}
