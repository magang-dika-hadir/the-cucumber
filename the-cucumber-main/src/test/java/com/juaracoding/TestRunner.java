package com.juaracoding;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features",
            glue = "com.juaracoding",
            plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
