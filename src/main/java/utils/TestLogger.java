package utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class TestLogger {

    private static Logger logger;

    // Private constructor to prevent instantiation
    private TestLogger() {
    	
    	
    }

    private static Logger getLogger() {
        if (logger == null) {
            try {
                // Initialize the logger and set up the file handler
                logger = Logger.getLogger(TestLogger.class.getName());  // Using class name for logger
                FileHandler fileHandler = new FileHandler("test-execution.log", true);  // True to append logs
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);

                // Optionally set log level (can be adjusted)
                logger.setLevel(Level.ALL);  // Log all levels, adjust this for production (e.g., Level.INFO)
            } catch (IOException e) {
                System.err.println("Error setting up logger: " + e.getMessage());
            }
        }
        return logger;
    }

    // Public method to log info messages
    public static void logInfo(String message) {
        getLogger().info(message);
    }

    // Public method to log error messages
    public static void logError(String message) {
        getLogger().severe(message);
    }

    // Public method to log warnings
    public static void logWarning(String message) {
        getLogger().warning(message);
    }
}
