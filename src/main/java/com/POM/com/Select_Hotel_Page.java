package com.POM.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Select_Hotel_Page {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@type='radio']")
	private WebElement radiobutton;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continuebutton;

	
	public Select_Hotel_Page(WebDriver driver2) {

	this.driver = driver2;
	PageFactory.initElements(driver, this);
	
	}

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getContinuebutton() {
		return continuebutton;
	}
	
	//right click for getters
	
}
