package com.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.PropertiesReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseTest {
    public static AndroidDriver driver;

    // Singleton pattern for AndroidDriver initialization
    public static AndroidDriver getDriver() throws Exception {
    	
    	AppiumServer();
    	
        if (driver == null) {
            PropertiesReader reader = new PropertiesReader(
                    "D:\\Code\\WorkSpace2025\\NaqadMobileApp\\src\\test\\java\\resources\\config.properties");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", reader.getProperty("deviceName"));
            caps.setCapability("udid", reader.getProperty("udid"));
            caps.setCapability("platformName", reader.getProperty("platformName"));
            caps.setCapability("platformVersion", reader.getProperty("platformVersion"));
            caps.setCapability("automationName", reader.getProperty("automationName"));
            caps.setCapability("appPackage", reader.getProperty("appPackage"));
            caps.setCapability("appActivity", reader.getProperty("appActivity"));

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        }
        return driver;
    }

    // Optional method to quit the driver and kill the app process
    public static void quitDriver() {
        if (driver != null) {
            // Kill the app process using adb shell command
            try {
                String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
                // Killing the app via adb command to force stop the app
                Runtime.getRuntime().exec("adb shell am force-stop " + appPackage);
                System.out.println("App process killed: " + appPackage);
            } catch (Exception e) {
                System.err.println("Failed to kill app process: " + e.getMessage());
            }

            driver.quit();
            driver = null;
        }
    }
    
    
    public static void AppiumServer() {
    	  	  	
    	 try {
             // Define the log file path
             String logFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\log.txt";
             
             // Ensure the directory exists
             File logDirectory = new File(System.getProperty("user.dir") + "\\src\\test\\resources");
             if (!logDirectory.exists()) {
                 logDirectory.mkdirs();  // Create the directory if it does not exist
                 System.out.println("Directory created: " + logDirectory.getAbsolutePath());
             }

             // Ensure the log file exists
             File logFile = new File(logFilePath);
             if (!logFile.exists()) {
                 logFile.createNewFile();  // Create the log file if it does not exist
                 System.out.println("Log file created: " + logFile.getAbsolutePath());
             }

             // Create the Appium service with the log file configuration
             AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                 new AppiumServiceBuilder()
                     .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                     .withAppiumJS(new File("C:\\Users\\IT\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                     .withLogFile(logFile)  // Set the log file for Appium
                     .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)  // Set the timezone argument for Appium
             );

             // Start the Appium service
             service.start();
             System.out.println("Appium service started successfully.");

             // Perform any actions needed with the Appium server (e.g., interacting with the mobile app)
             // For example: AppiumDriver driver = service.getDriver();

             // Stop the Appium service after tests are done
        //     service.stop();
        //     System.out.println("Appium service stopped successfully.");

         } catch (IOException e) {
             e.printStackTrace();
             System.out.println("Error during file or directory creation: " + e.getMessage());
         }
     }
    
    
    
    public void AppiumServerStop() {
    	
    	//service.stop();
    //    System.out.println("Appium service stopped successfully.");
    	
    	
    	
    }
    
    
    	
}
    	
		/*
		 * AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new
		 * AppiumServiceBuilder() .usingDriverExecutable(new
		 * File("C:\\Program Files\\nodejs\\node.exe")) .withAppiumJS(new File(
		 * "C:\\Users\\IT\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
		 * )) //
		 * "C:\\Users\\SQA Engineer\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"
		 * )) .withLogFile(new File(System.getProperty("user.dir") +
		 * "\\src\\test\\resources\\log.txt"))
		 * .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)); service.start();
		 */

		//Start_Appium_Server_with_itel();
	//	Start_Appium_Server_with_oppo();
		//service.stop();
    	
    	
    	
    	
    
    
    

    

