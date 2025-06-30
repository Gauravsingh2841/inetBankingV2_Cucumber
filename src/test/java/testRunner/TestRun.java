package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		//features={".//Features/Login.feature", ".//Features/Customers.feature"},
		features=".//Features/",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:test-output"},
		tags= {"@Sanity, @Regression"} //This means execute Sanity or Regression, so both types will get executed
		)
public class TestRun {
	

}

/* Since, the "https://admin-demo.nopcommerce.com/login" url is not working properly on automation,
I have used "https://demo.guru99.com/V1/index.php".
*/