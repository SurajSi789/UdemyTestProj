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

public class CoursePF {

	public static AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	TouchAction<?> touchAction;
	
	public CoursePF(AppiumDriver<MobileElement> driver) {
		CoursePF.driver = driver;
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
	
	public void scrollToCourseCategories() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/welcome_user_fullname")));
		Thread.sleep(3000);
		for (int i = 0; i < 2; i++) {
			touchAction.longPress(PointOption.point(956, 2512)).moveTo(PointOption.point(956, 303)).release().perform();
		}
	}
	
	// Categories
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/courseCategoryListTextItem\" and @text=\"IT & Software\"]")
	private WebElement itAndSoftware;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/courseCategoryListTextItem\" and @text=\"Development\"]")
	private WebElement development;
	
	public void clickDifferentCategories() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(itAndSoftware));
		itAndSoftware.click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		wait.until(ExpectedConditions.visibilityOf(development));
        development.click();
	}
	
	// Filter
	
	@FindBy(id = "com.udemy.android:id/action_filter")
	private WebElement filter;
	
	public void scrollToFree() throws InterruptedException {
		Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			touchAction.longPress(PointOption.point(730, 2621)).moveTo(PointOption.point(730, 397)).release().perform();
		}
	}
	
	@FindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.udemy.android:id/filter_radio_button\" and @text=\"‎Free‎ (3,773)\"]")
	private WebElement free;
	
	@FindBy(id = "com.udemy.android:id/apply_filters")
	private WebElement applyFilters;
	
	public void clickFree() {
		wait.until(ExpectedConditions.visibilityOf(free));
		free.click();
	}
	
	public void clickFilter() {
		wait.until(ExpectedConditions.visibilityOf(filter));
		filter.click();
	}
	
	public void clickApply() {
		wait.until(ExpectedConditions.visibilityOf(applyFilters));
		applyFilters.click();
	}
	
	// Enroll Course
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\" and @text=\"Introduction To Python Programming\"]")
	private WebElement courseTitle;
	
	@FindBy(id = "com.udemy.android:id/btnBuyNow")
	private WebElement enrollNow;
	
	public void clickCourseTitle() {
		wait.until(ExpectedConditions.visibilityOf(courseTitle));
		courseTitle.click();
	}
	
	public void clickEnrollNow() {
		wait.until(ExpectedConditions.visibilityOf(enrollNow));
		enrollNow.click();
		touchAction.press(PointOption.point(736, 2353)).release().perform();
	}
	
	@FindBy(id = "com.udemy.android:id/getStartedButton")
	private WebElement getStarted;
	
	public void clickGetStarted() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(getStarted));
		getStarted.click();
		
		Thread.sleep(4000);
		driver.navigate().back();
	}
	
	@FindBy(id = "com.udemy.android:id/play_button")
	private WebElement playButton;
	
	public void clickPlayButton() {
		wait.until(ExpectedConditions.visibilityOf(playButton));
		playButton.click();
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"My learning tab\"]")
	private WebElement myLearning;
	
	public void clickMyLearning() {
		wait.until(ExpectedConditions.visibilityOf(myLearning));
		myLearning.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\" and @text=\"Javascript Essentials\"]")
	private WebElement course;
	
	public void clickCourse() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(course));
		course.click();
		
		Thread.sleep(4000);
		touchAction.press(PointOption.point(710, 490)).release().perform();
		Thread.sleep(3000);
		touchAction.press(PointOption.point(710, 490)).release().perform();
		Thread.sleep(1000);
	}
	
	// Marking Complete
	
	@FindBy(id = "com.udemy.android:id/action_more")
	private WebElement actMore;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Mark as Complete\"]")
	private WebElement markComplete;
	
	public void clickActMore() {
		wait.until(ExpectedConditions.visibilityOf(actMore));
		actMore.click();
	}
	
	public void clickMarkComplete() {
		wait.until(ExpectedConditions.visibilityOf(markComplete));
		markComplete.click();
	}
	
	// Note Taking
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"More\"]")
	private WebElement more;
	
	@FindBy(id = "com.udemy.android:id/notesTxt")
	private WebElement notes;
	
	@FindBy(id = "com.udemy.android:id/notes_fab")
	private WebElement notesFab;
	
	@FindBy(id = "com.udemy.android:id/edittext_note")
	private WebElement editTextNote;
	
	@FindBy(id = "com.udemy.android:id/background_save_note_at_time")
	private WebElement saveNote;
	
	public void clickMore() {
		wait.until(ExpectedConditions.visibilityOf(more));
		more.click();
	}
	
	public void clickNotes() {
		wait.until(ExpectedConditions.visibilityOf(notes));
		notes.click();
	}
	
	public void clickNotesFab() {
		wait.until(ExpectedConditions.visibilityOf(notesFab));
		notesFab.click();
	}
	
	public void enterText(String s) {
		wait.until(ExpectedConditions.visibilityOf(editTextNote));
		editTextNote.sendKeys(s);
	}
	
	public void clickSaveNote() {
		wait.until(ExpectedConditions.visibilityOf(saveNote));
		saveNote.click();
	}
}
