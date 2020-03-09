package com.hrms.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features="src/test/resources/features",
			glue="com.hrms.steps",
			dryRun=true
			monochrome=true;
		)

public class PracticeRunner {

}
