package udemyStepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.*;
import udemyBaseClass.DriverSetup;
import udemyBaseClass.ExcelClass;
import udemyPageFactory.LoginPF;

public class LoginStepDef {
	public static AppiumDriver<MobileElement> driver;
	LoginPF login;
	
	public LoginStepDef() throws MalformedURLException {
		driver = DriverSetup.setDriver();
		login = new LoginPF(driver);
	}
	
	// Create an account
	@Given("I am on the Udemy homepage")
	public void i_am_on_the_udemy_homepage() throws MalformedURLException {
		login.clickAppList();
		login.clickUdemyApp();
	    
	}
	@When("I click on the Sign In button")
	public void i_click_on_the_sign_in_button() {
	    login.clickSignIn();
	}
	@When("I click on create an account link")
	public void i_click_on_create_an_account_link() {
	    login.clickCreateAccountLink();
	}
	@When("I click the signup with email button")
	public void i_click_the_signup_with_email_button() {
	    login.clickSignUpWithEmail();
	}
	@When("I enter user details")
	public void i_enter_user_details(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
	    login.enterSignupDetails(list.get(0).get(0), list.get(0).get(1), list.get(0).get(2));
	}
	@When("I click on the Create account button")
	public void i_click_on_the_create_account_button() {
	    login.clickCreateAccount();
	}
	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
	    String message = login.clickSkip();
	    Assert.assertEquals(message, "Welcome, Suraj");
	    login.clickAccountTab();
	    login.clickSignOut();
	}
	@Then("I should see a welcome message")
	public void i_should_see_a_welcome_message() throws InterruptedException {
		Thread.sleep(3000);
	    driver.navigate().back();
	    driver.navigate().back();
	}
	
	// Login with Valid Credentials
	@When("I click the sign in with email button")
	public void i_click_the_sign_in_with_email_button() {
	    login.clickSignInWithEmail();
	}
	@When("I fill in the sign in form with valid credentials")
	public void i_fill_in_the_sign_in_form_with_valid_credentials() throws IOException {
		ArrayList<String> al = ExcelClass.getExcel();
		login.enterLoginDetails(al.get(0), al.get(1));
	}
	@When("I click on the signin button")
	public void i_click_on_the_signin_button() {
	    login.clickSignInButton();
	}
	@Then("I should see my profile information")
	public void i_should_see_my_profile_information() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/welcome_user_fullname")));
	    String message = driver.findElement(By.id("com.udemy.android:id/welcome_user_fullname")).getText();
	    Assert.assertEquals(message, "Welcome, Suraj Singh");
	    
	    login.clickAccountTab();
	    login.clickSignOut();
	    Thread.sleep(3000);
	    driver.navigate().back();
	    driver.navigate().back();
	}
	
	// Login with Invalid Credentials
	@When("I fill in the sign in form with invalid credentials {string}")
	public void i_fill_in_the_sign_in_form_with_invalid_credentials(String string) {
	    login.enterInvalidEmail(string);
	}
	@Then("I should see an error message indicating invalid credentials")
	public void i_should_see_an_error_message_indicating_invalid_credentials() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/textinput_error")));
		WebElement errrMsg = driver.findElement(By.id("com.udemy.android:id/textinput_error"));
	    Assert.assertTrue(errrMsg.isDisplayed());
	}
	@Then("I should remain on the login page")
	public void i_should_remain_on_the_login_page() {
	    System.out.println("I am on the login page");
		for (int i = 0; i < 5; i++) {
			driver.navigate().back();
		}
	}
	
	// Login with Empty Credentials
	@When("I fill in the sign in form with empty email")
	public void i_fill_in_the_sign_in_form_with_empty_email() {
	    login.enterInvalidEmail("");
	}
	@When("I click on next")
	public void i_click_on_next() {
//		login.nextButton();
	}
	@Then("I should see an error message indicating required fields")
	public void i_should_see_an_error_message_indicating_required_fields() {
	    WebElement errrMsg = driver.findElement(By.id("com.udemy.android:id/textinput_error"));
	    Assert.assertTrue(errrMsg.isDisplayed());
	}
	
	// Forgot Password
	@When("I fill in the sign in form with valid email")
	public void i_fill_in_the_sign_in_form_with_valid_email() {
	    login.enterValidEmail("surajsinghfirebase7@gmail.com");
	}
	
	@When("I click on the next button")
	public void i_click_on_the_next_button() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/textinput_error")));
	}
	@When("I click on the Forgot Password? link")
	public void i_click_on_the_forgot_password_link() {
	    login.clickForgotPassword();
	}
	@When("I fill in the email address for password reset")
	public void i_fill_in_the_email_address_for_password_reset() {
	    System.out.println("Enter email address for password reset");
	}
	@When("I click on the Reset Password button")
	public void i_click_on_the_reset_password_button() {
	    login.clickResetPassword();
	}
	@Then("I should see a success message indicating that an email has been sent for password reset")
	public void i_should_see_a_success_message_indicating_that_an_email_has_been_sent_for_password_reset() {
	    // com.udemy.android:id/success
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/success")));
		WebElement succMsg = driver.findElement(By.id("com.udemy.android:id/success"));
	    Assert.assertTrue(succMsg.isDisplayed());
	}
}
