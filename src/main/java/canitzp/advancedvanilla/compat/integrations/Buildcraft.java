package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class Buildcraft {
    public static void init(){ //Version: BuildCraft-7.0.13
        //Recipe:
    }
    public static void postInit(){
        //Chute:
        AVOreDictionary.AVODBlock("blockHopper", "BuildCraft|Factory:blockHopper");
        //Buckets:
        AVOreDictionary.AVODItem("bucketOil", "BuildCraft|Energy:bucketOil");

        AVLogger.AVinfo("BuildCraft");
    }
}
