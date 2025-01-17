package com.pages;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PayBillsPage {
	
	public AndroidDriver driver;
	private WebDriverWait wait;
	
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

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[1]")
    private WebElement inputField1;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[2]")
    private WebElement inputField2;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[3]")
    private WebElement inputField3;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[4]")
    private WebElement inputField4;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[5]")
    private WebElement inputField5;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='textInput' and @text='0']")
    private WebElement inputField6;

	/*
	 * public PayBillsPage(AndroidDriver driver) { this.driver = driver;
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	 * Initialize page elements }
	 */
    
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
        wait.until(ExpectedConditions.elementToBeClickable(payInFullButton)).click();
    }

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

    public void clickPayFullButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payFullButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkOption)).click();
    }

    public void clickCheckOption() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOption)).click();
    }

    public void clickPayNow() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payNowButton)).click();
    }

    public void EnterOTP(String value) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(inputField1)).sendKeys(value);
        wait.until(ExpectedConditions.elementToBeClickable(inputField2)).sendKeys(value);
        wait.until(ExpectedConditions.elementToBeClickable(inputField3)).sendKeys(value);
        wait.until(ExpectedConditions.elementToBeClickable(inputField4)).sendKeys(value);
        wait.until(ExpectedConditions.elementToBeClickable(inputField5)).sendKeys(value);
        wait.until(ExpectedConditions.elementToBeClickable(inputField6)).sendKeys(value);
        
    }

   
}