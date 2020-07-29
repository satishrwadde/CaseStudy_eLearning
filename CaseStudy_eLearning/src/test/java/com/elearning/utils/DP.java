package com.elearning.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class DP
{

	@DataProvider (name = "dataprovider")
	 public Object[][] dpMethod(){
//		 String str1[]= {"2","4","6","8","10"};
	//	 String str2[]= {"1","3","5","7","9"};
		List<Integer> l1=new ArrayList<Integer>();  
		List<Integer> l2=new ArrayList<Integer>();  
		l1.add(1);	    l2.add(12);
		l1.add(3);		l2.add(14);	
		l1.add(5);	    l2.add(16);
		l1.add(7);		l2.add(18);
		l1.add(9);		l2.add(20);
		

	 return new Object[][] {{l1}, {l2}};
	 }
 
    @Test (dataProvider = "dataprovider")
    public void myTestMethod (List <Integer> val) {
    	
    	for (int i = 0; i < val.size(); i++) {
            System.out.println("Passed Parameter Is : " + val.get(i));
           }
    }
}