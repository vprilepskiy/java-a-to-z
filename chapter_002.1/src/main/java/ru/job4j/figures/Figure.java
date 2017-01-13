package ru.job4j.figures;

import ru.job4j.actions.Cell;
import ru.job4j.exceptions.ImpossibleMoveException;

/**
 * Фигура.
 */
public abstract class Figure {

    /**
     * Минимальный индекс поля.
     */
    private final byte minIndex = 0;

    /**
     * Максимальный индекс поля.
     */
    private final byte maxIndex = 7;

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
     *
     * @param dist - задают ячейку куда следует пойти.
     * @return - массив ячеек, которые должна пройти фигура.
     * @throws ImpossibleMoveException - Если фигура туда пойти не может.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Проверяет есть ли такое направление хода.
     * @param directions - направления. Массив из двух цифр. Первая это направление по горизонтали. Вторая это направление по вертикали. Направленй может быть несколько, по этому массив двумерный.
     * @param dist - ячейка на которую следует сходить.
     * @return - true если направление хода верное.
     */
    public boolean validateDirect(int[][] directions, Cell dist) {
        boolean have = false;
        for (int[] direction : directions) {
            have = (direction[0] == getDirection(dist)[0]) && (direction[1] == getDirection(dist)[1]);
            if (have) {
                break;
            }
        }
        return have;
    }

    /**
     * Возвращает предполагаемый вериант хода.
     * @param dist - ячейка на которой следует закончить ход.
     * @return - ячейки хода.
     */
    public Cell[] move(Cell dist) {
        return move(this.maxIndex, dist);
    }

    /**
     * Возвращает предполагаемый вериант хода.
     * @param maxNumberSteps - максимальное кол-во шагов которое можно сделать
     * @param dist - ячейка на которой следует закончить ход
     * @return - ячейки хода.
     */
    public Cell[] move(int maxNumberSteps, Cell dist) {
        final byte maxCells = 32;
        Cell[] cells = new Cell[maxCells];
        int indexCells = 0;
        int indexHorisontal = this.position.getHorisontal();
        int indexVertical = this.position.getVertical();
        while (true) {
            // направление движения
            indexHorisontal += getDirection(dist)[0];
            indexVertical += getDirection(dist)[1];
            // когда фигура дойдет до конца поля или превысит максимальное кол-во шагов
            if ((indexHorisontal > this.maxIndex) || (indexVertical > this.maxIndex) || (indexHorisontal < this.minIndex) || (indexVertical < this.minIndex) || (maxNumberSteps < indexCells)) {
                break;
            }
            cells[indexCells] = new Cell(indexHorisontal, indexVertical);
            // когда встретит ячейку
            if (dist.equalsCell(new Cell(indexHorisontal, indexVertical))) {
                break;
            }
            indexCells++;
        }
        return cells;
    }

    /**
     * Возвращает направление хода.
     * @param dist - ячейка на которую следует сходить.
     * @return - направление. Массив из двух цифр. Первая это направление по горизонтали. Вторая это направление по вертикали.
     * |-1, 1|0, 1|1, 1|
     * |-1, 0|0, 0|1, 0|
     * |-1,-1|0,-1|1,-1|
     */
    public int[] getDirection(Cell dist) {
        int[] direction = new int[2];

        final int indexHorisontal = 0;
        final int indexVertical = 1;

        final int stepHorisontal = dist.getHorisontal() - this.position.getHorisontal();
        final int stepVertical = dist.getVertical() - this.position.getVertical();
        // направление по горизонтали
        if (stepHorisontal > 0) {
            direction[indexHorisontal] = 1;
        } else if (stepHorisontal < 0) {
            direction[indexHorisontal] = -1;
        } else {
            direction[indexHorisontal] = 0;
        }
        // направление по вертикали
        if (stepVertical > 0) {
            direction[indexVertical] = 1;
        } else if (stepVertical < 0) {
            direction[indexVertical] = -1;
        } else {
            direction[indexVertical] = 0;
        }
        return direction;
    }

    /**
     * Объеденит два массива.
     * @param cellsA - первый массив
     * @param cellsB - второй массив
     * @return - объедененный массив
     */
    public Cell[] add(Cell[] cellsA, Cell[] cellsB) {
        Cell[] cells = new Cell[cellsA.length + cellsB.length];
        int index = 0;
        for (Cell cell : cellsA) {
            if (cell != null) {
                cells[index] = cell;
                index++;
            }
        }
        for (Cell cell : cellsB) {
            if (cell != null) {
                cells[index] = cell;
                index++;
            }
        }
        return cells;
    }

    /**
     * Меняет место фигуры.
     * @param dist - новая координата фигуры.
     */
    public void clone(Cell dist) {
        this.position = dist;
    }


}
