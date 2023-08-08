package com.Ebank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EbankEdUtiles 
{	static FileInputStream file;
	static XSSFWorkbook workbook ;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static DataFormatter formatter =new DataFormatter();
	public static int getRowCount(String excelpath,String sheetName) throws IOException 
	{
		file =new FileInputStream(excelpath);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		file.close();
		workbook.close();
		return rowcount;
	}
	public static int getColCount(String excelpath,String sheetName,int rowC) throws IOException 
	{
		file = new FileInputStream(excelpath);
		workbook =new XSSFWorkbook(file);
		sheet= workbook.getSheet(sheetName);
		row=sheet.getRow(rowC);
		int cellCount=row.getLastCellNum();
		workbook.close();
		file.close();
		return cellCount;	
	}
	public static Object getCelldata(String excelpath,String sheetName,int rowC,int cellCount) throws IOException
	{
		Object dataValue;
		file = new FileInputStream(excelpath);
		workbook =new XSSFWorkbook(file);
		sheet= workbook.getSheet(sheetName);
		row=sheet.getRow(rowC);
		cell= row.getCell(cellCount);
		dataValue =formatter.formatCellValue(cell);
		
		return dataValue;
	}

}


