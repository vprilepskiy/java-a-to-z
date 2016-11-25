package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.core.Is.is;

/**
 * Test for Calculatir.
 * @author vprilepskiy
 * @since 25.11.2016
 * @version 1
 */
 public class CalculatorTest {
	/**
	 * Test add.
	 */
	@Test
	public void whenAddOneToOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(5, 10);
		assertEquals(15, calc.getResult);
	}
 }