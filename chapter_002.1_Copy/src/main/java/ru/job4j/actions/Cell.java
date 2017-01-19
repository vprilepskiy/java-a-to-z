package ru.job4j.actions;

/**
 * Ячейка.
 */
public class Cell {

    /**
     * Индекс по горизонтали.
     */
    private final int horisontal;
    /**
     * Индекс по вертикали.
     */
    private final int vertical;

    /**
     * Конструктор.
     * @param horisontal Индекс по вертикали.
     * @param vertical Индекс по горизонтали.
     */
    public Cell(int horisontal, int vertical) {
        this.horisontal = horisontal;
        this.vertical = vertical;
    }

    /**
     * Возвращает координату по горизонтали.
     * @return координата.
     */
    public int getHorisontal() {
        return this.horisontal;
    }

    /**
     * Возвращает координату по вертикали.
     * @return координата.
     */
    public int getVertical() {
        return this.vertical;
    }

    /**
     * Сравнивает ячейки.
     * @param cell - сравниваемая ячейка.
     * @return - Если ячейки совпадают, то метод вернет true.
     */
    public boolean equalsCell(Cell cell) {
        boolean result = false;
        if (cell != null) {
            result = (this.horisontal == cell.getHorisontal()) && (this.vertical == cell.getVertical());
        }
        return result;
    }

    /**
     * Сравнивает ячейки.
     * @param cells - массив сравниваемых ячеек.
     * @return - Если в массиве имеется такая ячейка, то метод вернет true.
     */
    public boolean equalsCell(Cell[] cells) {
        boolean have = false;
        for (Cell cell : cells) {
            if (cell != null) {
                have = cell.equalsCell(this);
                if (have) {
                    break;
                }
            }
        }
        return have;
    }
}
