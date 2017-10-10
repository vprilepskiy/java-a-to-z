package jdbc.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by VLADIMIR on 05.10.2017.
 */
public class Entry {

    /**
     * Row.
     */
    private final String field;

    /**
     * Result of the query from the database.
     * @param field - value.
     */
    public Entry(String field) {
        this.field = field;
    }

    /**
     * Getter.
     * @return - value.
     */
    @XmlElement
    public String getField() {
        return this.field;
    }

    /**
     * Setter.
     * @return - value.
     */
    @Override
    public String toString() {
        return this.field;
    }
}
