package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook workBook;
	private static Sheet sheet;
		
	/**
	 * This method opens up an excel sheet
	 * @param filePath
	 * @param sheetName
	 * @throws IOException
	 */
	public static void openExcel(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
	}
	
	
	/**
	 * This method returns total number of rows in an excel sheet
	 * @return
	 */
	public static int countRows() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	/**
	 * This method returns total number of columns in an excel sheet
	 * @return
	 */
	public static int countColumns() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	
	/**
	 * This method returns data in a cell of an excel sheet 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public static String getCellData(int rowIndex, int columnIndex) {
		return sheet.getRow(rowIndex).getCell(columnIndex).toString();
	}
	
	
	/**
	 * This method will read any Excel file and return data in 2D array
	 * @param filePath file path of the excel sheet
	 * @param sheetName the name of the excel sheet 
	 * @return
	 * @throws IOException 
	 */
	public static Object[][] excelIntoArray(String filePath, String sheetName) throws IOException{
		openExcel(filePath, sheetName);
		
		//determining 2D array size
		Object[][] data = new Object[countRows()-1][countColumns()];
		
		//storing excel sheet into 2D array
		for(int i=1; i<countRows(); i++) {
			for(int y=0; y<countColumns(); y++) {
				data[i-1][y]=getCellData(i,y);
			}
		}
		return data;
	}
	
		
	
}
