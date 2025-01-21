package steps;

import com.config.BaseTest;
import com.pages.PayBillsPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.AllureReport;
import utils.PropertiesReader;
import utils.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PayBillsSteps {

    private PayBillsPage payBillsPage;
    private AndroidDriver driver;  // Declare the driver

    PropertiesReader reader = new PropertiesReader(
            "D:\\Code\\WorkSpace2025\\NaqadMobileApp\\src\\test\\java\\resources\\config.properties");
    
    // Constructor to initialize PayBillsPage and driver
    
    public PayBillsSteps() throws Exception {
        // Initialize the driver from BaseTest (assumed method getDriver() from BaseTest class)
        this.driver = BaseTest.getDriver();  // Get the WebDriver from the BaseTest class
        this.payBillsPage = new PayBillsPage(driver);  // Initialize PayBillsPage with driver
    }

    @When("The user navigates to the Pay Bills Screen")
    public void navigateToPayBillsScreen() throws InterruptedException {
        // No need for Thread.sleep(), use waits instead
        System.out.println("Navigating to Pay Bills Screen...");
        TestLogger.logInfo("Given: The user navigates to the Pay Bills Screen");

        // Interact with the page (assuming it's already initialized)
        payBillsPage.clickOnScrollToPayBills();
    }

    @When("The user clicks on the pay a new bill button")
    public void iSelectToPayANewBill() throws InterruptedException {
        // Interact with the page again
    	Thread.sleep(3000);        payBillsPage.clickOnPayNewBill();
        TestLogger.logInfo("When: The user clicks on Pay New Bill button");
    }

    
    @And("The user selects the United Arab Emirates as the country and Selects Package")
    public void CountryAndPackage() {
       // if (country.equalsIgnoreCase("United Arab Emirates")) {
            payBillsPage.AddCountryAndPackage();
            TestLogger.logInfo("And: The user clicks on Pay New Bill button");
        }

    @And("The user clicks on the {string} as the payment option")
    public void ChoosePayInFullAsThePaymentOption(String paymentOption) {
        if (paymentOption.equalsIgnoreCase("Pay In Full")) {
            payBillsPage.clickPayInFull();
            TestLogger.logInfo("And: The user clicks on the Pay In Full as the payment option");
        }
    }

    @When("The user enters the Mobile Number")
    public void EnterTheMobileNumber() {
    	String mobileNumber = reader.getProperty("mobileNumber");
        payBillsPage.enterMobileNumber(mobileNumber);
        TestLogger.logInfo("When: The user enters the Mobile Number" +mobileNumber);
    }

    @When("The user enters the Beneficiary name")
    public void EnterTheBeneficiaryName() {
    	String name = reader.getProperty("name");
        payBillsPage.enterBeneficiaryName(name);
        TestLogger.logInfo("When: The user enters the Beneficiary name"+ name);
        
    }

    @And("The proceed to the next step")
    public void ProceedToNextStep() throws InterruptedException {
        payBillsPage.clickOntheNextButton();
        TestLogger.logInfo("And: The proceed to the next step");
    //  AllureReport.attachScreenshot(driver); // Attach screenshot to Allure report
    }
    
    @And("The user clicks on the {string} as the payment option and Accept Terms & Conditions")
    public void PayInFullAsPaymentOptionOnCreditPay(String paymentOption) throws InterruptedException {
        if (paymentOption.equalsIgnoreCase("Pay In Full")) {
            payBillsPage.clickPayFullButton();
            payBillsPage.clickCheckOption();
            TestLogger.logInfo("And: The user clicks on the Pay In Full as the payment option and Accept Terms & Conditions");
        }
    }

    @When("The user clicks on the {string} button")
    public void ClickOnThePayNowButton(String buttonName) throws InterruptedException {
    	//Thread.sleep(4000);
        if (buttonName.equalsIgnoreCase("Pay Now")) {
            payBillsPage.clickPayNow();
            TestLogger.logInfo("When: The user clicks on the Pay Now button");
        }
    }
    
    
    @Then("The user enters OTP on OTP Verification Screen")
    public void EnterTheOTP() throws InterruptedException {     
        payBillsPage.EnterOTP();  // Call the method with the OTP
        TestLogger.logInfo("Then: The user enters OTP on OTP Verification Screen");
    //    AllureReport.attachScreenshot(driver); // If you want to attach a screenshots
    }


    @Then("The user confirms his the payment")
    public void ConfirmThePayment() throws InterruptedException {
        // Assuming clicking on the "Pay Now" button confirms the payment.
        payBillsPage.VerifyOTPButton();
    	
       TestLogger.logInfo("When: The user confirms his the payment");
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//}