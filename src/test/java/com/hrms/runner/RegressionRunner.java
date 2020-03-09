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
	//basic report on console by "pretty" and html report by ...
	,plugin = {"pretty", "html:target/html/cucmber-default-report"}
	//enhanced report on console
	,monochrome=true
	,tags= {"@regression"}
	)
public class RegressionRunner {

}
