package steps;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.config.BaseTest;
import com.config.CucumberHooks;
import com.pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.AllureReport;
import utils.ExcelReader;
import utils.PropertiesReader;
import utils.TestLogger;

public class LoginSteps extends BaseTest {

	public AndroidDriver driver;

	private LoginPage loginPage;

	private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());

	@Given("the user opens the mobile app")
	public void theUserOpensTheMobileApp() throws Exception {
		AndroidDriver driver = getDriver(); // Get the driver from BaseTest
		loginPage = new LoginPage(driver);
		TestLogger.logInfo("Given: The user launches the mobile app");
	}

	@And("the user allows the permissions")
	public void theUserAllowsThePermissions() {
		loginPage.allowPermissions();
		TestLogger.logInfo("And: The user allows the permissions on the permission screen");
	}

	@And("the user clicks on Okay")
	public void OkButton() {
		loginPage.OkButton();
		TestLogger.logInfo("And: The user clicks on Okay on the Select language screen");
	}

	@And("the user clicks on Skip")
	public void SkipButton() {
		loginPage.SkipButton();
		TestLogger.logInfo("And: The user clicks on Skip on the Info Screen");
	}

	@Wenn("the user logs in with valid phone number and password")
	public void theUserLogsInWithValidPhoneNumberAndPassword() throws Exception {
		
		AndroidDriver driver = getDriver();		
		String filepath = "D:\\Code\\WorkSpace2025\\NaqadMobileApp\\src\\test\\java\\resources\\testdata.xlsx";
		String phone = "561243500";
		TestLogger.logInfo("Enter phone: " + phone);
		loginPage.phoneNumberField(phone);

		String password = ExcelReader.readData(filepath, "Sheet1", 0, 1);
		TestLogger.logInfo("Enter Password: " + password);
		loginPage.passwordField(password);
	    AllureReport.attachScreenshot(driver); // Attach screenshot to Allure report
	}

	@Then("the user should be logged in successfully")
	public void theUserLogsInSuccessFully() throws IOException, InterruptedException {
		loginPage.loginButton();
		TestLogger.logInfo("Then: The user is successfully logged into the app");
	}
}
