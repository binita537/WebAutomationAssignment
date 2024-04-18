package com.webautomation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.webautomation.stepdefinitions",
                 features = "src/main/resources/features")
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

