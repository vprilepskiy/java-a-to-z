package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
	public void whenAddTwoArgumentsThenSumm() {
		Calculator calc = new Calculator();
		final double first = 5;
		final double second = 10;
		final double result = 15;
		final double delta = 0.00;
		calc.add(first, second);
		assertEquals(result, calc.getResult(), delta);
	}
		/**
	 * Test subtract.
	 */
	@Test
	public void whenAddTwoArgumentsThenSubstract() {
		Calculator calc = new Calculator();
		final double first = 5;
		final double second = 10;
		final double result = -5;
		final double delta = 0.00;
		calc.subtract(first, second);
		assertEquals(result, calc.getResult(), delta);
	}
		/**
	 * Test multiple.
	 */
	@Test
	public void whenAddTwoArgumentsThenMultiple() {
		Calculator calc = new Calculator();
		final double first = 5;
		final double second = 10;
		final double result = 50;
		final double delta = 0.00;
		calc.multiple(first, second);
		assertEquals(result, calc.getResult(), delta);
	}
		/**
	 * Test div.
	 */
	@Test
	public void whenAddTwoArgumentsThenDiv() {
		Calculator calc = new Calculator();
		final double first = 5;
		final double second = 10;
		final double result = 0.50;
		final double delta = 0.00;
		calc.div(first, second);
		assertEquals(result, calc.getResult(), delta);
	}
 }