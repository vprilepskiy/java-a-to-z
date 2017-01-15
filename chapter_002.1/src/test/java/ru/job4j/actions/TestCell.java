package ru.job4j.actions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by VLADIMIR on 15.01.2017.
 */
public class TestCell {

    /**
     * Test for method equalsCell.
     */
    @Test
    public void testEqualsCell() {
        final int[] cell0 = {3, 2};
        final int[] cell1 = {3, 2};
        final int[] cell2 = {3, 3};
        assertTrue(new Cell(cell0[0], cell0[1]).equalsCell(new Cell(cell1[0], cell1[1])));
        assertFalse(new Cell(cell0[0], cell0[1]).equalsCell(new Cell(cell2[0], cell2[1])));
    }

    /**
     * Test for method equalsCell.
     */
    @Test
    public void testEqualsCells() {
        final int[][] coordinateCells = {{3, 2}, {4, 3}, {5, 4}};
        Cell[] cells = new Cell[coordinateCells.length];
        for (int index = 0; index < coordinateCells.length; index++) {
            cells[index] = new Cell(coordinateCells[index][0], coordinateCells[index][1]);
        }

        final int[] cell0 = {3, 2};
        final int[] cell1 = {4, 2};
        assertTrue(new Cell(cell0[0], cell0[1]).equalsCell(cells));
        assertFalse(new Cell(cell1[0], cell1[1]).equalsCell(cells));
    }

}
