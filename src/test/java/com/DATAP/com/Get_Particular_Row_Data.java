package com.DATAP.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Get_Particular_Row_Data {
	
	static String value;
	public static void main(String[] args) throws IOException {
		
	File f = new File("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Test Case Project-1(ADACTIN HOTEL RESERVATION).xlsx");
	
	FileInputStream fis = new FileInputStream(f);
	
	Workbook wb = new XSSFWorkbook(fis);
	
	Sheet s = wb.getSheetAt(0);
	
	s.getRowSumsBelow();
	
	Row row = s.getRow(7);
	
	int no_of_rows = s.getPhysicalNumberOfRows();
	System.out.println("Rows:"+ no_of_rows);
	
	for (int i = 0; i < no_of_rows; i++) {
		
		Cell cell = row.getCell(i);
		
		CellType ct = cell.getCellType();
		
		if (ct.equals(CellType.STRING)) {
			
			String Value = cell.getStringCellValue();
			System.out.println(Value);
		}
		
		else if (ct.equals(CellType.NUMERIC)) {
			
			double d = cell.getNumericCellValue();
			
			int c = (int) d;
			
			String value = String.valueOf(c);
			System.out.println(value);
			
		}
	}
	
	try {
	} catch (NullPointerException e) {
		e.printStackTrace();
		System.out.println("Null pointer exception handled");
	}
	
	
	
}
}