package communityforum_2_stepdefinitions;

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

public class CommunityForum_2_Step extends Utility{
	
	WebDriver driver;
	
	public LandingPage ldp;
	public CommunityForumPage cfp;
	public UnansweredPage un;
	public UnansweredSearchPage uns;
	
	public void objectMethod() throws IOException 
	{

		ldp = new LandingPage();
		cfp = new CommunityForumPage();
		un = new UnansweredPage();
		uns = new UnansweredSearchPage();
	}
	
	
	//scenario 1
	@Given("Chrome is opened and opencart app is opened")
	public void chrome_is_opened_and_opencart_app_is_opened() throws IOException {
		objectMethod();
		Utility.implicitWait();
        
        logger = report.createTest("test02");
        
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
	public void user_clicks_on_resources_dropdown() throws IOException {
		objectMethod();
		Utility.implicitWait();
		ldp.CommunityForum();  
		
		 logger.log(Status.INFO, "Step3 is executed");
	}
	
	@When("User clicks on community forum")
	public void user_clicks_on_community_forum() throws IOException {
		Utility.implicitWait();
		objectMethod();
		cfp=ldp.CommunityForum();	
		
		 logger.log(Status.INFO, "Step4 is executed");
	}
	
	@Then("User navigates on community forum page")
	public void user_navigates_on_community_forum_page() throws IOException {
		Utility.implicitWait();
		
		logger.log(Status.INFO, "Validating landing page title");
		
        String actualtitle1 = ldp.validateLandingPageTitle();
        String expectedtitle1 = "OpenCart Community - Index page";
              
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
	
	@Then("User click on dropdown list of search button and select Unanswered topics option")
	public void user_click_on_dropdown_list_of_search_button_and_select_unanswered_topics_option() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
	    cfp.unanswered();
	    //un=cfp.unanswered();
	    Thread.sleep(2000);
	    
	    logger.log(Status.INFO, "Step6 is executed");
	}
	
	@When("User enters data in {string}")
	public void user_enters_data_in(String str1) throws IOException 
	{
		Utility.implicitWait();
		objectMethod();
		un.EnterData(str1);
		
		logger.log(Status.INFO, "Step7 is executed");
	}
	
	@When("clicks on search icon")
	public void clicks_on_search_icon() throws IOException {
		Utility.implicitWait();
		objectMethod();
		uns = un.SearchIcon();
		
		logger.log(Status.INFO, "Step8 is executed");
	}

	
	@Then("User is able to see all the related topics")
	public void user_is_able_to_see_all_the_related_topics() throws IOException {
		Utility.implicitWait();
		
		logger.log(Status.INFO, "Validating Unanswered page title");
		
		Utility.scroll();
		
        String actualtitle2 = un.validateUnansweredPageTitle();
        String expectedtitle2 = "OpenCart Community - Information";
               
        try {
            assertEquals(actualtitle2, expectedtitle2);
            logger.log(Status.PASS, "Step9 is passed");
            System.out.println(actualtitle2);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step9 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
        
		
	}

	
	//scenario 2
	@Then("User do not find anything")
	public void user_do_not_find_anything() throws InterruptedException, IOException {
		Utility.implicitWait();
		
		logger.log(Status.INFO, "Validating Unanswered page title");
		
		Utility.scroll();
		   
        String actualtitle3 = un.validateUnansweredPageTitle();
        String expectedtitle3 = "OpenCart Community - Unanswered topics";
        
        try {
            assertEquals(actualtitle3, expectedtitle3);
            logger.log(Status.PASS, "Step10 is passed");
            System.out.println(actualtitle3);
            assert true;
        } catch (AssertionError e) {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step10 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
     
	}
	
	
	
}
