package com.POM.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Hotel_Page {
	
	public static WebDriver driver;
	
	@FindBy(xpath ="//select[@id='location']")
	private WebElement location;

	@FindBy(xpath = "//select[@id='hotels']")
	private WebElement hotel;
	
	@FindBy(xpath = "//select[@name='room_type']")
	private WebElement roomtype;
	
	@FindBy(xpath = "//select[@name='room_nos']")
	private WebElement NOofRooms;
	
	@FindBy(xpath ="//input[@name='datepick_in']")
	private WebElement pickIndate;
	
	@FindBy(xpath = "//input[@id='datepick_out']")
	private WebElement pickoutDate;
	
	@FindBy(xpath ="//select[@name='adult_room']")
	private WebElement adults;
	
	@FindBy(xpath = "//select[@name='child_room']")
	private WebElement Children;
	
	@FindBy(xpath = "//input[contains(@id,'Submit')]")
	private WebElement submit_btn;


	public Search_Hotel_Page(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getNOofRooms() {
		return NOofRooms;
	}

	public WebElement getPickIndate() {
		return pickIndate;
	}

	public WebElement getPickoutDate() {
		return pickoutDate;
	}

	public WebElement getAdults() {
		return adults;
	}

	public WebElement getChildren() {
		return Children;
	}

	public WebElement getSubmit_btn() {
		return submit_btn;
	}
	
	//right click for getters
	
	
	
	
}
