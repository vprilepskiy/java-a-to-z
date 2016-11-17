package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * 
 * @auhtor vprilepskiy
 * @since 15.11.2016
 * @version 1
 */
 public class CalculateTest {
 
	/**
	 * Test add.
	 */
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream(); // для записи в него вывода с консоли
		System.setOut(new PrintStream(out)); // заменяем системный поток вывода
		Calculate.main(null); // вызов метода main
		assertThat(out.toString(), is("Hello World\r\n")); // делаем заключительную проверку результата вывода и ожидаемых данных.
	}
 }