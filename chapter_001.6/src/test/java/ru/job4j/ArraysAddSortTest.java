package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author vprilepskiy
 * @since 05.12.2016
 * @version 1
 */
 public class ArraysAddSortTest {
	/**
	 * Test.
	 */
	@Test
	public void testMethodAdd() {
		final int[] arr0 = {1, 3, 8, 12, 14, 15};
		final int[] arr1 = {1, 2, 4, 6, 8, 11, 15, 18};
		final int[] result = {1, 1, 2, 3, 4, 6, 8, 8, 11, 12, 14, 15, 15, 18};
		assertThat(new ArraysAddSort().add(arr0, arr1), is(result));
	}
 }