
@Smoke

@tag1

Feature: Pay Bills

  Scenario: Pay a Mobile Top-up by Adding New Bill Beneficiary.
  
    When The user navigates to the Pay Bills Screen
    When The user clicks on the pay a new bill button
		And The user selects the United Arab Emirates as the country and Selects Package
		And The user clicks on 'Pay In Full' as the payment option after selecting a package
		When The user enters the Mobile Number
		When The user enters the Beneficiary name
		And The proceed to the next step
		And The user clicks on "Pay In Full" as the payment option
		When The user Accepts Terms & Conditions clicks on the "Pay Now" button
		Then The user enters OTP on OTP Verification Screen
	  Then The user confirms his the payment
	  

