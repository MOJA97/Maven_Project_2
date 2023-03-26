package com.POM.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	 public static WebDriver driver;
	 
	 @FindBy(xpath ="//input[@id='username']")
	 private WebElement username;
	 
	 @FindBy(xpath = "//input[@name='password']")
	 private WebElement pass;
	 
	 @FindBy(xpath = "//input[@type='Submit']")
	 private WebElement Login_btn;
	 
	 //right cilck--->>> source and getter
	 
	
	public Login_page(WebDriver driver2) {

		this.driver = driver2;
		 //pagefactory used to store n number of element
		 PageFactory.initElements(driver, this);
	}

	public WebElement getUserLP() {
		return username;
	}

	public WebElement getPassLP() {
		return pass;
	}

	public WebElement getLogin_btnLP() {
		return Login_btn;
	}

	
	
	 
	 
	 
	 
	 
}
