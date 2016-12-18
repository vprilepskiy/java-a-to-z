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
 public class GraphicsTest {
	/**
	 * Test.
	 */
	@Test
	public void whenAddArgumentsThenLine() {
		Graphics graphics = new Graphics();
		final int h = 5;
		assertThat(graphics.piramidLine(h), is("^       ^"));
	}

	/**
	 * Test.
	 */
	@Test
	public void whenAddArgumentsThenTriangle() {
		Graphics graphics = new Graphics();
		final int h = 5;
		assertThat(graphics.piramid(h), is("    ^\n   ^ ^\n  ^   ^\n ^     ^\n^       ^\n"));
	}
 }