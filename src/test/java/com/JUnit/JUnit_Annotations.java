package com.JUnit;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClass.com.Reusable_Methods;
import com.POM.com.Booked_Itinerary_Page;
import com.POM.com.Booking_Hotel_Page;
import com.POM.com.Login_page;
import com.POM.com.Logout_Page;
import com.POM.com.Search_Hotel_Page;
import com.POM.com.Select_Hotel_Page;

public class JUnit_Annotations extends Reusable_Methods {
	
	public static WebDriver driver = browser_Launch("Chrome");

	static Login_page login = new Login_page(driver);
	static Search_Hotel_Page Hotelpage = new Search_Hotel_Page(driver);
	static Select_Hotel_Page Select = new Select_Hotel_Page(driver);
	static Booking_Hotel_Page Book = new Booking_Hotel_Page(driver);
	static Booked_Itinerary_Page booked = new Booked_Itinerary_Page(driver);
	static Logout_Page logout = new Logout_Page(driver);
	
	
	@BeforeClass
	public static void browser_Launch() {

		get_Url(driver, "https://adactinhotelapp.com/");

		window_Manage("maximize");
	}
	
	@AfterClass
	public static void browser_Closed() {

		driver.quit();
	}
	
	@Before
	public void login_Page() throws InterruptedException, IOException {
		send_Values(login.getUserLP(), "JavedMo7");

		send_Values(login.getPassLP(), "JAVED987654!");

		Thread.sleep(4000);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Screenshot\\.loginpage.png");
		current_Title();

		click(login.getLogin_btnLP());
		
	}
	
	@After
	public void log_Out() {

		WebElement logout = driver.findElement(By.xpath("//a[.='Logout']"));
		logout.click();
	}
	
	
	@Test
	public void search_Hotel() throws InterruptedException, IOException {

		dropdown_Values(Hotelpage.getLocation(), "London");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Hervey");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "07/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "09/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());

	}
	
	
	
	
	
	
	
	
	

}
