package ru.job4j.figures;

import ru.job4j.actions.Cell;
import ru.job4j.exceptions.ImpossibleMoveException;

/**
 * Фигура Слон.
 */
public class FigureBishop extends Figure {

    @Override
    public String getName() {
        return "Слон";
    }

    /**
     * Конструктор.
     * @param position - задает позицию.
     */
    public FigureBishop(Cell position) {
        super(position);
    }

    /**
     * Реализуем слона. Слон ходит по диаганалям.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] cells;
        // направления по диаганалям
        final int[][] directions = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        // если направление верное
        if (validateDirect(directions, dist)) {
            // получить предполагаемый вариант хода
            cells = move(dist);
        } else {
            throw new ImpossibleMoveException("Слон ходит по диаганалям, а не по прямым!");
        }
        // если цель не совпала с траекторией
        if (!(dist.equalsCell(cells))) {
            throw new ImpossibleMoveException("Фигура не может так сходить!");
        }
        return cells;
    }
}
