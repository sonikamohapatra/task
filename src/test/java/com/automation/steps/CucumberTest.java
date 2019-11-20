package com.automation.steps;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "task.feature"
 ,glue={"stepDefinition"}
 )
 
public class CucumberTest {
 
}