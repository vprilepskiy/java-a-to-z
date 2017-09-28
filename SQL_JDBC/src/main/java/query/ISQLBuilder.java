package query;

/**
 * Created by VLADIMIR on 28.09.2017.
 */
public interface ISQLBuilder {

    /**
     * Set search conditions by field.
     * @param field - field of table.
     * @param compare - preposition of comparison.
     * @param value - value.
     */
    void addCondition(String field, String compare, String value);

    /**
     * Set union between conditions.
     */
    void setAnd();

    /**
     * Set union between conditions.
     */
    void setOr();

    /**
     * Get SQL query.
     */
    String getSelect();
}
