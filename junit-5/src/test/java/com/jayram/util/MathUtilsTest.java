package com.jayram.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathUtils = new MathUtils();
		int expected = 4;
		int actual = mathUtils.add(2, 2);
		assertEquals(expected, actual);
	}

}
