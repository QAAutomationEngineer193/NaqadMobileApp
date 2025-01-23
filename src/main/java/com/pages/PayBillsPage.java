package com.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.TestLogger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PayBillsPage {
	
	public AndroidDriver driver;
	public WebDriverWait wait;
	
	//public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Pay Bills\"))")
    public  WebElement scrollToPayBills;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pay New Bill\")")
    private  WebElement payNewBillButton;

    @AndroidFindBy(accessibility = "United Arab Emirates")
    private WebElement uaeOption;

    @AndroidFindBy(accessibility = "Mobile Prepaid")
    private WebElement mobilePrepaidOption;

    @AndroidFindBy(accessibility = "Etisalat Mobile Prepaid, ")
    private WebElement etisalatMobilePrepaidOption;

    @AndroidFindBy(accessibility = "10 AED Recharge, ")
    private WebElement rechargeOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next\")")
    private WebElement nextButton;

    @AndroidFindBy(accessibility = "Pay In Full")
    private WebElement payInFullButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter mobile number.']")
    private WebElement mobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Beneficiary Name']")
    private WebElement beneficiaryNameField;

    @AndroidFindBy(accessibility = "Next")
    private WebElement nextButton2;

    @AndroidFindBy(accessibility = "Next")
    private WebElement nextButton3;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pay In Full\")")
    private WebElement payFullButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(32)")
    private WebElement checkOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pay Now\")")
    private WebElement payNowButton;
      
    public PayBillsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Initialize page elements
        
    }
    
    // Methods to interact with elements

    public void clickOnScrollToPayBills() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(scrollToPayBills)).click();
    }

    public void clickOnPayNewBill() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payNewBillButton)).click();
    }

    public void AddCountryAndPackage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(uaeOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mobilePrepaidOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(etisalatMobilePrepaidOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(rechargeOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    
    public void clickPayInFull() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
        	
        	WebElement payInFullButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Pay In Full")));
            
        	if (payInFullButton.isDisplayed()) {
                payInFullButton.click();
            }
        } catch (TimeoutException e) {
            TestLogger.logInfo("And: The user is not eligible for CNPL - Pay In Full button not found.");
        } catch (Exception e) {
            TestLogger.logInfo("An error occurred while trying to click on the Pay In Full button: " + e.getMessage());
        }
    }


	/*
	 * public void clickPayInFull() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(10)); //
	 * wait.until(ExpectedConditions.elementToBeClickable(payInFullButton)).click();
	 * if (wait.until(ExpectedConditions.elementToBeClickable(payInFullButton)).
	 * isDisplayed()) { payInFullButton.click();
	 * 
	 * }else { TestLogger.logInfo("And: The user is not elgible for CNPL"); } }
	 */

    public void enterMobileNumber(String mobileNumber) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(mobileNumberField)).sendKeys(mobileNumber);
    }

    public void enterBeneficiaryName(String name) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(beneficiaryNameField)).sendKeys(name);
    }

    public void clickOntheNextButton() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton2)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton3)).click();
    }

    public void clickPayFullButton() throws InterruptedException {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.elementToBeClickable(payFullButton)).click();
        
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         try {
         	
         	WebElement payInFullButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Pay In Full")));
             
         	if (payInFullButton.isDisplayed()) {
                 payInFullButton.click();
             }
         } catch (TimeoutException e) {
             TestLogger.logInfo("And: The user is not eligible for CNPL - Pay In Full button not found.");
         } catch (Exception e) {
             TestLogger.logInfo("An error occurred while trying to click on the Pay In Full button: " + e.getMessage());
         }
     }
    	
    	

    public void clickCheckOption() throws InterruptedException {
    	Thread.sleep(2000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOption)).click();
    }

    public void clickPayNow() throws InterruptedException {    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payNowButton)).click();
    }

    public void EnterOTP() throws InterruptedException {
    	
    	  WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"textInput\"])[1]")));
          el1.sendKeys("6");         
          WebElement el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"textInput\"])[2]")));
          el2.sendKeys("6");
          WebElement el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"textInput\"])[3]")));
          el3.sendKeys("6");
          WebElement el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"textInput\"])[4]")));
          el4.sendKeys("6");
          WebElement el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"textInput\"])[5]")));
          el5.sendKeys("6");
          WebElement el6 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"textInput\" and @text=\"0\"]")));
          el6.sendKeys("6");              	   	
    	
    }
    
    public void VerifyOTPButton() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	 WebElement verifyButton = driver.findElement(AppiumBy.accessibilityId("Verify"));
    	 verifyButton.click();
    	 
    	 Thread.sleep(4000);
    	 
    	// Wait for and click on the element with text "" using Appium's UI Automator
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 
    	 WebElement ExistBackReceipt = wait.until(ExpectedConditions.elementToBeClickable(
    	     AppiumBy.androidUIAutomator("new UiSelector().text(\"\")")
    	 ));
    	 ExistBackReceipt.click();

		 Thread.sleep(4000);
		 	
		 WebElement ExistBackRedeem = wait.until(ExpectedConditions.elementToBeClickable(
		     AppiumBy.androidUIAutomator("new UiSelector().text(\"\")")
		 ));
		 ExistBackRedeem.click();
    	     	     	     	 
    }
    
      
   //////////////////////// Existing Beneficiary ////////////////////////////////////////////
  
    
    
    
    
    
    
    
    
    
    
    
    
    
}