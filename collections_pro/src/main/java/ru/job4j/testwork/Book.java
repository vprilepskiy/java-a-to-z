package ru.job4j.testwork;

/**
 * Created by VLADIMIR on 04.09.2017.
 */
public class Book implements Comparable<Book> {

    /**
     * Book name.
     */
    private final String name;

    /**
     * Book price.
     */
    private final double price;

    /**
     * Constructor.
     * @param name - name.
     * @param price - price.
     */
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter.
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter.
     * @return - price.
     */
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (Double.compare(book.price, price) != 0) {
            return false;
        }
        return name != null ? name.equals(book.name) : book.name == null;
    }

    @Override
    public int hashCode() {
        final int shift = 31;
        final int shiftForDouble = 32;
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = shift * result + (int) (temp ^ (temp >>> shiftForDouble));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{name='");
        sb.append(name);
        sb.append('\'');
        sb.append(", price=");
        sb.append(price);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        int result;

        result = this.name.compareTo(o.name);

        if (result == 0) {
            result = Double.compare(this.price, o.price);
        }

        return result;
    }
}
