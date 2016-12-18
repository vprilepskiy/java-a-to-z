package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author vprilepskiy
 * @since 04.12.2016
 * @version 1
 */
 public class IsSubstringOfTest {
	/**
	 * Test.
	 */
	@Test
	public void testContains() {
		final String origin = "строка";
		final String sub = "ка";
		final boolean result = true;
		assertThat(new IsSubstringOf().contains(origin, sub), is(result));
	}

	/**
	 * Test.
	 */
	@Test
	public void testContains2() {
		final String origin = "строка";
		final String sub = "вася";
		final boolean result = false;
		assertThat(new IsSubstringOf().contains(origin, sub), is(result));
	}
 }