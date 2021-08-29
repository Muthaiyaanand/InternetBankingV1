package com.internetbanking.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

			static String projectpath;
			static XSSFWorkbook workbook;
			static XSSFSheet sheet;
			
			public XLUtils(String excelPath,String sheetName ){
				try {
				
				workbook = new XSSFWorkbook(excelPath);
				sheet = workbook.getSheet(sheetName);
				}catch (IOException e) {
					e.getCause();
					e.getMessage();
					e.printStackTrace();
				}
				
			}
			
			public static int getRowCount() {
				int rowcount = 0;
				try {
				rowcount = sheet.getPhysicalNumberOfRows();
				System.out.println("No of Row is "+ rowcount);
				} catch (Exception e) {
					e.getCause();
					e.getMessage();
					e.printStackTrace();
				}
				return rowcount;
			}
			
			public static int getColumnCount() {
				int columncount = 0;
				try {
				columncount = sheet.getRow(0).getPhysicalNumberOfCells();
				System.out.println("No of Column is "+ columncount);
				} catch (Exception e) {
					e.getCause();
					e.getMessage();
					e.printStackTrace();
				}
				return columncount;
			}
				public static String getCellDataString(int rowNum, int columnNum) {
					String CellData = null;
					try {
					CellData = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
					System.out.println("Cell Value is "+ CellData);
					} catch (Exception e) {
						e.getCause();
						e.getMessage();
						e.printStackTrace();
					}
					return CellData;
				}
				
				public static void getCellDataNumeric(int rowNum, int columnNum) {
					
					try {
					double CellDataString = sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
					System.out.println("Cell Value is"+ CellDataString);
					} catch (Exception e) {
						e.getCause();
						e.getMessage();
						e.printStackTrace();
					}
				}
			}



