package com.RunnerClassPOM.com;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClass.com.Reusable_Methods;
import com.POM.com.Login_page;

public class Runner_POM_Excel extends Reusable_Methods {
	
	public static WebDriver driver = browser_Launch("Chrome");

	static Login_page login = new Login_page(driver);
	
	public static void main(String[] args) throws InterruptedException, IOException, InvalidFormatException {
		
		get_Url(driver, "https://adactinhotelapp.com/");

		window_Manage("maximize");
		
		String username = get_Data_excel("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Adactin.xlsx", 3, 1, 0);

		send_Values(login.getUserLP(), username);

		String password = get_Data_excel("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Adactin.xlsx", 3, 1, 1);
		send_Values(login.getPassLP(), password );

		click(login.getLogin_btnLP());

		
		
	}

}
