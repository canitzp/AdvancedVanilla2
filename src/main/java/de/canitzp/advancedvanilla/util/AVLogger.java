package de.canitzp.advancedvanilla.util;


import de.canitzp.advancedvanilla.AdvancedVanilla;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AVLogger {

    public static final Logger logger = LogManager.getLogger(AdvancedVanilla.NAME);
    public static final Logger moduleLogger = LogManager.getLogger(AdvancedVanilla.NAME + " Integration Module");
    public static final Logger interModLogger = LogManager.getLogger(AdvancedVanilla.NAME + " InterModCommunication System");

    public static void AVModule(String input){
        moduleLogger.info("Loaded " + input + " Integration Module successfully!");
    }
    public static void info(String input){
        logger.info(input);
    }

    public static void AVIMC(String string){
        interModLogger.info(string);
    }


}
