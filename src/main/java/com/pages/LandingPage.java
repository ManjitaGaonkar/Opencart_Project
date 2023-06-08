package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class LandingPage extends Utility 
{

	public LandingPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	
	} 
	
	public String validateLandingPageTitle()
	{
		return validatePageTitle(); 
	} 
	
	
	//click on resource dropdown and community forum
	@FindBy(xpath="(//span[@class='caret'])[1]")
	private WebElement dropdown;
	
	@FindBy(xpath="//*[text() = 'Community Forums']")
	private WebElement CommunityForum; 

	public CommunityForumPage CommunityForum() throws IOException {		
		dropdown.click();
		CommunityForum.click();
		return new CommunityForumPage();
	}
	
	
	//validate logo	
	@FindBy(xpath="//img[@title='OpenCart - Open Source Shopping Cart Solution'][1]")
	private WebElement logo;
	
	public boolean validateLogo()
	{
		System.out.println(logo.isDisplayed());
		return logo.isDisplayed();
	}
	
	
}
	


