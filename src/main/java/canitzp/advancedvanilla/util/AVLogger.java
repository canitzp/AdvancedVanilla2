package canitzp.advancedvanilla.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AVLogger {

    public static final Logger logger = LogManager.getLogger(AVStrings.name);
    public static final Logger moduleLogger = LogManager.getLogger(AVStrings.name + " Integration Module");
    public static final Logger interModLogger = LogManager.getLogger(AVStrings.name + " InterModCommunication System");

    public static void AVinfo(String input){
        moduleLogger.info("Loaded " + input + " Integration Module successfully!");
    }

    public static void AVIMC(String string){
        interModLogger.info(string);
    }


}
