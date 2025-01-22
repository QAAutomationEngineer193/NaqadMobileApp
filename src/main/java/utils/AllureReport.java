package utils;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;  // Ensure this import is correct

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureReport {
	
//	private static AndroidDriver driver;

    // Method to attach a screenshot as byte array to Allure
	
    public static void attachScreenshot(AndroidDriver driver) {
    	
    	if (driver == null) {
            System.out.println("WebDriver is not initialized. Cannot take screenshot.");
            return;
        }
    	    	    	
    	byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    	Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }

	
}
