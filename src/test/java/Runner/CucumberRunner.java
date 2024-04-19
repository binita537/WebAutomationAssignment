package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.webautomation.stepdefinitions",
                 features = "src/main/resources/features",
                		 tags = "@MultipleProductInCart",
                 plugin = {"pretty", "html:target/Reports/cucumber.html",
                		 "json:target/Reports/cucumber.json"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
 