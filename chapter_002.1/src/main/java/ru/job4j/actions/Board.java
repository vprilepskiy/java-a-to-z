package ru.job4j.actions;

import ru.job4j.exceptions.FigureNotFoundException;
import ru.job4j.exceptions.ImpossibleMoveException;
import ru.job4j.exceptions.OccupiedWayException;
import ru.job4j.figures.Figure;
import ru.job4j.figures.FigureBishop;
import ru.job4j.figures.FigureRook;

/**
 * Метод должен должен проверить
 - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
 - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
 - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
 - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
 */

/**
 * Доска.
 */
public class Board {

    /** ВЫНЕСТИ В Board
     * Минимальный индекс поля.
     */
    private final int minIndex = 0;

    /** ВЫНЕСТИ В Board
     * Максимальный индекс поля.
     */
    private final int maxIndex = 7;

    /**
     * Количество фигур на доске.
     */
    private final int numberFidures = 32;

    /**
     * Фигуры.
     */
    private Figure[] figures = new Figure[numberFidures];

    /**
     * Индекс последней добавленной фигуры.
     */
    private int figuresIndex = 0;

//    /**
//     * Конструктор.
//     */
//    public Board() {
//        this.addAllFigure();
//    }

    /**
     * Выполняет движение фигуры.
     * @param source - ячейка на которой находится вигура.
     * @param dist - ячейка на которую следует сходть.
     * @return - всегда возвращает true
     * @throws ImpossibleMoveException - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     * @throws OccupiedWayException - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     * @throws FigureNotFoundException - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        // получили фигуру
        Figure figure = getFigure(source);
        // если фигура есть
        if (figure != null) {
            // получили массив ячеек, которые должна пройти фигура
            Cell[] cells = figure.way(dist);
            // если по пути найдется другая фигура
            for (Cell cell : cells) {
                if (cell != null) {
                    if (getFigure(cell) != null) {
                        throw new OccupiedWayException("На пути следования стоит фигура");
                    }
                }
            }
        } else {
            throw new FigureNotFoundException("В ячейке нет фигуры! Ходить нечем!");
        }
        figure.clone(dist);
        return true;
    }

    /**
     * Добавит фигуру на доску.
     * @param figure - фигура.
     */
    private void addFigure(Figure figure) {
        this.figures[this.figuresIndex] = figure;
        this.figuresIndex++;
    }

    /**
     * Расставляет фигуры на доску.
     */
    public void addAllFigure() {
        final int[] cellA1 = {0, 0};
        final int[] cellH1 = {7, 0};
        final int[] cellC1 = {2, 0};
        final int[] cellF1 = {5, 0};
        addFigure(new FigureRook(new Cell(cellA1[0], cellA1[1])));
        addFigure(new FigureRook(new Cell(cellH1[0], cellH1[1])));
        addFigure(new FigureBishop(new Cell(cellC1[0], cellC1[1])));
        addFigure(new FigureBishop(new Cell(cellF1[0], cellF1[1])));
    }

    /**
     * Вернет фигуру по ячейке.
     * @param source - ячейка.
     * @return - фигура. Вернет null- если не найдет.
     */
    public Figure getFigure(Cell source) {
        Figure result = null;
        for (Figure figure : this.figures) {
            if (figure != null) {
                if (source.equalsCell(figure.getPosition())) {
                    result = figure;
                    break;
                }
            }
        }
        return result;
    }

    /** ВЫНЕСТИ В Board
     * Проверяет есть ли такое направление хода.
     * @param directions - направления. Массив из двух цифр. Первая это направление по горизонтали. Вторая это направление по вертикали. Направленй может быть несколько, по этому массив двумерный.
     * @param dist - ячейка на которую следует сходить.
     * @return - true если направление хода верное.
     */
    public boolean validateDirect(int[][] directions, Cell cell, Cell dist) {
        boolean have = false;
        for (int[] direction : directions) {
            have = (direction[0] == getDirection(cell, dist)[0]) && (direction[1] == getDirection(cell, dist)[1]);
            if (have) {
                break;
            }
        }
        return have;
    }

    /** ВЫНЕСТИ В Board
     * Возвращает предполагаемый вериант хода.
     * @param dist - ячейка на которой следует закончить ход.
     * @return - ячейки хода.
     */
    public Cell[] getWay(Cell cell, Cell dist) {
        return this.getWay(this.maxIndex, cell, dist);
    }

    /** ВЫНЕСТИ В Board
     * Возвращает предполагаемый вериант хода.
     * @param maxNumberSteps - максимальное кол-во шагов которое можно сделать
     * @param cell - ячейка на которой следует закончить ход
     * @param dist - ячейка на которой следует закончить ход
     * @return - ячейки хода.
     */
    public Cell[] getWay(int maxNumberSteps, Cell cell, Cell dist) {
        Cell[] cells = new Cell[this.numberFidures];
        int indexCells = 0;
        int indexHorisontal = cell.getHorisontal();
        int indexVertical = cell.getVertical();
        while (true) {
            // направление движения
            indexHorisontal += getDirection(cell, dist)[0];
            indexVertical += getDirection(cell, dist)[1];
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

    /** ВЫНЕСТИ В Board
     * Возвращает направление хода.
     * @param dist - ячейка на которую следует сходить.
     * @return - направление. Массив из двух цифр. Первая это направление по горизонтали. Вторая это направление по вертикали.
     * |-1, 1|0, 1|1, 1|
     * |-1, 0|0, 0|1, 0|
     * |-1,-1|0,-1|1,-1|
     */
    public int[] getDirection(Cell cell, Cell dist) {
        int[] direction = new int[2];

        final int indexHorisontal = 0;
        final int indexVertical = 1;

        final int stepHorisontal = dist.getHorisontal() - cell.getHorisontal();
        final int stepVertical = dist.getVertical() - cell.getVertical();
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



}
