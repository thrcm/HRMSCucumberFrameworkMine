package com.hrms.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources",
		glue= {"com.hrms.API.steps.practice"},
		dryRun=true,
		tags= {"@APITEST"}
	    )

public class APIRunner {

}
