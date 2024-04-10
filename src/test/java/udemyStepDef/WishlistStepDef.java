package udemyStepDef;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.*;
import udemyBaseClass.DriverSetup;
import udemyPageFactory.WishlistPF;

public class WishlistStepDef {
	
	public static AppiumDriver<MobileElement> driver;
	WishlistPF cp;
	
	public WishlistStepDef() throws MalformedURLException {
		driver=DriverSetup.setDriver();
		cp = new WishlistPF(driver);
	}

	//Testing Wishlist section's add functionality
	@Given("the user is logged into the Udemy app")
	public void the_user_is_logged_into_the_udemy_app() {
	    cp.clickAppList();
	    cp.clickUdemyApp();
	}
	@Given("the user is on the course page")
	public void the_user_is_on_the_course_page() throws InterruptedException {
	    cp.scrollToCourse();
	    cp.clickCourse();
	}
	
	@When("the user clicks on the Add to Wishlist button")
	public void the_user_clicks_on_the_add_to_wishlist_button() {
	    cp.clickWishlistButton();
	}
	@Then("the course should be added to the user wishlist")
	public void the_course_should_be_added_to_the_user_wishlist() {
	    // 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/wishlist_button")));
	    String wishlist = driver.findElement(By.id("com.udemy.android:id/wishlist_button")).getText();
	    Assert.assertEquals(wishlist, "Wishlisted");
	}
	
	//Testing Wishlist section's remove functionality
	@Given("the user is on the wishlist page")
	public void the_user_is_on_the_wishlist_page() {
	    cp.clickWishlist();
	}
	@Given("the wishlist contains at least one course")
	public void the_wishlist_contains_at_least_one_course() {
	    cp.clickWishlistCourse();
	}
	@When("the user clicks on the wishlisted button in the course")
	public void the_user_clicks_on_the_wishlisted_button_in_the_course() {
	    cp.clickExcelCourse();
	    cp.clickWishlistedButton();
	}
	@Then("the course should be removed from the wishlist")
	public void the_course_should_be_removed_from_the_wishlist() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/wishlist_button")));
	    String wishlist = driver.findElement(By.id("com.udemy.android:id/wishlist_button")).getText();
	    Assert.assertEquals(wishlist, "Add to wishlist");
	    driver.navigate().back();
	}
	
	//Add to cart
	@Given("the user is on the Udemy homepage")
	public void the_user_is_on_the_udemy_homepage() {
		driver.navigate().back();	    
	}
	@When("the user clicks on the course")
	public void the_user_clicks_on_the_course() {
	    cp.clickCartCourse();
	}
	@When("the user clicks on add to cart button")
	public void the_user_clicks_on_add_to_cart_button() {
	    cp.clickCartButton();
	    cp.clickCartConfirm();
	}
	@Then("the product should be added to cart")
	public void the_product_should_be_added_to_cart() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"You've successfully added\"]")));
	    String added = driver.findElement(By.xpath("//android.widget.TextView[@text=\"You've successfully added\"]")).getText();
	    Assert.assertEquals(added, "You've successfully added");
	    
		for (int i = 0; i < 2; i++) {
			driver.navigate().back();
		}
	}
	
	//Testing Wishlist UI
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		driver.navigate().back();
	}
	@When("the user navigates to the wishlist section")
	public void the_user_navigates_to_the_wishlist_section() {
	    cp.clickWishlist();
	}
	@Then("the user should see a list of courses added to the wishlist")
	public void the_user_should_see_a_list_of_courses_added_to_the_wishlist() {
	    cp.clickWishlistCourse();
	}
	@Then("each course should display its title, and price")
	public void each_course_should_display_its_title_and_price() {
	    cp.assertWishlistCourse();
	}
	
	//Testing addition of course to wishlist from search results
	@Given("the user is on the search results page")
	public void the_user_is_on_the_search_results_page() {
	    cp.clickSearch();
	}
	@Given("the search results contain courses related to {string}")
	public void the_search_results_contain_courses_related_to(String string) throws InterruptedException {
	    cp.enterCourseName(string);
	    cp.clickCourseSearch();
	    cp.clickCourseADD();
	}
	@When("the user clicks on the Add to Wishlist button next to a course")
	public void the_user_clicks_on_the_add_to_wishlist_button_next_to_a_course() {
	    cp.clickWishlistButton();
	}
	@Then("the course should be added to the users wishlist")
	public void the_course_should_be_added_to_the_users_wishlist() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/wishlist_button")));
	    String wishlist = driver.findElement(By.id("com.udemy.android:id/wishlist_button")).getText();
	    Assert.assertEquals(wishlist, "Wishlisted");
		for (int i = 0; i < 2; i++) {
			driver.navigate().back();
		}
	}
}
