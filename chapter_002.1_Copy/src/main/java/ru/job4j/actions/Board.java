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

    /**
     * Количество фигур на доске.
     */
    private final byte numberFidures = 32;

    /**
     * Фигуры.
     */
    private Figure[] figures = new Figure[numberFidures];

    /**
     * Индекс последней добавленной фигуры.
     */
    private int figuresIndex = 0;

    /**
     * Конструктор.
     */
    public Board() {
        addAllFigure();
    }

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
    private void addAllFigure() {
        final byte[] cellA1 = {0, 0};
        final byte[] cellH1 = {7, 0};
        final byte[] cellC1 = {2, 0};
        final byte[] cellF1 = {0, 0};
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
}
