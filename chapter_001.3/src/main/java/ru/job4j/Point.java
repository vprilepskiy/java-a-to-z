package ru.job4j;

/**
 * Вычислить расстояние между координатами x и y.
 * @author vprilepskiy
 * @since 26.11.2016
 * @version 1
 */
public class Point {
	/**
	 * координата горизонтали.
	 */
	private double x;
	/**
	 * координата вертикали.
	 */
	private double y;
	/**
	 * Конструктор.
	 * @param x - координата горизонтали.
	 * @param y - координата вертикали.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Метод вычисляет расстояние между двумя точками.
	 * @param point - точка до которой вычислить расстояние.
	 * @return - длина между точками.
	 */
	public double distanceTo(Point point) {
		double x = point.x;
		double y = point.y;
		double firstSideLength = Math.abs(this.x - x);
		double secondSideLength = Math.abs(this.y - y);
		double distanceBetweenPoints = Math.sqrt(Math.pow(firstSideLength, 2) + Math.pow(secondSideLength, 2));
		return distanceBetweenPoints;
	}
}