package ru.job4j.figures;

import ru.job4j.actions.Cell;
import ru.job4j.exceptions.ImpossibleMoveException;

/**
 * Фигура.
 */
public abstract class Figure {

    /**
     * Возвращает название фигуры.
     * @return - название фигуры.
     */
    public abstract String getName();

    /**
     * Ячейка в кторой находится данная фигура.
     */
    private Cell position;

    /**
     * Получить чейку в кторой находится данная фигура.
     * @return - ячейка.
     */
    public Cell getPosition() {
        return position;
    }

    /**
     * Конструктор.
     * @param position - ячейка.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Показывает пройденный путь.
     * @param dist - задают ячейку куда следует пойти.
     * @return - массив ячеек, которые должна пройти фигура.
     * @throws ImpossibleMoveException - Если фигура туда пойти не может.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Меняет место фигуры.
     * @param dist - новая координата фигуры.
     */
    public void clone(Cell dist) {
        this.position = dist;
    }


}
