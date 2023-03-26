package com.DATAP.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class All_Data {
	
	static String value;
	
	public static String main(String[] args) throws IOException {
		
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
				
				value = cell.getStringCellValue();
				
			}
			else if (ct.equals(CellType.NUMERIC)) {
				
				double d = cell.getNumericCellValue();
				
				int c = (int) d;
				
				value = String.valueOf(c);

			}
			
		}
		}
	
		return value;
	
	
	
	
		
		
	}

}
