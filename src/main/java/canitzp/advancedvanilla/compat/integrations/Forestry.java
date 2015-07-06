package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class Forestry {
    public static void init(){



        //Glass:
        AVOreDictionary.WildcardBlock("blockGlass", "Forestry:stained");


        //Chipsets:
        AVOreDictionary.AVODItem("circuitBasic", "Forestry:chipsets", 0);
        AVOreDictionary.AVODItem("circuitAdvanced", "Forestry:chipsets", 3);


        AVLogger.AVinfo("Forestry");
    }
}
