package com.POM.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booked_Itinerary_Page {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement radiobutton;

	@FindBy(xpath = "//input[@name='cancelall']")
	private WebElement cancelbooking;


	public Booked_Itinerary_Page(WebDriver driver2) {

	this.driver = driver2;
	PageFactory.initElements(driver, this);
		
	}

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getCancelbooking() {
		return cancelbooking;
	}
	
	
}
