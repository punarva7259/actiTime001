package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions
	(
			features=".//Features/",
			glue="StepDefinitions",
			dryRun=false,
			monochrome=true,
			plugin= {"pretty",
                    "html:target/cucumber-report.html",
                    "json:target/cucumber.json"},
			tags= "@sanity"
			
	
     )

 public class TestRuns extends AbstractTestNGCucumberTests  {
}
