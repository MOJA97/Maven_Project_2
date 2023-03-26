package com.RunnerClassPOM.com;

import java.io.IOException;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseClass.com.Reusable_Methods;
import com.POM.com.Booked_Itinerary_Page;
import com.POM.com.Booking_Hotel_Page;
import com.POM.com.Login_page;
import com.POM.com.Logout_Page;
import com.POM.com.Search_Hotel_Page;
import com.POM.com.Select_Hotel_Page;

public class POM_RunnerClass extends Reusable_Methods {
	public static WebDriver driver = browser_Launch("Chrome");

	static Login_page login = new Login_page(driver);
	static Search_Hotel_Page Hotelpage = new Search_Hotel_Page(driver);
	static Select_Hotel_Page Select = new Select_Hotel_Page(driver);
	static Booking_Hotel_Page Book = new Booking_Hotel_Page(driver);
	static Booked_Itinerary_Page booked = new Booked_Itinerary_Page(driver);
	static Logout_Page logout = new Logout_Page(driver);

	public static void main(String[] args) throws InterruptedException, IOException {

		get_Url(driver, "https://adactinhotelapp.com/");

		window_Manage("maximize");

		send_Values(login.getUserLP(), "JavedMo7");

		send_Values(login.getPassLP(), "JAVED987654!");

		Thread.sleep(4000);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Screenshot\\.loginpage.png");
		current_Title();

		click(login.getLogin_btnLP());

		dropdown_Values(Hotelpage.getLocation(), "London");

		dropdown_Values(Hotelpage.getHotel(), "Hotel Hervey");

		dropdown_Values(Hotelpage.getRoomtype(), "Super Deluxe");

		dropdown_Values(Hotelpage.getNOofRooms(), "2");

		clear(Hotelpage.getPickIndate());
		send_Values(Hotelpage.getPickIndate(), "30/11/2022");
		clear(Hotelpage.getPickoutDate());
		send_Values(Hotelpage.getPickoutDate(), "02/12/2022");

		dropdown_Values(Hotelpage.getChildren(), "2");

		Thread.sleep(3000);
		current_Title();
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Screenshot\\hotelpage.png");
		click(Hotelpage.getSubmit_btn());

		
		click(Select.getRadiobutton());
		Thread.sleep(2000);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Screenshot//selectHotel.png");
		current_Title();

		click(Select.getContinuebutton());

		send_Values(Book.getFirstname(), "Mohammed");

		send_Values(Book.getLastname(), "javed");

		send_Values(Book.getAddress(), "NO 6 Vivenkandar Theru, Dubai kuruku sandhu, dubai main road dubai");

		send_Values(Book.getCreditcardNo(), "6938452762539876");

		dropdown_Text(Book.getCCtype(), "VISA");

		dropdown_Values(Book.getCcExpiredate(), "12");

		dropdown_Text(Book.getCCexpireyear(), "2022");

		send_Values(Book.getCvv(), "978");

		Thread.sleep(3000);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Screenshot\\bookpage.png");
		current_Title();

		click(Book.getBooknowBTN());

		click(Book.getBookingitenary());

		click(booked.getRadiobutton());

		Thread.sleep(3000);
		current_Title();

		click(booked.getCancelbooking());

		driver.switchTo().alert().accept();

		current_Title();

		click(logout.getLogout());
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Screenshot\\logout.png");

	}

}
