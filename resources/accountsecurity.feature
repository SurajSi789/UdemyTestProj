Feature: Account Security Udemy App
	
	#Testing navigation to Account Security module
	@accountSecurity
  Scenario: User navigates to the account security settings
    Given the user is logged into the Udemy app
    When the user navigates to the account settings
    And selects the Account Security option
    Then the user should be directed to the account security settings page
	
	#Positive testing of change password section
	@positive_testing
  Scenario: User changes password successfully
    Given the user is on the account security settings page
    When the user navigates to the Change Password option
    And enters the current password, new password, and confirms new password #apache poi
    And clicks the Save Changes button
    Then the password should be updated successfully
    And the user should receive a confirmation message
	
	#Negative testing of change password section
	@negative_testing
  Scenario: User attempts to change password with incorrect current password
    Given the user is on the account security settings page
    When the user navigates to the Change Password option
    And enters an incorrect current password, new password, and confirms new password
    | xyx@123 | tty@q23 | frga@q234 |
    And clicks the Save Changes button
    Then the password should not be updated
    And the user should receive an error message indicating the incorrect current password
	
	#Testing multi factor authentication
	@multi_auth
  Scenario: User enables multi-factor authentication
    Given the user is on the account security settings page
    When the user selects the Enable Multi-Factor Authentication option
    And follows the prompts to set up multi-factor authentication
    And successfully completes the setup process
    Then multi-factor authentication should be enabled for the user account
    
  #Testing disabling the multi factor authentication
  @disable_multiFact
  Scenario: User disables multi-factor authentication
  	Given the user is on the account security settings page
  	When clicks on disable button
  	Then multi-factor authentication should be disabled
	
	#Negative testing of multi-factory authentication by giving invalid OTP
	@negative_testingOtp
  Scenario Outline: User enters invalid verification code for multi-factor authentication
    Given the user is on the account security settings page
    When the user selects the Enable Multi-Factor Authentication option
    And follows the prompts to set up multi-factor authentication
    And successfully completes the setup process
    And the user enters an invalid verification code "<verificationcode>"
    Then the system should display an error message indicating the code is invalid

    Examples:
      | verificationcode |
      |  1234            |
      |  5678            |
