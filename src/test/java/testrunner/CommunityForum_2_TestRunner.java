package testrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features/CommunityForum_2.feature"},
		glue = {"communityforum_2_stepdefinitions", "apphooks"},
				 plugin= {"pretty" ,
						 "html:target/creport/cucumber",
						 "json:target/creport/cucumber.json",
				 		 "junit:target/creport/cucumber.xml"}
				 //dryRun = true

)
public class CommunityForum_2_TestRunner extends AbstractTestNGCucumberTests {
	  
}
