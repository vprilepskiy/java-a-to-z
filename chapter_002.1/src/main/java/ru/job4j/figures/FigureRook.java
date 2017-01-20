package ru.job4j.figures;

import ru.job4j.actions.Board;
import ru.job4j.actions.Cell;
import ru.job4j.exceptions.ImpossibleMoveException;

/**
 * Фигура ладья.
 */
public class FigureRook extends Figure {

    @Override
    public String getName() {
        return "Ладья";
    }

    /**
     * Конструктор.
     * @param position - позиция.
     */
    public FigureRook(Cell position) {
        super(position);
    }

    /**
     * Реализуем ладью. Ладья ходит по прямым.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] cells;
        // направления по прямым
        final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        // если направление верное
        if (new Board().validateDirect(directions, super.getPosition(), dist)) {
            // получить предполагаемый вариант хода
            cells = new Board().getWay(this.getPosition(), dist);
        } else {
            throw new ImpossibleMoveException("Ладья ходит только по прямым!");
        }
        // если цель не совпала с траекторией
        if (!(dist.equalsCell(cells))) {
            throw new ImpossibleMoveException("Фигура не может так сходить!");
        }
        return cells;
    }
}
