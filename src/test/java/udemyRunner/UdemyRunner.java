package udemyRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "resources/accountsecurity.feature", glue = "login", tags="@multi_auth",
		plugin = { "pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
public class UdemyRunner extends AbstractTestNGCucumberTests {

}