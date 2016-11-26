package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test for Triangle.
 * @author vprilepskiy
 * @since 26.11.2016
 * @version 1
 */
 public class TriangleTest {
	/**
	 * Test add.
	 */
	@Test
	public void test() {
		final double firstCoordinateX = 2, firstCoordinateY = 1;
		final double secondCoordinateX = 5, secondCoordinateY = 7;
		final double thirdCoordinateX = 1, thirdCoordinateY = 8;
		final double result = 13.499;
		final double delta = 0.01;
		final double resultMethod = (new Triangle(new Point(firstCoordinateX, firstCoordinateY), new Point(secondCoordinateX, secondCoordinateY), new Point(thirdCoordinateX, thirdCoordinateY))).area();
		assertThat(result, is(closeTo(resultMethod, delta)));
	}
 }