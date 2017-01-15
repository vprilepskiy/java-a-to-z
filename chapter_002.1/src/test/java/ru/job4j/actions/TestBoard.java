package ru.job4j.actions;

import org.junit.Test;
import ru.job4j.exceptions.FigureNotFoundException;
import ru.job4j.exceptions.ImpossibleMoveException;
import ru.job4j.exceptions.OccupiedWayException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by VLADIMIR on 15.01.2017.
 */
public class TestBoard {

    /**
     * Test for method getFigure.
     */
    @Test
    public void testGetFigure() {
        final byte[] coordinateCell = {0, 0};
        final String name = new Board().getFigure(new Cell(coordinateCell[0], coordinateCell[1])).getName();
        final String result = "Ладья";
        assertThat(result, is(name));
    }

    /**
     * Test for method move.
     */
    @Test
    public void testMove() {
        Board board = new Board();
        final Cell source = new Cell(0, 0);
        final Cell dist = new Cell(0, 5);
        try {
            board.move(source, dist);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        }
        final String name = board.getFigure(dist).getName();
        final String result = "Ладья";
        assertThat(result, is(name));
    }
}
