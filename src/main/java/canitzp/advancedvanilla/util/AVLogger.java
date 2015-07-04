package canitzp.advancedvanilla.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AVLogger {

    public static final Logger logger = LogManager.getLogger(AVStrings.name);
    public static final Logger moduleLogger = LogManager.getLogger(AVStrings.name + " Integration Module");
}
