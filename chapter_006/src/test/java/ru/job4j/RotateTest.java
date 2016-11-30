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
 public class RotateTest {
	/**
	 * Test.
	 */
	@Test
	public void testMethodRotate() {
		final int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		new Rotate(array).rollRight();
		final int[][] result = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
		assertThat(array, is(result));
	}
 }