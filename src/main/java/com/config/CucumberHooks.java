package com.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import utils.PropertiesReader;

public class CucumberHooks {

    private static AppiumDriverLocalService appiumService;

    // Hook to start Appium server before all scenarios
    @Before
    public void startAppiumServer() {
        try {
            // Initialize Appium server using the default configuration
            appiumService = AppiumDriverLocalService.buildDefaultService();

            // Start the Appium server programmatically
            if (!appiumService.isRunning()) {
                appiumService.start();
                System.out.println("Appium server started.");
            }
        } catch (Exception e) {
            System.err.println("Error starting Appium server: " + e.getMessage());
        }
    }

    // Hook to stop Appium server after all scenarios
    @After
    public void stopAppiumServer() {
        try {
            // Stop the Appium server after tests complete
            if (appiumService != null && appiumService.isRunning()) {
                appiumService.stop();
                System.out.println("Appium server stopped.");
            }
        } catch (Exception e) {
            System.err.println("Error stopping Appium server: " + e.getMessage());
        }
    }

    // Singleton pattern for AndroidDriver initialization
    public static AndroidDriver driver;

    public static AndroidDriver getDriver() throws Exception {
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

    // Quit driver and kill app process (optional)
    public static void quitDriver() {
        if (driver != null) {
            try {
                String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
                Runtime.getRuntime().exec("adb shell am force-stop " + appPackage);
                System.out.println("App process killed: " + appPackage);
            } catch (Exception e) {
                System.err.println("Failed to kill app process: " + e.getMessage());
            }

            driver.quit();
            driver = null;
        }
    }
}
