package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.webautomation.stepdefinitions",
                 features = "src/main/resources/features",
                 plugin = {"pretty", "html:target/cucumber-reports"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
