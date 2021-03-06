package com.example.calculator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleOperationsTest {

	private static SimpleCalculator calc;
	
	@BeforeClass
	public static void setup() {
		calc = new Ti84();
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void teardown() {
		System.out.println("After Class");
	}
	
	@Before
	public void thing() {
		System.out.println("Before");
	}
	
	@After
	public void otherThing() {
		System.out.println("After");
	}
	
	@Test
	public void testSimplePositiveAddition() {
		System.out.println("Test");
		int result = calc.add(4, 2);
		assertEquals(6, result);
	}
	
	@Test
	public void testSimplePositiveAdditionFloatingPoint() {
		System.out.println("Test");
		double result = calc.add(4.5, 2.3);
		assertEquals(6.8, result, 0.000001);
	}
	
	@Test(expected=IOException.class)
	public void testError() throws IOException {
		((Ti84) calc).errorProne();
	}
}
