package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.AllureReport;
import utils.ExcelReader;
import utils.PropertiesReader;
import utils.TestLogger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.URL;

import java.util.logging.Logger;

public class LoginSteps {

	private AndroidDriver driver;
	private LoginPage loginPage;
	
	//public string sheet1 = "Login";
	

	private static final Logger logger = TestLogger.getLogger();

	@Given("the user opens the mobile app")
	public void theUserOpensTheMobileApp() throws IOException {				
		// Create PropertiesReader object and load properties from config file

		PropertiesReader reader = new PropertiesReader(
				"D:\\Code\\WorkSpace2025\\NaqadMobileApp\\src\\test\\java\\resources\\config.properties");
		// Set up desired capabilities for Appium

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", reader.getProperty("deviceName"));
		caps.setCapability("udid", reader.getProperty("udid"));
		caps.setCapability("platformName", reader.getProperty("platformName"));
		caps.setCapability("platformVersion", reader.getProperty("platformVersion"));
		caps.setCapability("automationName", reader.getProperty("automationName"));
		caps.setCapability("appPackage", reader.getProperty("appPackage"));
		caps.setCapability("appActivity", reader.getProperty("appActivity"));
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
		loginPage = new LoginPage(driver);
		logger.info("Given: The user launch the mobile app");
		
	}

	 @And("the user allows the permissions")
	public void theUserAllowsThePermissions() {	
		loginPage.allowPermissions();
		logger.info("And: The user is allows the permissions on the permission screen");
	}
	 		 
	 @And("the user clicks on Okay")
		public void OkButton() {	
			loginPage.OkButton();
			logger.info("And: The user clicks on Okay on the Select language Screen");
		}
	 
	 @And("the user clicks on Skip")
		public void SkipButton() {		  
			loginPage.SkipButton();
			logger.info("And: The user clicks on Skip on the Info Screen");
		}
	 

	 @When("the user logs in with valid phone number and password")
	public void theUserLogsInWithValidPhoneNumberAndPassword() throws IOException, InterruptedException {
	
		 String filepath = "D:\\Code\\WorkSpace2025\\NaqadMobileApp\\src\\test\\java\\resources\\testdata.xlsx";
		Thread.sleep(2000);	
		
	//	String phone = ExcelReader.readData(filepath, "Sheet1", 0, 0);
		
		String phone ="561243031";
		logger.info("Enter phone: " + phone);
		System.out.println(phone);
		loginPage.phoneNumberField(phone);
		
		String password = ExcelReader.readData(filepath, "Sheet1", 0, 1);			
		logger.info("Enter Password: " + password);
		System.out.println(password);   
		loginPage.passwordField(password);						
    	logger.info("Given: The user enters phone Number and Password");		   	
    	AllureReport.attachScreenshot(driver); // Attach screenshot to Allure report		
	}
	 
	 
	 @Then("the user should be logged in successfully")
		public void theUserLogsInSuccessFully() throws IOException, InterruptedException {		 
		 loginPage.loginButton();		 				 
		 logger.info("Then: The user is Successfully Login into the App");		 
		 AllureReport.attachScreenshot(driver); // Attach screenshot to Allure report
		 
	 }
		

}