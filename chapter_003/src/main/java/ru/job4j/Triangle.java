package ru.job4j;

/**
 * Вычислить площадь треугольника.
 * @author vprilepskiy
 * @since 26.11.2016
 * @version 1
 */
public class Triangle {

	/**
	 * точка a.
	 */
	private Point a;
	/**
	 * точка b.
	 */
	private Point b;
	/**
	 * точка c.
	 */
	private Point c;

	/**
	 * Конструктор.
	 * @param a - координата треугольника
	 * @param b - координата треугольника
	 * @param c - координата треугольника
	 */
	public Triangle(Point a, Point b, Point c) {
	this.a = a;
	this.b = b;
	this.c = c;
	}

	/**
	 * Вычисляет площадь треугольника.
	 * @return - площадь треугольника.
	 */
	public double area() {

		double area = 0;

		double lengthSideA = a.distanceTo(b);
		double lengthSideB = b.distanceTo(c);
		double lengthSideC = c.distanceTo(a);
		if (lengthSideA != 0  &  lengthSideB != 0  &  lengthSideC != 0) {
			double semiperimeter = (lengthSideA + lengthSideB + lengthSideC) / 2;
			area = Math.sqrt(semiperimeter * (semiperimeter - lengthSideA) * (semiperimeter - lengthSideB) * (semiperimeter - lengthSideC));
		}
		return area;
	}
}