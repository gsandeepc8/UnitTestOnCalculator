package com.nit.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestCaseReportToXL {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos=null;
		Workbook workbook=null;
		Sheet sheet1=null,sheet2=null;
		Row row11=null,row12=null,row13=null;
		Row row21=null,row22=null;
		SimpleDateFormat sdf=null;
		
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
        row12.createCell(1).setCellValue(4);
        row12.createCell(2).setCellValue(3);
        row12.createCell(3).setCellValue(1);
        row12.createCell(4).setCellValue(0);
        
        
        
      //create next row
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
        
        
        //creating another sheet
        sheet2=workbook.createSheet("faiurereason");
        row21=sheet2.createRow(0);
        row21.createCell(0).setCellValue("TestCaseNo");
        row21.createCell(1).setCellValue("FailureReason");
        
        //creating another row
        row22=sheet2.createRow(1);
        row22.createCell(0).setCellValue("TestCase3");
        row22.createCell(1).setCellValue("junit.framework.AssertionFailedError: expected:<40> but was:<50>");
        
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("Report generated in XL sheet...");
	}

}
