package com.jayram.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	private MathUtils mathUtils;
	
	@BeforeAll
	void beforeAllInit() { //We can remove static keyword because we are changing default TestInstance behavior
		System.out.println("This needs to run before all");
	}
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up.....");
	}
	
	@Test
	void testAdd() {
		int expected = 4;
		int actual = mathUtils.add(2, 2);
		assertEquals(expected, actual);
	}

	@Test
	void testComputeCircleRadius() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area"); //In case of failure we can see message
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
	}
}
