package com.techouts.shoppingMaven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	static String excelPath=".\\Data\\userDataShoppingSite.xlsx";
	String sheet="UserData";
	static XSSFWorkbook bookObj; 	
	static XSSFSheet sheetObj;static XSSFRow rowObj;static XSSFCell cellObj;
	static DataFormatter formatter;
	static int rowCount=0,colCount=0,size=0;

	WriteData() throws Exception
	{
		bookObj=new XSSFWorkbook();
		sheetObj=bookObj.createSheet(sheet);
		formatter=new DataFormatter();
		
	}
	
	public void index()
	{
		    rowObj=sheetObj.createRow(rowCount);
		    for(colCount=0;colCount<5;colCount++) {
			cellObj=rowObj.createCell(colCount);}
			sheetObj.getRow(rowCount).getCell(0).setCellValue("productCode");
			sheetObj.getRow(rowCount).getCell(1).setCellValue("Quantity");
			sheetObj.getRow(rowCount).getCell(2).setCellValue("Price");
			sheetObj.getRow(rowCount).getCell(3).setCellValue("UserNeed");
			sheetObj.getRow(rowCount).getCell(4).setCellValue("Cost");
	}
  
  public static void writingData(List list,int Amount,int size) throws Exception
  
  {  
	try {
		
	Iterator it=list.iterator();
	

	for( rowCount=1;rowCount<=size;rowCount++)
	{
		
		rowObj=sheetObj.createRow(rowCount);
		
	for( colCount=0;colCount<5;colCount++)	
	{
		cellObj=rowObj.createCell(colCount);
		
	while(it.hasNext())
	{
	  int value=(Integer) it.next();
	  

	  sheetObj.getRow(rowCount).getCell(colCount).setCellValue(value);
	  
	  break;
	  
	  
	}  
	}
	}
	size=size+1;
	rowObj=sheetObj.createRow(size);
	cellObj=rowObj.createCell(--colCount);
	sheetObj.getRow(size).getCell(colCount).setCellValue(Amount);
	FileOutputStream fos=new FileOutputStream(excelPath);
	bookObj.write(fos);
	fos.close();
	}
	catch(Exception e)
	{
       e.printStackTrace();		
	}
  }


	
	
}