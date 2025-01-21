package com.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.List;

public class LoginPage {

	public AndroidDriver driver;
	public WebDriverWait wait;

	// Declare the "Permission Allow" Button using @AndroidFindBy
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement allowPermissionButton;

	// Declare the "Ok" button using @AndroidFindBy
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ok\")")
	public WebElement OkButton;

	// Declare the "Skip" button using @AndroidFindBy
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='Skip'])")
	public WebElement SkipButton;

	// Declare the "Phone Number" field using @AndroidFindBy
	@AndroidFindBy(className = "android.widget.EditText")
	public List<WebElement> phoneNumberField;

	// Declare the "Login" Button using @AndroidFindBy
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='Login'])")
	public WebElement loginButton;

	// Declare the "BackButton" button using @AndroidFindBy
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement BackButton;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Initialize page elements
	}

	public void allowPermissions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(allowPermissionButton)).click();
	}

	public void OkButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
	}

	public void SkipButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SkipButton)).click();
	}

	public void loginButton() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(BackButton)).click();

		Thread.sleep(4000);

		wait.until(ExpectedConditions.elementToBeClickable(BackButton)).click();

		// WebElement Backbutton2 =
		// wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new
		// UiSelector().text(\"\")")));
		// Backbutton2.click();

	}

	public void phoneNumberField(String phone) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField.get(0)));
		phoneNumberField.get(0).clear();
		phoneNumberField.get(0).sendKeys(phone);

	}

	public void passwordField(String password) {

		List<WebElement> passwordField = driver
				.findElements(AppiumBy.xpath("//android.widget.EditText[@text=\"••••••••••••\"]\r\n" + ""));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(passwordField.get(0))); // Access the first element
		passwordField.get(0).clear(); // Clear the field
		passwordField.get(0).sendKeys(password); // Enter password

	}

}