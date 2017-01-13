package ru.job4j.figures;

import org.junit.Test;
import ru.job4j.actions.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

//    @Test
//    public void testMove(){
//
//    }
}
