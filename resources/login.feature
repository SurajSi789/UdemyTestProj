Feature: Login and Signup on Udemy
	
	#positive testing for sign up
	@positive_signup
  Scenario: User Signup
    Given I am on the Udemy homepage
    When I click on the Sign In button
    And I click on create an account link
    And I click the signup with email button
    And I enter user details
    |Suraj|ss2622388@gmail.com|rgfyqg@724|
    And I click on the Create account button
    Then I should be redirected to the dashboard
    And I should see a welcome message
	
	#positive testing for login
	@positive_login
  Scenario: User Login with Valid Credentials
    Given I am on the Udemy homepage
    When I click on the Sign In button
    And I click the sign in with email button
    And I fill in the sign in form with valid credentials
    And I click on the signin button
    Then I should see my profile information
	
	#negative testing login
	@negative_login
  Scenario Outline: User Login with Invalid email
    Given I am on the Udemy homepage
    When I click on the Sign In button
    And I click the sign in with email button
    And I fill in the sign in form with invalid credentials "<email>"
    Then I should see an error message indicating invalid credentials
    And I should remain on the login page
    
    Examples:
    |email|
    |ss@gm|
    |a@@45|
	
	#negative testing login with empty field
	@negative_login_empty
  Scenario: User Login with Empty Fields
  	Given I am on the Udemy homepage
    When I click on the Sign In button
    And I click the sign in with email button
    And I fill in the sign in form with empty email
    And I click on the next button
    Then I should see an error message indicating required fields
    And I should remain on the login page
	
	#testing forgot password link
	@forgot_password
  Scenario: User Forgot Password
    Given I am on the Udemy homepage
    When I click on the Sign In button
    And I click the sign in with email button
    And I fill in the sign in form with valid email
    And I click on next
    When I click on the Forgot Password? link
    And I fill in the email address for password reset
    And I click on the Reset Password button
    Then I should see a success message indicating that an email has been sent for password reset