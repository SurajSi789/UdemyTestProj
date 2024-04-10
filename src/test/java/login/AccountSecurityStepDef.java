package login;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.*;
import udemyBaseClass.DriverSetup;
import udemyBaseClass.ExcelClass;
import udemyPageFactory.AccSecurityPF;

public class AccountSecurityStepDef {
	
	public static AppiumDriver<MobileElement> driver;
	AccSecurityPF accSecPF;
	
	public AccountSecurityStepDef() throws MalformedURLException {
		driver=DriverSetup.setDriver();
		accSecPF = new AccSecurityPF(driver);
	}

	//Testing navigation to Account Security module
	@Given("the user is logged into the Udemy app")
	public void the_user_is_logged_into_the_udemy_app()throws InterruptedException {
		accSecPF.clickUdemyApp();
		Thread.sleep(3000);
	}
	@When("the user navigates to the account settings")
	public void the_user_navigates_to_the_account_settings() {
		accSecPF.clickAccount();
	}
	@When("selects the Account Security option")
	public void selects_the_account_security_option() throws InterruptedException {
		accSecPF.clickAccountSec();
		accSecPF.navigateToAccPass();
	}
	@Then("the user should be directed to the account security settings page")
	public void the_user_should_be_directed_to_the_account_security_settings_page() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Account\"]")));
	    String accountSecTitle = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Account\"]")).getText();
	    Assert.assertEquals("Account", accountSecTitle);
	    
	    for (int i = 0; i < 5; i++) {
			driver.navigate().back();
		}
	}
	
	
	//Positive testing of change password section
	@Given("the user is on the account security settings page")
	public void the_user_is_on_the_account_security_settings_page() throws InterruptedException, IOException {
		try {
			accSecPF.clickUdemyApp();
			Thread.sleep(3000);
			accSecPF.clickAccount();
			accSecPF.clickAccountSec();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
			accSecPF.clickSignInWithEmail();
			ArrayList<String> list = new ArrayList<String>();
			list = ExcelClass.getExcel();
			accSecPF.enterLoginDetails(list.get(0), list.get(1));
			accSecPF.clickSignInButton();
			Thread.sleep(2000);
			accSecPF.clickAccount();
			accSecPF.clickAccountSec();
		}
	}
	
	@When("the user navigates to the Change Password option")
	public void the_user_navigates_to_the_change_password_option() throws InterruptedException {
		accSecPF.navigateToAccPass();
	}
	
	@When("enters the current password, new password, and confirms new password #apache poi")
	public void enters_the_current_password_new_password_and_confirms_new_password_apache_poi() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		list = ExcelClass.getExcel();
		accSecPF.enterCurrentPassword(list.get(1));
		accSecPF.enterNewPassword(list.get(2));
		accSecPF.retypeNewPassword(list.get(2));
	}
	@When("clicks the Save Changes button")
	public void clicks_the_save_changes_button() throws IOException {
		accSecPF.clickChangePassword();
	}
	@Then("the password should be updated successfully")
	public void the_password_should_be_updated_successfully() {
	    System.out.println("Password updated successfully");
	}
	@Then("the user should receive a confirmation message")
	public void the_user_should_receive_a_confirmation_message() {
		for (int i = 0; i < 5; i++) {
			driver.navigate().back();
		}
	}
	
	//Negative testing of change password section
	@When("enters an incorrect current password, new password, and confirms new password")
	public void enters_an_incorrect_current_password_new_password_and_confirms_new_password(io.cucumber.datatable.DataTable dataTable) {
		accSecPF.enterCurrentPassword(dataTable.cell(0, 0));
		accSecPF.enterNewPassword(dataTable.cell(0, 1));
		accSecPF.retypeNewPassword(dataTable.cell(0, 2));
	}
	@Then("the password should not be updated")
	public void the_password_should_not_be_updated() throws InterruptedException {
		accSecPF.navigateToAccPass();
	}
	@Then("the user should receive an error message indicating the incorrect current password")
	public void the_user_should_receive_an_error_message_indicating_the_incorrect_current_password() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Your password was incorrect.\"]")));
		String errorMsg = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Your password was incorrect.\"]")).getText();
		Assert.assertEquals("Your password was incorrect.", errorMsg);
		
		for (int i = 0; i < 5; i++) {
			driver.navigate().back();
		}
	}
	
	//Testing multi factor authentication
	@When("the user selects the Enable Multi-Factor Authentication option")
	public void the_user_selects_the_enable_multi_factor_authentication_option() throws InterruptedException {
		accSecPF.navigateToAccPass();
		accSecPF.navigateToAccPass();
	    accSecPF.clickEnableMFA();
	}
	@When("follows the prompts to set up multi-factor authentication")
	public void follows_the_prompts_to_set_up_multi_factor_authentication() {
		accSecPF.clickConfirmMFA();
	}
	@When("successfully completes the setup process")
	public void successfully_completes_the_setup_process() throws IOException, InterruptedException {
		for (int i = 0; i < 5; i++) {
	    	driver.navigate().back();
	    }
		
		try {
			accSecPF.clickUdemyApp();
			Thread.sleep(2000);
			accSecPF.clickAccount();
			accSecPF.clickAccountSec();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
			accSecPF.clickSignInWithEmail();
			ArrayList<String> list = new ArrayList<String>();
			list = ExcelClass.getExcel();
			accSecPF.enterLoginDetails(list.get(0), list.get(1));
			accSecPF.clickSignInButton();
			accSecPF.enterAuthCode();
			accSecPF.clickVerifyButton();
			accSecPF.clickAccount();
			accSecPF.clickAccountSec();
		}
		
	}
	@Then("multi-factor authentication should be enabled for the user account")
	public void multi_factor_authentication_should_be_enabled_for_the_user_account() {
	    for (int i = 0; i < 5; i++) {
	    	driver.navigate().back();
	    }
	}
	
	//Disabling multi-factor authentication
	@When("clicks on disable button")
	public void clicks_on_disable_button() throws InterruptedException {
		accSecPF.navigateToAccPass();
		accSecPF.navigateToAccPass();
		accSecPF.clickDisableMFA();
		accSecPF.clickConfirmDisable();
	}
	
	@Then("multi-factor authentication should be disabled")
	public void multi_factor_authentication_should_be_disabled() {
		for (int i = 0; i < 5; i++) {
			driver.navigate().back();
		}
	}
	
	//Negative testing of multi-factory authentication by giving invalid OTP
	@When("the user enters an invalid verification code {string}")
	public void the_user_enters_an_invalid_verification_code(String string) {
	    
	}
	@Then("the system should display an error message indicating the code is invalid")
	public void the_system_should_display_an_error_message_indicating_the_code_is_invalid() {
	    // Write code here that turns the phrase above into concrete actions
	}
}
