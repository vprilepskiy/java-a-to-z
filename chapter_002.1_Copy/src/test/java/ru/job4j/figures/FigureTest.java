package ru.job4j.figures;

import org.junit.Test;
import ru.job4j.actions.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by VLADIMIR on 13.01.2017.
 */
public class FigureTest {

    /**
     * Test for Method getDirection.
     */
    @Test
    public void testGetDirection() {
        final int[] resultUp = {0, 1};
        final int[] resultDown = {0, -1};
        final int[] resultRight = {1, 0};
        final int[] resultLeft = {-1, 0};
        final int[] resultUpRight = {1, 1};
        final int[] resultUpLeft = {-1, 1};
        final int[] resultDownRight = {1, -1};
        final int[] resultDownLeft = {-1, -1};
        final int[] resultCenter = {0, 0};
        // ставим фигуру
        final Figure figure = new FigureBishop(new Cell(3, 2));
        // вычисляем направление по прямым
        final int[] directionUp = figure.getDirection(new Cell(3, 5));
        final int[] directionDown = figure.getDirection(new Cell(3, 0));
        final int[] directionRight = figure.getDirection(new Cell(5, 2));
        final int[] directionLeft = figure.getDirection(new Cell(1, 2));
        // вычисляем направление по диаганалям
        final int[] directionUpRight = figure.getDirection(new Cell(5, 4));
        final int[] directionUpLeft = figure.getDirection(new Cell(1, 4));
        final int[] directionDownRight = figure.getDirection(new Cell(5, 0));
        final int[] directionDownLeft = figure.getDirection(new Cell(1, 0));
        // вычисляем направление по центру
        final int[] directionCenter = figure.getDirection(new Cell(3, 2));
        // сравниваем
        assertThat(resultUp, is(directionUp));
        assertThat(resultDown, is(directionDown));
        assertThat(resultRight, is(directionRight));
        assertThat(resultLeft, is(directionLeft));
        assertThat(resultUpRight, is(directionUpRight));
        assertThat(resultUpLeft, is(directionUpLeft));
        assertThat(resultDownRight, is(directionDownRight));
        assertThat(resultDownLeft, is(directionDownLeft));
        assertThat(resultCenter, is(directionCenter));
    }

    /**
     * Test for Method validateDirect.
     */
    @Test
    public void testValidateDirect() {
        // направления по диаганалям
        final int[][] directions = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        // координата фигуры
        final int[] cellFigute = {3, 2};
        // ход по диагонали
        final int[] distDiagonal = {5, 4};
        // ход по прямой
        final int[] distLine = {3, 7};
        final Figure figure = new FigureBishop(new Cell(cellFigute[0], cellFigute[1]));
        assertTrue(figure.validateDirect(directions, new Cell(distDiagonal[0], distDiagonal[1])));
        assertFalse(figure.validateDirect(directions, new Cell(distLine[0], distLine[1])));
    }


    /**
     * Test for Method move.
     */
    @Test
    public void testMove() {
        // координата фигуры
        final int[] cellFigute = {3, 2};
        // ход по диагонали
        final int[] distDiagonal = {6, 5};
        // фигура
        final Figure figure = new FigureBishop(new Cell(cellFigute[0], cellFigute[1]));
        // ход
        final Cell[] cellsDiagonal = figure.move(new Cell(distDiagonal[0], distDiagonal[1]));
        // ожидаемый результвт
        final int[][] resultCoordinateDiagonals = {{4, 3}, {5, 4}, {6, 5}};
        // получившийся результат
        final int[][] coordinateCellsDiagonals = new int[resultCoordinateDiagonals.length][2];
        int index = 0;
        for (Cell cell : cellsDiagonal) {
            if (cell != null) {
                coordinateCellsDiagonals[index][0] = cell.getHorisontal();
                coordinateCellsDiagonals[index][1] = cell.getVertical();
                index++;
            }
        }


        assertThat(resultCoordinateDiagonals, is(coordinateCellsDiagonals));
    }
}

