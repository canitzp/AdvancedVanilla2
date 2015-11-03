package de.canitzp.advancedvanilla2.util;


import de.canitzp.advancedvanilla2.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AVLogger {

    public static final Logger logger = LogManager.getLogger(Strings.name);
    public static final Logger moduleLogger = LogManager.getLogger(Strings.name + " Integration Module");
    public static final Logger interModLogger = LogManager.getLogger(Strings.name + " InterModCommunication System");

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
