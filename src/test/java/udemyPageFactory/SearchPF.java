package udemyPageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SearchPF {
	
	public static AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	TouchAction<?> touchAction;
	
	public SearchPF(AppiumDriver<MobileElement> driver) {
		SearchPF.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		touchAction = new TouchAction<>(driver);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Udemy']")
	private WebElement udemyApp;
	
	//Open App
	
	public void clickAppList() {
		touchAction.longPress(PointOption.point(731,2611)).moveTo(PointOption.point(731, 861)).release().perform();	
	}
	
	public void clickUdemyApp() {
		wait.until(ExpectedConditions.visibilityOf(udemyApp));
		udemyApp.click();
	}
	
	// Search
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/text\" and @text=\"Search\"]")
	private WebElement search;
	
	@FindBy(id = "com.udemy.android:id/search_bar_text")
	private WebElement searchBar;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/body\" and @text=\"automation testing\"]")
	private WebElement automationTesting;
	
	public void clickSearch() {
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}
	
	public void enterCourseName(String courseName) {
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.click();
		searchBar.sendKeys(courseName);
	}
	
	public void clickAutomationTesting() {
		wait.until(ExpectedConditions.visibilityOf(automationTesting));
		automationTesting.click();
	}
	
	// filter
	
	@FindBy(id = "com.udemy.android:id/action_filter")
	private WebElement filter;
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.udemy.android:id/filter_radio_button\" and @text=\"‎Free‎ (859)\"]")
	private WebElement free;
	
	@FindBy(id = "com.udemy.android:id/apply_filters")
	private WebElement applyFilter;
	
	public void clickFilter() {
		wait.until(ExpectedConditions.visibilityOf(filter));
		filter.click();
	}
	
	public void clickFree() {
		wait.until(ExpectedConditions.visibilityOf(free));
		free.click();
	}
	
	public void clickApplyFilter() {
		wait.until(ExpectedConditions.visibilityOf(applyFilter));
		applyFilter.click();
	}
	
	// sort
	
	@FindBy(id = "android:id/text1")
	private WebElement sortRating;
	
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Ratings\"]")
	private WebElement ratings;
	
	public void clickSort() {
		wait.until(ExpectedConditions.visibilityOf(sortRating));
		sortRating.click();
	}
	
	public void clickRatings() {
		wait.until(ExpectedConditions.visibilityOf(ratings));
		ratings.click();
	}
	
	// course details
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\" and @text=\"Sauce Labs Masterclass: Advanced Test Automation\"]")
	private WebElement course;
	
	public void clickCourse() {
		wait.until(ExpectedConditions.visibilityOf(course));
		course.click();
	}
	
	public void searchClick() throws InterruptedException {
		Thread.sleep(2000);
		touchAction.press(PointOption.point(1326, 2820)).release().perform();
	}
}
