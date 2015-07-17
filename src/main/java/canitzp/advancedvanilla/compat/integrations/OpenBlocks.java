package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class OpenBlocks { //Version: OpenBlocks-1.7.10-1.4.3-snapshot-647
    public static void init(){
        //Recipe:

    }
    public static void postInit(){
        //Sponge:
        AVOreDictionary.AVODBlock("blockSponge", "OpenBlocks:sponge");
        //Elevator:
        AVOreDictionary.WildcardBlock("blockElevator", "OpenBlocks:elevator");

        AVLogger.AVinfo("OpenBlocks");
    }
}
