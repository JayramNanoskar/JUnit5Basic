package com.jayram.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {

	private MathUtils mathUtils;
	private TestInfo testInfo;
	private TestReporter testReporter;
	
	@BeforeAll
	void beforeAllInit() { //We can remove static keyword because we are changing default TestInstance behavior
		System.out.println("This needs to run before all");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) { //Using Dependency Injection
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running "+ this.testInfo.getDisplayName()+ " with tags "+ this.testInfo.getTags());;
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up.....");
	}
	
	@Nested
	@DisplayName("add method")
	class AddTest {
		
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPositive() {
			assertEquals(4, mathUtils.add(2, 2), "should return the right sum");
		}
		
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			assertEquals(-4, mathUtils.add(-2, -2), () -> "should return the right sum");
		}
	}
	

	@RepeatedTest(2)
	@Tag("Circle")
	void testComputeCircleRadius() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area"); //In case of failure we can see message
	}
	
	@Test
	void testDivide() {
		boolean isServerUp = true;
		assumeTrue(isServerUp); //Gives more programmatically control to run tests
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method. Should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	@Test
	@DisplayName("multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-4, mathUtils.multiply(-2, 2))
				);
	}
}
