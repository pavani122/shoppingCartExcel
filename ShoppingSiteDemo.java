package com.techouts.shoppingMaven;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class ShoppingSiteDemo {

	static int totCount=0,Amount=0;
	static List list=new ArrayList<Integer>();
	static int size=0;


	public static void main(String[] args) throws Exception {
		String s="yes";
		String excelPath=".\\Data\\shoppingSite.xlsx";
		String sheetName="Sheet1";	
		ShoppingCartData obj=new ShoppingCartData();
		obj.getRowCount();		
		Scanner sc=new Scanner(System.in);
		WriteData dataObj=new WriteData();

		do	{
		System.out.println("Enter username:");
		String name=sc.next();
		do {
		System.out.println("Available Products ");
		obj.getCellData();
		System.out.println("Enter the productCode you want to buy");
		int productCode=sc.nextInt();
		totCount=obj.productCalcul(name,productCode);
        Amount=Amount+totCount;
        list=obj.addElementsToList();
        size=size+1;
        dataObj.index();
        dataObj.writingData(list,Amount,size);
        
		System.out.println("Do yo want to continue, enter yes or no: ");
		s=sc.next();
		   
		if(s.equalsIgnoreCase("no"))
		   {
			System.out.println("Name: "+name+"\nTotal Cost is: "+(Amount));
		
			totCount=0;		   
		   }
		
		
		}
		while(s.equalsIgnoreCase("yes"));
		
		System.out.println("user do you want to buy, enter yes or no: ");
		s=sc.next();
	}
		while(s.equalsIgnoreCase("yes"));
	}

}
