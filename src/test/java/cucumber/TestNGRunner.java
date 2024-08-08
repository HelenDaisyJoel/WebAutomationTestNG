package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/cucumber",
	    glue = "stepDefinition", // Just the package name, not the full path
	    monochrome = true,
	    plugin = {"html:target/cucumber-reports.html"}
	)
	public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	}

