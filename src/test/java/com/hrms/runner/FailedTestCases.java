package com.hrms.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="target/failedTestCases.txt"
		,glue="com.hrms/steps"
		,monochrome=true
		,plugin="pretty"
		)

public class FailedTestCases {

}
