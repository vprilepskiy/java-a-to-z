package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test for Point.
 * @author vprilepskiy
 * @since 26.11.2016
 * @version 1
 */
 public class PointTest {
	/**
	 * Test add.
	 */
	@Test
	public void test1() {
		final double firstCoordinateX = 2, firstCoordinateY = 1;
		final double secondCoordinateX = 1, secondCoordinateY = 8;
		final double result = 7.071;
		final double delta = 0.001;
		final double resultMethod = new Point(firstCoordinateX, firstCoordinateY).distanceTo(new Point(secondCoordinateX, secondCoordinateY));
		assertThat(result, is(closeTo(resultMethod, delta)));
	}

	/**
	 * Test add.
	 */
	@Test
	public void test2() {
		final double firstCoordinateX = 2, firstCoordinateY = 1;
		final double secondCoordinateX = 5, secondCoordinateY = 7;
		final double result = 6.708;
		final double delta = 0.001;
		final double resultMethod = new Point(firstCoordinateX, firstCoordinateY).distanceTo(new Point(secondCoordinateX, secondCoordinateY));
		assertThat(result, is(closeTo(resultMethod, delta)));
	}

	/**
	 * Test add.
	 */
	@Test
	public void test3() {
		final double firstCoordinateX = 5, firstCoordinateY = 7;
		final double secondCoordinateX = 1, secondCoordinateY = 8;
		final double result = 4.123;
		final double delta = 0.001;
		final double resultMethod = new Point(firstCoordinateX, firstCoordinateY).distanceTo(new Point(secondCoordinateX, secondCoordinateY));
		assertThat(result, is(closeTo(resultMethod, delta)));
	}
 }