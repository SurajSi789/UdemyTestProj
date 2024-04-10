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
import udemyPageFactory.SearchPF;

public class SearchStepDef {
	
	public static AppiumDriver<MobileElement> driver;
	SearchPF cp;
	
	public SearchStepDef() throws MalformedURLException {
		driver=DriverSetup.setDriver();
		cp = new SearchPF(driver);
	}
	
	// Search by valid keyword
	@Given("the user is on the Udemy homepage")
	public void the_user_is_on_the_udemy_homepage() {
	    cp.clickAppList();
	    cp.clickUdemyApp();
	}
	@When("the user enters coursename in the search bar")
	public void the_user_enters_coursename_in_the_search_bar(io.cucumber.datatable.DataTable dataTable) {
		cp.clickSearch();
		cp.enterCourseName(dataTable.cell(0, 0));
	    
	}
	@When("the user clicks the search button")
	public void the_user_clicks_the_search_button() throws InterruptedException {
		cp.clickAutomationTesting();
	}
	@Then("the search results page should be displayed")
	public void the_search_results_page_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/search_bar_text")));
	    String searchRes = driver.findElement(By.id("com.udemy.android:id/search_bar_text")).getText();
	    Assert.assertEquals(searchRes, "automation testing");
	}
	
	// Filter section
	@Given("the user is on the Udemy search results page")
	public void the_user_is_on_the_udemy_search_results_page() {
	    System.out.println("User is on the Udemy search results page");
	}
	@When("the user selects {string} category from the filters")
	public void the_user_selects_category_from_the_filters(String string) {
	    cp.clickFilter();
	    cp.clickFree();
	}
	@When("the user applies the filter")
	public void the_user_applies_the_filter() {
	    cp.clickApplyFilter();
	}
	@Then("the search results should only display courses related to software development")
	public void the_search_results_should_only_display_courses_related_to_software_development() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id=\"com.udemy.android:id/purchase_price\"])[1]")));
	    String freeFilter = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.udemy.android:id/purchase_price\"])[1]")).getText();
	    Assert.assertEquals(freeFilter, "Free");
	}
	
	// Sort section
	@When("the user selects ratings from the sorting options")
	public void the_user_selects_ratings_from_the_sorting_options() {
		cp.clickFilter();  
		cp.clickSort();
		cp.clickRatings();
	}
	@When("the user applies the sorting option")
	public void the_user_applies_the_sorting_option() {
		cp.clickApplyFilter();
	}
	@Then("the search results should be sorted based on relevance")
	public void the_search_results_should_be_sorted_based_on_relevance() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id=\"com.udemy.android:id/purchase_price\"])[1]")));
	    String freeFilter = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.udemy.android:id/purchase_price\"])[1]")).getText();
	    Assert.assertEquals(freeFilter, "Free");	    
	}
	
	// Navigation to Course details page
	@When("the user clicks on a course from the search results")
	public void the_user_clicks_on_a_course_from_the_search_results() {
	    cp.clickCourse();
	}
	@Then("the user should be redirected to the course page")
	public void the_user_should_be_redirected_to_the_course_page() {
	    //com.udemy.android:id/btnBuyNow
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/btnBuyNow")));
	    String enrollNow = driver.findElement(By.id("com.udemy.android:id/btnBuyNow")).getText();
	    Assert.assertEquals(enrollNow, "Enroll now");
	}
	@Then("the course details should be displayed accurately")
	public void the_course_details_should_be_displayed_accurately() {
	    for (int i = 1; i <= 6; i++) {
	    	driver.navigate().back();
	    }
	}
	
	// Search by invalid keyword
	@When("the user enters {string} in the search bar")
	public void the_user_enters_in_the_search_bar(String string) throws InterruptedException {
		cp.clickSearch();
		cp.enterCourseName(string);
	}
	
	@When("the user clicks the search icon")
	public void the_user_clicks_the_search_icon() throws InterruptedException {
		cp.searchClick();
	}
	
	@Then("the search results page should display a message indicating no results found")
	public void the_search_results_page_should_display_a_message_indicating_no_results_found() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/zero_state_message")));
	    String match = driver.findElement(By.id("com.udemy.android:id/zero_state_message")).getText();
	    Assert.assertEquals(match, "No matching courses");
	    for (int i = 1; i <= 6; i++) {
	    	driver.navigate().back();
	    }
	}
}
