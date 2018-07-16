package ru.cbr.ekb.prilepskiy.model.entity;

/**
 * Created by VLADIMIR on 12.07.2018.
 *
 * PaperSize.
 */
public class PaperSize implements Comparable<PaperSize> {

    /**
     * Название.
     */
    private final String name;
    /**
     * Ширина.
     */
    private final int width;
    /**
     * Высота.
     */
    private final int height;

    /**
     * Конструктор.
     * @param name - Название.
     * @param width - Ширина.
     * @param height - Высота.
     */
    public PaperSize(String name, int width, int height) {

        if (width < 0) {
            throw new IllegalArgumentException("width < 0");
        }

        if (height < 0) {
            throw new IllegalArgumentException("height < 0");
        }

        this.name = name;
        this.width = width;
        this.height = height;
    }

    /**
     * Gettrer.
     * @return - Название.
     */
    public String getName() {
        return name;
    }

    /**
     * Gettrer.
     * @return - Ширина.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gettrer.
     * @return - Высота.
     */
    public int getHeight() {
        return height;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperSize paperSize = (PaperSize) o;

        if (width != paperSize.width) return false;
        if (height != paperSize.height) return false;
        return name != null ? name.equals(paperSize.name) : paperSize.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public int compareTo(PaperSize o) {
        return new Integer(this.getHeight() * this.getWidth()).compareTo(new Integer(o.getHeight() * o.getWidth()));
    }
}
