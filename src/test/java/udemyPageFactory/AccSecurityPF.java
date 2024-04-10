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

public class AccSecurityPF {
	
	public static AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	
	public AccSecurityPF(AppiumDriver<MobileElement> driver) {
		AccSecurityPF.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	@FindBy(id = "com.udemy.android:id/signin_button")
	private WebElement signIn;
	
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
		driver.findElement(By.id("android:id/button1")).click();
		wait.until(ExpectedConditions.visibilityOf(signIn));
		signIn.click();
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
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Udemy\"]")
	private WebElement Udemyapp;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/text\" and @text=\"Account\"]")
	private WebElement accountTab;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/title\" and @text=\"Account security\"]")
	private WebElement accountSecurity;
	
	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement currentPassword;
	
	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement newPassword;
	
	@FindBy(xpath = "//android.widget.EditText[3]")
	private WebElement retypePassword;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Change password\"]")
	private WebElement changePassword;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Enable\"]")
	private WebElement enable;

	@FindBy(xpath = "//android.widget.Button[@text=\"Confirm\"]")
	private WebElement confirm;

	@FindBy(xpath = "//android.view.View[@text=\"Email\"]")
	private WebElement email;

	@FindBy(xpath = "//android.view.View[@text=\"Password\"]")
	private WebElement passw;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Log in\"]")
	private WebElement login;

	@FindBy(xpath = "//android.view.View[@text=\"One time password\"]")
	private WebElement code;

	@FindBy(xpath = "//android.widget.Button[@text=\"Verify\"]")
	private WebElement verify;
	
	public void clickUdemyApp() {
		TouchAction<?> touch = new TouchAction<>(driver);
		touch.longPress(PointOption.point(720, 2600)).moveTo(PointOption.point(700,1000)).release().perform();
		Udemyapp.click();
	}
	
	public void clickAccount() {
		wait.until(ExpectedConditions.visibilityOf(accountTab));
		accountTab.click();
	}
	
	public void clickAccountSec() {
		wait.until(ExpectedConditions.elementToBeClickable(accountSecurity));
		accountSecurity.click();
	}
	
	public void navigateToAccPass() throws InterruptedException {
		Thread.sleep(3000);
		TouchAction<?> touch = new TouchAction<>(driver);
		touch.longPress(PointOption.point(720, 2600)).moveTo(PointOption.point(700,1000)).release().perform();
	}

	public void enterCurrentPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[1]")));
		currentPassword.sendKeys(password);
	}
	
	public void enterNewPassword(String password) {
		newPassword.sendKeys(password);
	}
	
	public void retypeNewPassword(String password) {
		retypePassword.sendKeys(password);
	}
	
	public void clickChangePassword() {
		wait.until(ExpectedConditions.visibilityOf(changePassword));
		changePassword.click();
	}
	
	public void clickEnable() {
		enable.click();
	}
	
	public void clickConfirm() {
		confirm.click();
	}
	
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void enterPassword(String password) {
		passw.sendKeys(password);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void enterCode(String code) {
		this.code.sendKeys(code);
	}
	
	public void clickVerify() {
		verify.click();
	}
	
	
	public void changePassword(String currentPassword, String newPassword) {
		enterCurrentPassword(currentPassword);
		enterNewPassword(newPassword);
		retypeNewPassword(newPassword);
		clickChangePassword();
	}
	
	public void enableTwoStepVerification(String email, String password) {
		clickEnable();
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}
	
	public void verifyCode(String code) {
		enterCode(code);
		clickVerify();
	}
	
	// Multi Factor Authentication
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Enable\"]")
	private WebElement enableMFA;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Confirm\"]")
	private WebElement confirmMFA;
	
	@FindBy(id = "com.udemy.android:id/verify_button")
	private WebElement verifyButton;
	
	@FindBy(id = "com.udemy.android:id/auth_code_edit")
	private WebElement authCode;
	
	public void clickEnableMFA() {
		wait.until(ExpectedConditions.visibilityOf(enableMFA));
		enableMFA.click();
	}
	
	public void clickConfirmMFA() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text=\"Confirm\"]")));
		confirmMFA.click();
	}
	
	public void enterAuthCode() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(authCode));
		for (int i = 0; i < 7; i++) {
			Thread.sleep(10000);
			if (authCode.getText().length() == 6) {
				break;
			}
		}
	}
	
	public void clickVerifyButton() {
		wait.until(ExpectedConditions.visibilityOf(verifyButton));
		verifyButton.click();
	}

	// Disable Multi Factor Authentication
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Disable\"]")
	private WebElement disableMFA;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Confirm\"]")
	private WebElement confirmDisable;
	
	public void clickDisableMFA() {
		wait.until(ExpectedConditions.visibilityOf(disableMFA));
		disableMFA.click();
	}
	
	public void clickConfirmDisable() {
		wait.until(ExpectedConditions.visibilityOf(confirmDisable));
		confirmDisable.click();
	}
}
