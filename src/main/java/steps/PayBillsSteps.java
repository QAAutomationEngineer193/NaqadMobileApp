package steps;

import com.pages.LoginPage;
import com.pages.PayBillsPage;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropertiesReader;

import org.openqa.selenium.WebDriver;

public class PayBillsSteps {
  
	public AndroidDriver driver;
	public PayBillsPage payBillsPage;
    
	public PropertiesReader reader = new PropertiesReader(
			"D:\\Code\\WorkSpace2025\\NaqadMobileApp\\src\\test\\java\\resources\\config.properties");
	
	
   @Before
    public void setUp() {
    payBillsPage = new PayBillsPage(driver); // Initialize PayBillsPage object
    
    }
	
	
    @When("The user navigates to the Pay Bills Screen")
    public void NavigateToThePayBillsSection() {
    
        payBillsPage.clickOnScrollToPayBills();
    }

    @When("The user clicks on the pay a new bill button")
    public void iSelectToPayANewBill() {
        payBillsPage.clickOnPayNewBill();
    }

    @When("The user selects the United Arab Emirates as the country and Selects Package")
    public void CountryAndPackage() {
       // if (country.equalsIgnoreCase("United Arab Emirates")) {
            payBillsPage.AddCountryAndPackage();
        }

    @Then("The user clicks on the {string} as the payment option")
    public void iChoosePayInFullAsThePaymentOption(String paymentOption) {
        if (paymentOption.equalsIgnoreCase("Pay In Full")) {
            payBillsPage.clickPayInFull();
        }
    }

    @When("The user enters the Mobile Number")
    public void EnterTheMobileNumber() {
    	String mobileNumber = reader.getProperty("mobileNumber");
        payBillsPage.enterMobileNumber(mobileNumber);
    }

    @When("The user enters the Beneficiary name")
    public void EnterTheBeneficiaryName() {
    	String name = reader.getProperty("name");
        payBillsPage.enterBeneficiaryName(name);
    }

    @And("The proceed to the next step")
    public void ProceedToNextStep() throws InterruptedException {
        payBillsPage.clickOntheNextButton();
    }
    
    @And("The user clicks on the {string} as the payment option and Accept Terms & Conditions")
    public void PayInFullAsPaymentOptionOnCreditPay(String paymentOption) {
        if (paymentOption.equalsIgnoreCase("Pay In Full")) {
            payBillsPage.clickPayInFull();
        }
    }

    @When("The user clicks on the {string} button")
    public void ClickOnThePayNowButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Pay Now")) {
            payBillsPage.clickPayNow();
        }
    }

    
    @Then("The user enters OTP on OTP Verification Screen")
    public void EnterTheOTP(String otp) {
        payBillsPage.EnterOTP(otp);
    }

    @Then("The user confirms his the payment")
    public void ConfirmThePayment() {
        // Assuming clicking on the "Pay Now" button confirms the payment.
        payBillsPage.clickPayNow();
    }
}