package com.TestNG;

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
import org.testng.annotations.Test;

import com.BaseClass.com.Reusable_Methods;
import com.POM.com.Booked_Itinerary_Page;
import com.POM.com.Booking_Hotel_Page;
import com.POM.com.Login_page;
import com.POM.com.Logout_Page;
import com.POM.com.Search_Hotel_Page;
import com.POM.com.Select_Hotel_Page;

public class Simple_Anotations extends Reusable_Methods {
	
	public static WebDriver driver = browser_Launch("Chrome");

	static Login_page login = new Login_page(driver);
	static Search_Hotel_Page Hotelpage = new Search_Hotel_Page(driver);
	static Select_Hotel_Page Select = new Select_Hotel_Page(driver);
	static Booking_Hotel_Page Book = new Booking_Hotel_Page(driver);
	static Booked_Itinerary_Page booked = new Booked_Itinerary_Page(driver);
	static Logout_Page logout = new Logout_Page(driver);

		
		@BeforeClass
		public static void maximize() {

			window_Manage("maximize");
			System.out.println("URL launched");
	}
		@AfterClass
		public static void quit_Browser() {

			window_Manage("Minimize");
		}
		
		@BeforeTest
		private void browser_Launch() {

			get_Url(driver, "https://adactinhotelapp.com/");
		}
		
		@AfterTest
		private void browser_Closed() {

			driver.close();
		}
		@BeforeSuite
		private void session_Start() {
			 System.out.println("Ready to create source code");
		}
		@AfterSuite
		private void session_End() {
			System.out.println("code done");
			
		}
		
		@BeforeMethod
		private void log_In() {

			send_Values(login.getUserLP(), "JavedMo7");

			send_Values(login.getPassLP(), "JAVED987654!");
			
			click(login.getLogin_btnLP());

		}
		
		@AfterMethod
		private void log_out() {

			WebElement logoutBtn = driver.findElement(By.xpath("//a[.='Logout']"));
			click(logoutBtn);
		}
		
		@Test(priority = -3)
		private void search_Hotel() {

			dropdown_Values(Hotelpage.getLocation(), "London");

			dropdown_Values(Hotelpage.getHotel(), "Hotel Hervey");

			dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

			dropdown_Values(Hotelpage.getNOofRooms(), "2");

			clear(Hotelpage.getPickIndate());
			send_Values(Hotelpage.getPickIndate(), "30/11/2022");
			clear(Hotelpage.getPickoutDate());
			send_Values(Hotelpage.getPickoutDate(), "02/12/2022");

			dropdown_Values(Hotelpage.getChildren(), "2");

			current_Title();
			click(Hotelpage.getSubmit_btn());
		}
		
		
		

}
