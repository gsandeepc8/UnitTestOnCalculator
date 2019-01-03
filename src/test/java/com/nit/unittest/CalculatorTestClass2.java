package com.nit.unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nit.beans.CalculatorOperations;

import junit.framework.Assert;

public class CalculatorTestClass2 {

	private static CalculatorOperations co=null;
	
	@BeforeClass
	public static void beforeClass(){

     System.out.println("CalculatorTestClass.beforeClass()");
		co=new CalculatorOperations();
	}
	
	@Before
	public void before(){
		System.out.println("CalculatorTestClass.before()");
	}
	
	@After
	public void after(){
		System.out.println("CalculatorTestClass.after()");
	}
	
	
	
	@Test
	public void mulTest(){
		System.out.println("CalculatorTestClass.mulTest()");
		int actual=co.mul(10, 5);
		Assert.assertEquals(150, actual);
	}
	
	@Test
	public void divTest(){
		System.out.println("CalculatorTestClass.divTest()");
		int actual=co.div(50, 10);
		Assert.assertEquals(15, actual);
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("CalculatorTestClass.afterClass()");
		co=null;
	}
}
