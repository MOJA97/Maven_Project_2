package com.TestNG;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.BaseClass.com.Reusable_Methods;
import com.POM.com.Booked_Itinerary_Page;
import com.POM.com.Booking_Hotel_Page;
import com.POM.com.Login_page;
import com.POM.com.Logout_Page;
import com.POM.com.Search_Hotel_Page;
import com.POM.com.Select_Hotel_Page;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;


public class TestNG_Attributes extends Reusable_Methods {
	
	public static WebDriver driver = browser_Launch("Chrome");

	static Login_page login = new Login_page(driver);
	static Search_Hotel_Page Hotelpage = new Search_Hotel_Page(driver);
	static Select_Hotel_Page Select = new Select_Hotel_Page(driver);
	static Booking_Hotel_Page Book = new Booking_Hotel_Page(driver);
	static Booked_Itinerary_Page booked = new Booked_Itinerary_Page(driver);
	static Logout_Page logout = new Logout_Page(driver);
	
	
	@BeforeClass
	public static void window_Manage_Max() {
		
		window_Manage("Maximize");
		System.out.println("Browser maximize");
	}
	
	@AfterClass
	public static void window_Manage_Mini() {

		window_Manage("minimize");
		System.out.println("Browser minimized");
	}
	
	@BeforeTest
	private void browser_Launch() {

		get_Url(driver, "https://adactinhotelapp.com/");
		
	}
	
	@AfterTest
	private void close_Browser() {

		browser_Close();
	}
	
	@BeforeSuite
	private void session_initiated() {

		System.out.println("Source code started");
	}
	
	@AfterSuite
	private void session_Ended() {

		System.out.println("Coding ended");
	}
	
	@org.testng.annotations.Parameters ({ "username", "password"})
	@BeforeMethod
	private void log_In(String username, String password) {

		send_Values(login.getUserLP(), username);
		
		send_Values(login.getPassLP(), password);
		
		click(login.getLogin_btnLP());
	}
	
	@AfterMethod 
	private void log_Out() {
		
		WebElement radioBtn = driver.findElement(By.xpath("//input[@type='radio']"));
		radioBtn.click();
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[.='Logout']"));
		logout.click();
		
		WebElement loginAgain = driver.findElement(By.xpath("//a[text()='Click here to login again']"));
		loginAgain.click();
		
	}
	
	@Test (priority = -5)
	private void hotel_Hervey_London() {

		dropdown_Values(Hotelpage.getLocation(), "London");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Hervey");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "18/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "22/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
		
	}
	
	@Test (priority = -3)
	private void hotel_Creek() {

		dropdown_Values(Hotelpage.getLocation(), "Sydney");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Creek");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "15/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "17/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
	}
	
	@Test (priority = -4, enabled = false) 
	private void hotel_Sunshine() {

		dropdown_Values(Hotelpage.getLocation(), "Sydney");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Sunshine");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "17/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "19/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
		
	}
	
	@Test (priority = -1, groups = "Team Black")
	private void hotel_Cornice() {
		
		dropdown_Values(Hotelpage.getLocation(), "Sydney");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Cornice");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "17/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "19/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
		
	}
	
	@Test (priority = 3)
	private void paris() {
		
		dropdown_Values(Hotelpage.getLocation(), "Paris");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Sunshine");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "18/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "29/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());

		
	}
	
	@Test (priority = 2, groups = "Team Black")
	private void los_Angeles() {
		
		dropdown_Values(Hotelpage.getLocation(), "Paris");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Cornice");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "23/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "29/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());

		
	}
	
	@Test (priority = 1, timeOut = 40000)
	private void new_York() {

		dropdown_Values(Hotelpage.getLocation(), "Paris");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Sunshine");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "18/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "21/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
		
	}
	
	@Ignore	
	@Test (priority = 0)
	private void adelaide() {

		dropdown_Values(Hotelpage.getLocation(), "Adelaide");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Sunshine");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "18/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "29/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
		
	}
	
	@Test (priority = -2)
	private void brisbane() {
		
		dropdown_Values(Hotelpage.getLocation(), "Brisbane");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Creek");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "18/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "20/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());
		
	}
	
	@Test (priority = -1)
	private void melbourne() {
		
		dropdown_Values(Hotelpage.getLocation(), "Melbourne");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Sunshine");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "18/01/2023");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "25/01/2023");

		dropdown_Values(Hotelpage.getChildren(), "2");

		current_Title();
		click(Hotelpage.getSubmit_btn());


		
	}

	
	
	}
	
	


