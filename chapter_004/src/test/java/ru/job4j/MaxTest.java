package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test.
 * @author vprilepskiy
 * @since 27.11.2016
 * @version 1
 */
 public class MaxTest {
	/**
	 * Test.
	 */
	@Test
	public void whenAddTwoArgumentsThenMaximum() {
		Max max = new Max();
		final int first = 5;
		final int second = 10;
		final double result = 10;
		assertEquals(result, max.max(first, second));
	}

	/**
	 * Test.
	 */
	@Test
	public void whenAddThirdArgumentsThenMaximum() {
		Max max = new Max();
		final int first = 5;
		final int second = 10;
		final int third = 7;
		final double result = 10;
		assertEquals(result, max.max(first, second, third));
	}
 }