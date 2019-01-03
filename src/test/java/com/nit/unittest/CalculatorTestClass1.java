package com.nit.unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nit.beans.CalculatorOperations;

import junit.framework.Assert;

public class CalculatorTestClass1 {

	private static CalculatorOperations co=null;
	
	@BeforeClass
	public static void beforeClass(){

     System.out.println("CalculatorTestClass.beforeClass()");
		co=new CalculatorOperations();
	}
	
	/*@Before
	public void before(){
		System.out.println("CalculatorTestClass.before()");
	}*/
	
	/*@After
	public void after(){
		System.out.println("CalculatorTestClass.after()");
	}*/
	
	
	@Test
	public void addTest(){
	    System.out.println("CalculatorTestClass.addTest()");
		/*CalculatorOperations co=null;
		co=new CalculatorOperations();*/
		int actual=co.add(10, 10);
		Assert.assertEquals(20, actual);
	}
	
	@Test
	public void subTest(){
		System.out.println("CalculatorTestClass.subTest()");
		/*CalculatorOperations co=null;
		co=new CalculatorOperations();*/
		int actual=co.sub(45, 4);
		Assert.assertEquals(41, actual);
	}
	
	
	@AfterClass
	public static void afterClass(){
		System.out.println("CalculatorTestClass.afterClass()");
		co=null;
	}
}
