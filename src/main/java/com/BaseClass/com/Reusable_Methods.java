package com.BaseClass.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import javax.naming.Name;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Reusable_Methods {

	public static WebDriver driver;
	public static String value;

	public static WebDriver browser_Launch(String browsername) {

		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;

	}

	public static void get_Url(WebDriver driver, String value) {

		driver.get(value);

	}

	public static void window_Manage(String size) {

		if (size.equalsIgnoreCase("maximize")) {
			driver.manage().window().maximize();
		} else if (size.equalsIgnoreCase("minimize")) {
			driver.manage().window().maximize();
		} else if (size.equalsIgnoreCase("Fullscreen")) {
			driver.manage().window().fullscreen();
		}
	}

	public static void popup_Prompt(WebElement element, String types) {

		if (types.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (types.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void right_Click(WebElement element) {

		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}

	public static void down_Enter() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void screenshot(WebDriver driver, String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);

	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void clear(WebElement element) {

		element.clear();
	}

	public static void implicitly_Wait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public static void current_Title() {

		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void dropdown_Index(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void dropdown_Values(WebElement element, String name) {

		Select s = new Select(element);
		s.selectByValue(name);
	}

	public static void dropdown_Text(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void send_Values(WebElement element, String Values) {

		element.sendKeys(Values);
	}

	public static void pageLoadout_TimeDuration() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));

	}

	public static void clickon_Element(WebElement element) {
		element.click();

	}

	public static void single_WindowHandling(WebElement element) {

		String registerpage = driver.getWindowHandle();
		System.out.println(registerpage);

		Set<String> all_ID = driver.getWindowHandles();
		System.out.println(all_ID);

		for (String register_ID : all_ID) {
			if (register_ID.equals(registerpage)) {
				continue;
			} else {
				driver.switchTo().window(register_ID);
			}

		}

	}

	public static String get_Particular_Data() throws IOException, InvalidFormatException {

		
		File f = new File("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Get particular data.xlsx");
		
		FileInputStream fRead = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(f);
		
		Sheet sheet = wb.getSheet("Data");
		
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		
		CellType cellType = cell.getCellType();
		
		if (cellType.equals(CellType.STRING)) {
			
			value = cell.getStringCellValue();
		}
		
		else if (cellType.equals(CellType.NUMERIC)) {
			
			double D = cell.getNumericCellValue();
			
		int j = (int)D;
		
		value = String.valueOf(j);
		
		
		
	}
		return value;
	
	}
	
	public static String get_Data() throws IOException {
		
		File f = new File("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Test Case Project-1(ADACTIN HOTEL RESERVATION).xlsx");
		
		FileInputStream fRead = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fRead);
		
		Sheet s = wb.getSheetAt(0);
		
		int No_of_Rows = s.getPhysicalNumberOfRows();
		
		System.out.println("Rows count:"+ No_of_Rows);
		
		for (int i = 0; i < No_of_Rows; i++) {
			
			Row row = s.getRow(i);
			//to count the cells
			int no_of_cells = row.getPhysicalNumberOfCells();
			System.out.println("cells count:"+ no_of_cells);
//Nested loop
		for (int j = 0; j < no_of_cells; j++) {
			Cell cell = row.getCell(j);
		//for cellType
			CellType ct = cell.getCellType();
			//STRING AND NUMERIC
			
			if (ct.equals(CellType.STRING)) {
				
				String Value = cell.getStringCellValue();
				System.out.print(":"+ Value);
				
			}
			else if (ct.equals(CellType.NUMERIC)) {
				
				double d = cell.getNumericCellValue();
				
				int c = (int) d;
				
				String valueOf = String.valueOf(c);
				System.out.print(":"+ valueOf);
				
			}
			
		}
		}
	
		return value;
	
	
	
	}
	public static String get_Data_excel(String path, int index, int row, int cell) throws InvalidFormatException, IOException {
		 
		File f = new File(path);
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(f);
		
		Sheet sheetAt = wb.getSheetAt(index);
		
		Row row2 = sheetAt.getRow(row);
		
		Cell cellname = row2.getCell(cell);
		
		CellType ct = cellname.getCellType();
		
		if (ct.equals(CellType.STRING)) {
			value = cellname.getStringCellValue();
		}
		else if (ct.equals(CellType.NUMERIC)) {
			
		double d = cellname.getNumericCellValue();

		int j = (int) d;
		
		value = String.valueOf(j);
		}	
		return value;
	}
	
	public static void browser_Close() {
		
		driver.close();

		
	}
	

	
	
	
	


}
