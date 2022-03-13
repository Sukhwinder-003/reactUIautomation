package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author sukhwinder
 *
 */

@CucumberOptions(features = { "src/test/java/features/ValidateCountOnDashboard.feature",
		"src/test/java/features/ValidateListiingAndDetail.feature",
		"src/test/java/features/ValidateBrokenLink.feature" }, glue = "classpath:stepDefinitions", monochrome = true, tags = "@smoke", plugin = {
				"html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

// Runner file is use to executes all the feature files mentioned in the parameters
public class Runner extends AbstractTestNGCucumberTests {

}
