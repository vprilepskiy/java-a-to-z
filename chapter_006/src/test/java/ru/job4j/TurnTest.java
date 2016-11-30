package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author vprilepskiy
 * @since 30.11.2016
 * @version 1
 */
 public class TurnTest {
	/**
	 * Test.
	 */
	@Test
	public void testMethodBack() {
		final int[] array = {1, 2, 3, 4, 5};
		new Turn(array).back();
		final int[] result = {5, 4, 3, 2, 1};
		assertThat(array, is(result));
	}

	/**
	 * Test.
	 */
	@Test
	public void testMethodBubbleSort() {
		final int[] array = {1, 3, 5, 4, 2};
		new Turn(array).bubbleSort();
		final int[] result = {1, 2, 3, 4, 5};
		assertThat(array, is(result));
	}
 }