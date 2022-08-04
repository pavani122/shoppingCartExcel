package com.techouts.shoppingMaven;

import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ShoppingCartData {
	static XSSFWorkbook workbook;	static XSSFSheet sheet;	DataFormatter formatter;
	static String excelPath=".\\Data\\shoppingSite.xlsx",sheetName="Sheet1";
	static int rowCount,products,productPrice,count,price,quantity,temp,reaminingCount;
	String s;

	static List<Integer> list=new ArrayList<Integer>();

	Scanner sc=new Scanner(System.in);
	ShoppingCartData() throws IOException
	{
		workbook=new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetName);
		formatter=new DataFormatter();
	}
	public  void getRowCount() 
	{

		rowCount=sheet.getLastRowNum();
	}


	public  void getCellData()
	{

		for(int rowNum=1;rowNum<=rowCount;rowNum++) 
		{
			Object value=formatter.formatCellValue(sheet.getRow(rowNum).getCell(0));
			System.out.println(value);
		}
	} 
	public int productCalcul(String name,int productCode)
	{

		for(int rowNum=1;rowNum<=rowCount;rowNum++) 
		{
			products=(int) sheet.getRow(rowNum).getCell(0).getNumericCellValue();
			String productName = (String) sheet.getRow(rowNum).getCell(1).getStringCellValue();
			if(productCode==products) 
			{

				quantity=(int) sheet.getRow(rowNum).getCell(2).getNumericCellValue();
				System.out.println("Total quantity in "+productCode+": "+quantity);
				if(quantity!=0)
				{
					productPrice=(int) sheet.getRow(rowNum).getCell(3).getNumericCellValue();
					System.out.println("Price for each one is: Rs."+productPrice+"/-");
					System.out.println("enter the quantity you want to buy in "+productCode);
					count=sc.nextInt();
					if(count<=quantity) {
						price=count*productPrice;
						System.out.println("Cost for "+count+ " is: Rs."+price+"/-");
						ShoppingCartData.productRemove(productCode, count);
						return price;	
					}
					if(count>quantity) 

					{
						System.out.println("please enter the quantity based on the availability");
						break;
					}
				}
				if(quantity==0)
				{
					System.out.println("Sorry there is nothing in product "+productCode);
					break;
				} 
			}	    

		}
		if(productCode!=products)
		{
			
			System.out.println("not available");
		}			


		return price;
	}

	public static  void productRemove(int productCode, int count)
	{
		temp=quantity-count;
		for(int rowNum=1;rowNum<=rowCount;rowNum++)
		{
			products=(int) sheet.getRow(rowNum).getCell(0).getNumericCellValue();
			if(productCode==products) 
			{
				sheet.getRow(rowNum).getCell(2).setCellValue(temp);
			}
		}
		list.add(productCode);

	}
	public static List addElementsToList()
	{
		
		list.add(quantity);
		list.add(productPrice);
		list.add(count);
		list.add(price);
		
		 ArrayList<Integer> mainList = new ArrayList<Integer>(list);
		 return mainList;
	}


}
