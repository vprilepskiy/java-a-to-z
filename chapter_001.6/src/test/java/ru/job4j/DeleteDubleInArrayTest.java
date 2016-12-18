package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author vprilepskiy
 * @since 01.12.2016
 * @version 1
 */
 public class DeleteDubleInArrayTest {
	/**
	 * Test.
	 */
	@Test
	public void testMethodUniqueElements() {
		final String[] array = {"Привет", "Привет", "Мир", "Мир"};
		final String[] result = {"Привет", "Мир"};
		assertThat(new DeleteDubleInArray(array).uniqueElements(), is(result));
	}
 }