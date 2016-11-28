package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author vprilepskiy
 * @since 28.11.2016
 * @version 1
 */
 public class CounterTest {
	/**
	 * Test.
	 */
	@Test
	public void whenAddTwoArgumentsThenSumm() {
		Counter counter = new Counter();
		final int start = 5;
		final int finish = 10;
		final int result = 24;
		assertThat(counter.add(start, finish), is(result));
	}

	/**
	 * Test.
	 */
	@Test
	public void whenAddThirdArgumentsThenFactorial() {
		Counter counter = new Counter();
		final int value = 5;
		final int result = 120;
		assertThat(counter.factorial(value), is(result));
	}
 }