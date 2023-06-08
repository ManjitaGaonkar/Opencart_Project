package testrunner;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features/CommunityForum_1.feature"},
		glue = {"communityforum_1_stepdefinition", "apphooks"},
				 plugin= {"pretty" ,
						 "html:target/creport/cucumber",
						 "json:target/creport/cucumber.json",
				 		 "junit:target/creport/cucumber.xml"}
				 //dryRun = true

)
public class CommunityForum_1_TestRunner extends AbstractTestNGCucumberTests {
  
}
