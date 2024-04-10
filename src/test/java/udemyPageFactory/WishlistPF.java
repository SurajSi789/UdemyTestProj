package udemyPageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class WishlistPF {

	public static AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	TouchAction<?> touchAction;
	
	public WishlistPF(AppiumDriver<MobileElement> driver) {
		WishlistPF.driver = driver;
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
	
	public void scrollToCourse() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/welcome_user_fullname")));
		Thread.sleep(5000);
		touchAction.longPress(PointOption.point(956, 2512)).moveTo(PointOption.point(956, 1812)).release().perform();
	}
	
	// Add to Wishlist
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\" and @text=\"Excel Deep Dive: Pivot Tables Workshop\"]")
	private WebElement course;
	
	@FindBy(id = "com.udemy.android:id/wishlist_button")
	private WebElement wishlistButton;
	
	public void clickCourse() {
		wait.until(ExpectedConditions.visibilityOf(course));
		course.click();
	}
	
	public void clickWishlistButton() {
		wait.until(ExpectedConditions.visibilityOf(wishlistButton));
		wishlistButton.click();
	}
	
	// Wishlist UI
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/text\" and @text=\"Wishlist\"]")
	private WebElement wishlist;
	
	@FindAll(@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\"]"))
	private List<WebElement> wishlistCourses;
	
	public void clickWishlist() {
		wait.until(ExpectedConditions.visibilityOf(wishlist));
		wishlist.click();
	}
	
	public void clickWishlistCourse() {
		wait.until(ExpectedConditions.visibilityOfAllElements(wishlistCourses));
		for (WebElement course : wishlistCourses) {
			System.out.println(course.getText());
		}
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\" and @text=\"Excel Deep Dive: Pivot Tables Workshop\"]")
	private WebElement wishlistExcel;
	
	@FindAll(@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.udemy.android:id/purchase_price\"])[1]"))
	private WebElement wishlistPrice;
	
	public void assertWishlistCourse() {
		wait.until(ExpectedConditions.visibilityOf(wishlistExcel));
		String wishlist = wishlistExcel.getText();
		Assert.assertEquals(wishlist, "Excel Deep Dive: Pivot Tables Workshop");
		
		String price = wishlistPrice.getText();
		Assert.assertEquals(price, "₹549.00");
	}
	
	// Remove Wishlist
	
	public void clickExcelCourse() {
		wait.until(ExpectedConditions.visibilityOf(wishlistExcel));
		wishlistExcel.click();
	}
	
	public void clickWishlistedButton() {
		wait.until(ExpectedConditions.visibilityOf(wishlistButton));
		wishlistButton.click();
	}
	
	// Add to Cart
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\"]")
	private WebElement cartCourse;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Add to cart\"]")
	private WebElement cartButton;
	
	@FindBy(id = "com.udemy.android:id/md_button_positive")
	private WebElement cartConfirm;
	
	public void clickCartCourse() {
		wait.until(ExpectedConditions.visibilityOf(cartCourse));
		cartCourse.click();
	}
	
	public void clickCartButton() {
		wait.until(ExpectedConditions.visibilityOf(cartButton));
		cartButton.click();
	}
	
	public void clickCartConfirm() {
		wait.until(ExpectedConditions.visibilityOf(cartConfirm));
		cartConfirm.click();
	}
	
	// Wishlist from Search
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.udemy.android:id/text\" and @text=\"Search\"]")
	private WebElement search;
	
	@FindBy(id = "com.udemy.android:id/search_bar_text")
	private WebElement searchBar;
	
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.udemy.android:id/suggestions_list\"]/android.widget.LinearLayout[1]")
	private WebElement courseSearch;
	
	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\"])[1]")
	private WebElement courseADD;
	
	public void clickSearch() {
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}
	
	public void enterCourseName(String courseName) {
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.click();
		searchBar.sendKeys(courseName);
	}
	
	public void clickCourseSearch() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(courseSearch));
		courseSearch.click();
	}
	
	public void clickCourseADD() {
		wait.until(ExpectedConditions.visibilityOf(courseADD));
		courseADD.click();
	}
}
