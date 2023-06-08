package com.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class UnansweredPage extends Utility{
	
	public UnansweredPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public  String validateUnansweredPageTitle()
	{
		return driver.getTitle(); 
	} 
	
	
	//type in search field
	@FindBy(xpath="(//*[@name='add_keywords'])[1]")
	private WebElement searchfield;
	
	public void EnterData(String str) 
	{    
		searchfield.sendKeys(str);		
	}
	
	
	//click on search icon
	@FindBy(xpath="(//i[@class='fa fa-search fa-fw'])[5]")
	private WebElement searchIcon;
	
	public UnansweredSearchPage SearchIcon() throws IOException {
		searchIcon.click();
		return new UnansweredSearchPage();
	}
	
}
