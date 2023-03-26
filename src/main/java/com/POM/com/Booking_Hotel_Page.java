package com.POM.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Hotel_Page {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[contains(@name,'first_name')]")
	private WebElement firstname;
	
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastname;
	
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='cc_num']")
	private WebElement CreditcardNo;
	
	@FindBy(xpath = "//select[@id='cc_type']")
	private WebElement CCtype;
	
	@FindBy(xpath = "//select[@name='cc_exp_month']")
	private WebElement ccExpiredate;
	
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement CCexpireyear;
	
	@FindBy(xpath = "//input[@name='cc_cvv']")
	private WebElement cvv;
	
	@FindBy(xpath = "//input[@name='book_now']")
	private WebElement booknowBTN;
	
	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")
	private WebElement Bookingitenary;

	public WebElement getBookingitenary() {
		return Bookingitenary;
	}

	public Booking_Hotel_Page(WebDriver driver2) {
		
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditcardNo() {
		return CreditcardNo;
	}

	public WebElement getCCtype() {
		return CCtype;
	}

	public WebElement getCcExpiredate() {
		return ccExpiredate;
	}

	public WebElement getCCexpireyear() {
		return CCexpireyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBooknowBTN() {
		return booknowBTN;
	}
	
	//right click for getter
	
	
	
}
