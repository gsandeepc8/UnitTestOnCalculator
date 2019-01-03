package com.nit.unittest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) throws IOException {
		Result result=null;
		
		result=JUnitCore.runClasses(TestSuiteClass.class);
        /*//display all failure cases
		for(Failure f:result.getFailures()){
			System.out.println("Failure : "+f);
		}
		System.out.println("Get FailureCount : "+result.getFailureCount());
		System.out.println("Get Ignore Count : "+result.getIgnoreCount());
		System.out.println("Get Run Count : "+result.getRunCount());
		System.out.println("Get Run Time : "+result.getRunTime());
		System.out.println("Was Successful : "+result.wasSuccessful());
		System.out.println( result.getFailures().size());
		System.out.println("Failure.toString : "+result.getFailures().toString());
//---------------------------------------------------------------------------------
		*/
		FileOutputStream fos=null;
		Workbook workbook=null;
		Sheet sheet1=null,sheet2=null;
		Row row11=null,row12=null,row13=null;
		Row row1=null,row22=null;
		SimpleDateFormat sdf=null;
		
		int i=0,j=0;
		
		fos=new FileOutputStream("xl\\calcitestreport.xls");
        workbook=new HSSFWorkbook();
        sheet1=workbook.createSheet("reportpage");
        //create row 
        row11=sheet1.createRow(0);
        row11.createCell(0).setCellValue("Date");
        row11.createCell(1).setCellValue("TotalTestCases");
        row11.createCell(2).setCellValue("Success");
        row11.createCell(3).setCellValue("Failure");
        row11.createCell(4).setCellValue("Ignore");
        
        //create next row
        row12=sheet1.createRow(1);
        row12.createCell(0).setCellValue(new Date().toString());
        row12.createCell(1).setCellValue(result.getRunCount());
        row12.createCell(2).setCellValue(result.wasSuccessful());
        row12.createCell(3).setCellValue(result.getFailureCount());
        row12.createCell(4).setCellValue(result.getIgnoreCount());
        
        
        
      /*//create next row
        row13=sheet1.createRow(2);
        
        Date date1=new Date();
        date1.setDate(03);
        date1.setMonth(00);
        date1.setYear(2019);
        
        row13.createCell(0).setCellValue(date1.toString());
        row13.createCell(1).setCellValue(4);
        row13.createCell(2).setCellValue(4);
        row13.createCell(3).setCellValue(0);
        row13.createCell(4).setCellValue(0);
      */  
        
        //creating another sheet
        sheet2=workbook.createSheet("faiurereason");
        
        
        
    	row1 = sheet2.createRow(i++);
		row1.createCell(j++).setCellValue("Failure Reason : ");
		
		
		for (Failure fail : result.getFailures()) {
			row1.createCell(j++).setCellValue(fail.getMessage());
		}
	   
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("Report generated in XL sheet...");


	}

}
