package communityforum_1_stepdefinition;

import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.Status;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.pages.CommunityForumPage;
import com.pages.LandingPage;
import com.pages.UnansweredPage;
import com.pages.UnansweredSearchPage;
import com.utility.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunityForum_1_Step extends Utility{
	
	WebDriver driver;

	
	public LandingPage ldp;
	public CommunityForumPage cfp;
	public UnansweredPage un;
	public UnansweredSearchPage uns;
	
	public void objectMethod() throws IOException {

		ldp = new LandingPage();
		cfp = new CommunityForumPage();
		un = new UnansweredPage();
		uns = new UnansweredSearchPage();
	}
   
	
	//scenario 1
	@Given("Chrome is opened and opencart app is opened")
	public void chrome_is_opened_and_opencart_app_is_opened() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
        
        logger = report.createTest("test01");
       
        
        String actualtitle= ldp.validateLandingPageTitle();
        System.out.println(actualtitle);
        
        logger.log(Status.INFO, "Step1 is executed");
	}
	
	@Then("User navigates onto landing page and able to see logo")
	public void user_navigates_onto_landing_page_and_able_to_see_logo() throws IOException {
		objectMethod();
		Utility.implicitWait();
		boolean checkLogo=ldp.validateLogo();
		assertTrue(checkLogo);
		System.out.println("logo");
		
		 logger.log(Status.INFO, "Step2 is executed");
	}
	
	
	@When("User clicks on resources dropdown")
	public void user_clicks_on_resources_dropdown() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		ldp.CommunityForum();  
		
		 logger.log(Status.INFO, "Step3 is executed");

	}
	
	@When("User clicks on community forum")
	public void user_clicks_on_community_forum() throws IOException, InterruptedException {
		Utility.implicitWait();
		objectMethod();
		cfp=ldp.CommunityForum();
		
		 logger.log(Status.INFO, "Step4 is executed");
	}
	
	@Then("User navigates on community forum page")
	public void user_navigates_on_community_forum_page() throws InterruptedException, IOException {
		Utility.implicitWait();
		
		logger.log(Status.INFO, "Validating landing page title");
		
        String actualtitle1 = ldp.validateLandingPageTitle();
        String expectedtitle1 = "OpenCart Community - Index page";
        System.out.println(actualtitle1); 
        
        try {
            assertEquals(actualtitle1, expectedtitle1);
            logger.log(Status.PASS, "Step5 is passed");
            System.out.println(actualtitle1);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step5 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
	}
	
	
	//scenario 2
	@Then("User navigates on community forum page and see text")
	public void user_navigates_on_community_forum_page_and_see_text() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		boolean checkText=cfp.validateText();
		assertTrue(checkText);
		
		logger.log(Status.INFO, "Step6 is executed");
	}
	
	
	//scenario 3
	@Then("User click on dropdown list of search button and select Unanswered topics option")
	public void user_click_on_dropdown_list_of_search_button_and_select_unanswered_topics_option() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(5000);
	    cfp.unanswered();
	   // un=cfp.unanswered();
	    Thread.sleep(5000);
	    
	    logger.log(Status.INFO, "Step7 is executed");
	}
	
	
}
