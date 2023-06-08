package excel_stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.pages.CommunityForumPage;
import com.pages.LandingPage;
import com.pages.UnansweredPage;
import com.pages.UnansweredSearchPage;
import com.utility.Config;
import com.utility.ExcelReader;
import com.utility.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Excel_Step extends Utility {
	
WebDriver driver;

	
	public LandingPage ldp;
	public CommunityForumPage cfp;
	public UnansweredPage un;
	public UnansweredSearchPage uns;
	ExcelReader reader;
	
	public void objectMethod() throws IOException {

		ldp = new LandingPage();
		cfp = new CommunityForumPage();
		un = new UnansweredPage();
		uns = new UnansweredSearchPage();
	}

	@Given("Chrome is opened and opencart app is opened")
	public void chrome_is_opened_and_opencart_app_is_opened() throws IOException {
	    
		objectMethod();
		Utility.implicitWait();
        
        logger = report.createTest("test03");
       
        
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
	
	@Then("User click on dropdown list of search button and select Unanswered topics option")
	public void user_click_on_dropdown_list_of_search_button_and_select_unanswered_topics_option() throws IOException, InterruptedException {
	    
		objectMethod();
		Thread.sleep(2000);
	    cfp.unanswered();
	   // un=cfp.unanswered();
	    Thread.sleep(2000);
	    
	    logger.log(Status.INFO, "Step6 is executed");
	}
	
	@When("User fills the data from given sheetname {string} and rownumber {int}")
	public void user_fills_the_data_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
	    
		Utility.implicitWait();
		objectMethod();
		reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetName);
		
        String str = testData.get(rowNumber).get("String");
        
        un.EnterData(str);
		
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
	
}
