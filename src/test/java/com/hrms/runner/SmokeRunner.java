package com.hrms.runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src//test//resources//features"
	//glue shows where your steps are
	,glue="com.hrms.steps"
	//dryRun finds steps that are not defined
	,dryRun = false
	//basic report on console by "pretty" and html report by ... and json report ... and failed test cases collected in here
	,plugin = {"pretty", "html:target/html/cucmber-default-report", "json:target/cucumber.json","rerun:target/failedTestCases.txt"}
	//enhanced report on console
	,monochrome=true
	,tags= {"@inProgress"}
	)
public class SmokeRunner {

}
