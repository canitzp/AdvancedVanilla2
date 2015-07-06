package canitzp.advancedvanilla.compat.integrations;


import canitzp.advancedvanilla.util.AVLogger;
import canitzp.advancedvanilla.util.AVOreDictionary;

public class ExtraUtilities {
    public static void init(){

        //Conveyer Belt:
        AVOreDictionary.AVODBlock("blockConveyerBelt", "ExtraUtilities:conveyor");


        //Glass:
        AVOreDictionary.WildcardBlock("blockGlass", "ExtraUtilities:etherealglass");
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 4);
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 7);
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 8);
        AVOreDictionary.AVODBlock("blockGlass", "ExtraUtilities:decorativeBlock2", 10);

        AVOreDictionary.AVODBlock("blockGlassHardened", "ExtraUtilities:decorativeBlock2", 5);
        AVOreDictionary.AVODBlock("blockGlassHardened", "ExtraUtilities:decorativeBlock2", 11);



        //Ingots:
        AVOreDictionary.AVODItem("ingotBedrockium", "ExtraUtilities:bedrockiumIngot");


        AVLogger.AVinfo("ExtraUtilities");
    }
}
