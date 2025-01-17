
@tag1

Feature: User Login Functionality

  # This scenario describes how a user logs in with a valid phone number and password
  
  Scenario: User logs in with valid phone number and password from Excel
    Given the user opens the mobile app
    And the user allows the permissions
    And the user clicks on Okay
    And the user clicks on Skip
    When the user logs in with valid phone number and password
    Then the user should be logged in successfully
