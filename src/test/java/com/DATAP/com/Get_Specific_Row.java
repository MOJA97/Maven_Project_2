package com.DATAP.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_Specific_Row {
	
	
	public static void main(String[] args) throws  IOException {
		
		
		File f = new File("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Test Case Project-1(ADACTIN HOTEL RESERVATION).xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet s = wb.getSheetAt(0);
		
		String stringCellValue = s.getRow(7).getCell(1).getStringCellValue();
		
		System.out.println("Data:"+ stringCellValue);
		
	
		
		
		
	}

}
