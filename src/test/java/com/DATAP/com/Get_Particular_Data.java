package com.DATAP.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_Particular_Data {
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		File f = new File("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Get particular data.xlsx");
		
		FileInputStream fRead = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(f);
		
		Sheet sheet = wb.getSheet("Data");
		
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		
		CellType cellType = cell.getCellType();
		
		if (cellType.equals(CellType.STRING)) {
			
			String SCV = cell.getStringCellValue();
			System.out.println(SCV);
		}
		
		else if (cellType.equals(CellType.NUMERIC)) {
			
			double D = cell.getNumericCellValue();
			
		int j = (int)D;
		
		String Value = String.valueOf(j);
		System.out.println(Value);
			
		}		
		
		
		
		
	}

}
