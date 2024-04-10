package udemyStepDef;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.*;

import org.testng.Assert;
import udemyBaseClass.DriverSetup;
import udemyPageFactory.CoursePF;

public class CourseStepDef {
	public static AppiumDriver<MobileElement> driver;
	CoursePF cp;
	
	public CourseStepDef() throws MalformedURLException {
		driver=DriverSetup.setDriver();
		cp = new CoursePF(driver);
	}

	// Browse Course
	@Given("I am logged in as a student on Udemy")
	public void i_am_logged_in_as_a_student_on_udemy() {
	    cp.clickAppList();
	    cp.clickUdemyApp();
	}
	@When("I navigate to the course catalog")
	public void i_navigate_to_the_course_catalog() throws InterruptedException {
	    cp.scrollToCourseCategories();
	}
	@Then("I should see a list of available courses")
	public void i_should_see_a_list_of_available_courses() throws InterruptedException {
	    cp.clickDifferentCategories();
	}
	@Then("I should be able to browse through different categories and topics")
	public void i_should_be_able_to_browse_through_different_categories_and_topics() {
	    System.out.println("Browsing through different categories and topics");
	}
	
	// Enroll Course
	@Given("I am on course category page")
	public void i_am_on_course_category_page() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/title\" and @text=\"Development\"]")));
	    String category = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/title\" and @text=\"Development\"]")).getText();
	    Assert.assertEquals(category, "Development");
	}
	
	@When("I find a free course I am interested in")
	public void i_find_a_free_course_i_am_interested_in() throws InterruptedException {
		cp.clickFilter();
		cp.scrollToFree();
		cp.clickFree();
		cp.clickApply();
	}
	@When("I click on the course title to view its details")
	public void i_click_on_the_course_title_to_view_its_details() {
	    cp.clickCourseTitle();
	}
	@When("I click on the enroll Now button")
	public void i_click_on_the_enroll_now_button() throws InterruptedException {
		Thread.sleep(8000);
	}
	@Then("I should be successfully enrolled in the course")
	public void i_should_be_successfully_enrolled_in_the_course() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.udemy.android:id/enrollment_date")));
		String enrolled = driver.findElement(By.id("com.udemy.android:id/enrollment_date")).getText();
		Assert.assertEquals(enrolled, "You enrolled in this course on April 9, 2024");
	}
	@Then("I should have access to the course content and resources")
	public void i_should_have_access_to_the_course_content_and_resources() throws InterruptedException {
	    driver.navigate().back();
	}

	// Course Content
	@Given("I am on mylearning page")
	public void i_am_on_mylearning_page() {
		cp.clickMyLearning();
	}
	
	@When("I navigate to a course I have enrolled in")
	public void i_navigate_to_a_course_i_have_enrolled_in() throws InterruptedException {
	    cp.clickCourse();
	}
	@Then("I should see a list of course modules and lectures")
	public void i_should_see_a_list_of_course_modules_and_lectures() {
	    System.out.println("List of course modules and lectures");
	}
	@Then("I should be able to view the lecture videos, documents, quizzes, etc.")
	public void i_should_be_able_to_view_the_lecture_videos_documents_quizzes_etc() {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/title\" and @text=\"Section 2 - Basic Syntax\"]")));
	    String play = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/title\" and @text=\"Section 2 - Basic Syntax\"]")).getText();
	    Assert.assertEquals(play, "Section 2 - Basic Syntax");
	}
	
	// Course Tracking
	
	@Given("I am back to mylearning page")
	public void i_am_back_to_mylearning_page() {
		driver.navigate().back();
	}
	
	@When("I am viewing a course I have enrolled in")
	public void i_am_viewing_a_course_i_have_enrolled_in() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\"])[1]")));
	    String play = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_title\"])[1]")).getText();
	    Assert.assertEquals(play, "Javascript Essentials");
	}
	@Then("I should see my progress through the course")
	public void i_should_see_my_progress_through_the_course() {
		String progress = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.udemy.android:id/course_status\" and @text=\"3% complete\"]")).getText();
		System.out.println("The progress is = "+progress);
	}
	@Then("I should be able to mark lectures as completed")
	public void i_should_be_able_to_mark_lectures_as_completed() throws InterruptedException {
	    cp.clickCourse();
	    cp.clickActMore();
	    cp.clickMarkComplete();
	}
	
	// Note Course
	
	@Given("I am on the course watch page")
	public void i_am_on_the_course_watch_page() {
		System.out.println("Course watch page");
	}
	
	@When("I click on more section")
	public void i_click_on_more_section() {
	    cp.clickMore();
	}
	@When("I click on note tab")
	public void i_click_on_note_tab() {
	    cp.clickNotes();
	}
	
	@When("I click on add button")
	public void i_click_on_add_button() {
	    cp.clickNotesFab();
	}
	@When("I leave a note {string}")
	public void i_leave_a_note(String string) {
	    cp.enterText(string);
	}
	@When("I click on the Submit note button")
	public void i_click_on_the_submit_note_button() {
	    cp.clickSaveNote();
	}
	@Then("my note should be successfully submitted")
	public void my_note_should_be_successfully_submitted() {
	    System.out.println("Note submitted successfully");
	    driver.navigate().back();
	}
}
