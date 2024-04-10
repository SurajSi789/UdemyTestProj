package udemyPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class LoginPF {
	
	public static AppiumDriver<MobileElement> driver;
	
	WebDriverWait wait;
	
	public LoginPF(AppiumDriver<MobileElement> driver) {
		LoginPF.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	@FindBy(id = "com.android.launcher3:id/all_apps_handle")
	private WebElement appList;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Udemy']")
	private WebElement udemyApp;
	
	@FindBy(id = "com.udemy.android:id/signin_button")
	private WebElement signIn;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Create an account\"]")
	private WebElement createAccountLink;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.udemy.android:id/title' and @text='Sign up with email']")
	private WebElement signUpWithEmail;
	
	@FindBy(id = "com.udemy.android:id/username_edit")
	private WebElement username;
	
	@FindBy(id = "com.udemy.android:id/email_edit")
	private WebElement email;
	
	@FindBy(id = "com.udemy.android:id/password_edit")
	private WebElement password;
	
	@FindBy(id = "com.udemy.android:id/create_account_button")
	private WebElement createAccount;
	
	@FindBy(id = "com.udemy.android:id/skip")
	private WebElement skip;
	
	public void clickAppList() {
		TouchAction<?> touchAction = new TouchAction<>(driver);
		touchAction.longPress(PointOption.point(731,2611)).moveTo(PointOption.point(731, 861)).release().perform();
	}
	
	public void clickUdemyApp() {
		wait.until(ExpectedConditions.visibilityOf(udemyApp));
		udemyApp.click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));
			driver.findElement(By.className("android.widget.Button")).click();
		} catch (Exception e) {
			System.out.println("No button found");
		}
	}
	
	public void clickSignIn() {
		wait.until(ExpectedConditions.visibilityOf(signIn));
		signIn.click();
	}
	
	public void clickCreateAccountLink() {
		wait.until(ExpectedConditions.visibilityOf(createAccountLink));
		createAccountLink.click();
	}
	
	public void clickSignUpWithEmail() {
		wait.until(ExpectedConditions.visibilityOf(signUpWithEmail));
		signUpWithEmail.click();
	}
	
	public void enterSignupDetails(String user, String mail, String pass) {
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(user);
		email.sendKeys(mail);
		password.sendKeys(pass);
	}
	
	public void clickCreateAccount() {
		createAccount.click();
	}
	
	public String clickSkip() {
		wait.until(ExpectedConditions.visibilityOf(skip));
		skip.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/welcome_user_fullname\"]")));
		String dashMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/welcome_user_fullname\"]")).getText();
		return dashMessage;
	}
	
	//For Sign out
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/text\" and @text=\"Account\"]")
	private WebElement accountTab;
	
	@FindBy(id = "com.udemy.android:id/sign_out")
	private WebElement signOut;
	
	@FindBy(id = "com.udemy.android:id/md_button_positive")
	private WebElement signOutButton;
	
	public void clickAccountTab() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(accountTab));
		accountTab.click();
		Thread.sleep(6000);
		TouchAction<?> touchAction = new TouchAction<>(driver);
		touchAction.longPress(PointOption.point(720, 2500)).moveTo(PointOption.point(720, 1500)).release().perform();
	}
	
	public void clickSignOut() {
		wait.until(ExpectedConditions.visibilityOf(signOut));
		signOut.click();
		wait.until(ExpectedConditions.visibilityOf(signOutButton));
		signOutButton.click();
	}
	
	// For Login
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/title\" and @text=\"Sign in with email\"]")
	private WebElement signInWithEmail;
	
	@FindBy(id = "com.udemy.android:id/email_edit")
	private WebElement enterEmail;
	
	@FindBy(id = "com.udemy.android:id/nextBtn")
	private WebElement nextButton;
	
	@FindBy(id = "com.udemy.android:id/password")
	private WebElement enterPassword;
	
	@FindBy(id = "com.udemy.android:id/signin_button")
	private WebElement signinButton;
	
	public void clickSignInWithEmail() {
		wait.until(ExpectedConditions.visibilityOf(signInWithEmail));
		signInWithEmail.click();
	}
	
	public void enterLoginDetails(String mail, String pass) {
		wait.until(ExpectedConditions.visibilityOf(enterEmail));
		enterEmail.sendKeys(mail);
		nextButton.click();
		wait.until(ExpectedConditions.visibilityOf(enterPassword));
		enterPassword.sendKeys(pass);
	}
	
	public void clickSignInButton() {
		signinButton.click();
	}
	
	// For Invalid Login
	
	public void enterInvalidEmail(String mail) {
		wait.until(ExpectedConditions.visibilityOf(enterEmail));
		enterEmail.sendKeys(mail);
		nextButton.click();
	}
	
	// For Forgot Password
	
	@FindBy(id = "com.udemy.android:id/forgot_password")
	private WebElement forgotPassword;
	
	@FindBy(id = "com.udemy.android:id/reset_password")
	private WebElement resetPassword;
	
	public void enterValidEmail(String mail) {
		wait.until(ExpectedConditions.visibilityOf(enterEmail));
		enterEmail.sendKeys(mail);
		nextButton.click();
	}
	
	public void nextButton() {
		nextButton.click();
	}
	
	public void clickForgotPassword() {
		wait.until(ExpectedConditions.visibilityOf(forgotPassword));
		forgotPassword.click();
	}
	
	public void enterResetEmail(String mail) {
		wait.until(ExpectedConditions.visibilityOf(resetPassword));
		resetPassword.sendKeys(mail);
	}
	
	public void clickResetPassword() {
		resetPassword.click();
	}
}
