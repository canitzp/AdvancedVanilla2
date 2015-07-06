package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class Buildcraft {
    public static void init(){

        //Chute:
        AVOreDictionary.AVODBlock("blockHopper", "BuildCraft|Factory:blockHopper");

        //Buckets:
        AVOreDictionary.AVODItem("bucketOil", "BuildCraft|Energy:bucketOil");

        AVLogger.AVinfo("BuildCraft");
    }
}
