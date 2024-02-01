package com.xyz.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils  
{
	
	    private static Workbook workbook;
	    private static Sheet sheet;
	    private static Row row;
	    private static Cell cell;

	   public void setExcelFile(String excelFilePath,String sheetName) throws IOException {
	       //Create an object of File class to open xls file
	       File file =    new File(excelFilePath);
	       
	       //Create an object of FileInputStream class to read excel file
	       FileInputStream inputStream = new FileInputStream(file);
	       
	       //creating workbook instance that refers to .xls file
	       //workbook=new HSSFWorkbook(inputStream);
	       workbook = WorkbookFactory.create(inputStream);
	       
	       //creating a Sheet object
	       // sheet=workbook.getSheet(sheetName);
	        sheet = workbook.getSheet(sheetName);

	   }

	    public String getCellData(int rowNumber,int cellNumber){
	       //getting the cell value from rowNumber and cell Number
	    	
	    	 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale

	        cell =sheet.getRow(rowNumber).getCell(cellNumber);
	        
	        //returning the cell value as string
	        return formatter.formatCellValue(cell);
	    }

	    public int getRowCountInSheet(){
	       int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	       return rowcount;
	    }

	    public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
	    	//creating a new cell in row and setting value to it      
	    	sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
	        
	    	FileOutputStream outputStream = new FileOutputStream(excelFilePath);
	    	workbook.write(outputStream);
	    }

}
