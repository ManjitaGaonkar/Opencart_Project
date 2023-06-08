package com.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class CommunityForumPage extends Utility {
 	
	
	public CommunityForumPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
    
	
	//display text
	@FindBy(xpath="//h1")
	private WebElement text;
	
	public boolean validateText()
	{
		System.out.println(text.isDisplayed());
		return text.isDisplayed();
	}
	
	
	//click on search dropdown and unanswered topics
	@FindBy(xpath="(//span[@class='caret'])[2]")
	private WebElement search;
	
	@FindBy(xpath="(//i[@class='fa fa-file-o fa-fw'])[1]")
	private WebElement UnansweredTopics;
	
	public void unanswered() 
	{    
		search.click();
	    UnansweredTopics.click();
	}
	
}
