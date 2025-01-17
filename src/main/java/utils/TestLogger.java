package utils;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLogger {

    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            try {
                // Initialize the logger and set up the file handler
                logger = Logger.getLogger(TestLogger.class.getName()); // Use the class name for the logger
                FileHandler fileHandler = new FileHandler("test-execution.log", true); // True to append
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
            } catch (IOException e) {
                System.err.println("Error setting up logger: " + e.getMessage());
            }
        }
        return logger;
    }
}