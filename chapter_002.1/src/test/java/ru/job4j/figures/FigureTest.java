package ru.job4j.figures;

import org.junit.Test;
import ru.job4j.actions.Board;
import ru.job4j.actions.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by VLADIMIR on 13.01.2017.
 */
public class FigureTest {

    private Board board = new Board();

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
        final Cell cell = new Cell(3, 2);
        // вычисляем направление по прямым
        final int[] directionUp = this.board.getDirection(cell, new Cell(3, 5));
        final int[] directionDown = this.board.getDirection(cell, new Cell(3, 0));
        final int[] directionRight = this.board.getDirection(cell, new Cell(5, 2));
        final int[] directionLeft = this.board.getDirection(cell, new Cell(1, 2));
        // вычисляем направление по диаганалям
        final int[] directionUpRight = this.board.getDirection(cell, new Cell(5, 4));
        final int[] directionUpLeft = this.board.getDirection(cell, new Cell(1, 4));
        final int[] directionDownRight = this.board.getDirection(cell, new Cell(5, 0));
        final int[] directionDownLeft = this.board.getDirection(cell, new Cell(1, 0));
        // вычисляем направление по центру
        final int[] directionCenter = this.board.getDirection(cell, new Cell(3, 2));
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
        final int[][] pointsDirections = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        // координата фигуры
        final int[] pointCellFigute = {3, 2};
        // ход по диагонали
        final int[] pointDistDiagonal = {5, 4};
        // ход по прямой
        final int[] pointDistLine = {3, 7};
        final Cell cell = new Cell(pointCellFigute[0], pointCellFigute[1]);
        final Cell distDagonal = new Cell(pointDistDiagonal[0], pointDistDiagonal[1]);
        final Cell distLine = new Cell(pointDistLine[0], pointDistLine[1]);
        assertTrue(this.board.validateDirect(pointsDirections, cell, distDagonal));
        assertFalse(this.board.validateDirect(pointsDirections, cell, distLine));
    }


    /**
     * Test for Method getWay.
     */
    @Test
    public void testGetWay() {
        // координата фигуры
        final int[] pointCellFigute = {3, 2};
        final Cell cellFigute = new Cell(pointCellFigute[0], pointCellFigute[1]);
        // ход по диагонали
        final int[] pointDistDiagonal = {6, 5};
        final Cell distDiagonal = new Cell(pointDistDiagonal[0], pointDistDiagonal[1]);
        // фигура
        Figure figure = new FigureBishop(cellFigute);
        // ход
        final Cell[] cellsDiagonal = this.board.getWay(figure.getPosition(), distDiagonal);
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

