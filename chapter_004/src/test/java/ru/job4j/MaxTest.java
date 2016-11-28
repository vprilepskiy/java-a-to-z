package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
		final int result = 10;
		//assertEquals(result, max.max(first, second));
		assertThat(max.max(first, second), is(result));
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
		final int result = 10;
		//assertEquals(result, max.max(first, second, third));
		assertThat(max.max(first, second, third), is(result));
	}
 }