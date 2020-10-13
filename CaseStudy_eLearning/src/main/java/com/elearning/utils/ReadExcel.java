package com.elearning.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  


public class ReadExcel {

	public static void main(String[] args) throws IOException {

		
	    {  
	    try  
	    {  
		File file = new File("C:\\Users\\SatishWadde\\Desktop\\SDET\\DataCucu.xlsx");
    	FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
	    //creating Workbook instance that refers to .xlsx file  
	    XSSFWorkbook wb = new XSSFWorkbook(fis);   
	    XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
	    Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
	    while (itr.hasNext()){
		    Row row = itr.next();  
		    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
		    while (cellIterator.hasNext()){  
			    Cell cell = cellIterator.next();  
			    System.out.print(cell);
			    System.out.print("  |   ");
//			    System.out.print(cell.getStringCellValue()+ "\t\t");  
		    }  
		    System.out.println("\t");  

		    //		    System.out.println("");  
	    }  
	    }catch(Exception e){  
	    	e.printStackTrace();  
	    }  
	    }  
	    }  		
}

