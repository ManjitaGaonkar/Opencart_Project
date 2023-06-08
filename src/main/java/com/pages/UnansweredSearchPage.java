package com.pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class UnansweredSearchPage extends Utility {
	
	public UnansweredSearchPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	
	public  String validateUnansweredSearchTitle()
	{
		return driver.getTitle(); 
	}  

}
