package query;

/**
 * Created by VLADIMIR on 28.09.2017.
 */
public class SQLBuilder implements ISQLBuilder {

    /**
     * Fields in select.
     */
    private final String[] fields;
    /**
     * Table.
     */
    private final String table;
    /**
     * Conditions.
     */
    private final StringBuilder conditions;

    /**
     * Constructor.
     * @param fields - fields.
     * @param table - table.
     */
    public SQLBuilder(String[] fields, String table) {
        this.fields = fields;
        this.table = table;
        this.conditions = new StringBuilder();
    }


    @Override
    public void addCondition(String field, String compare, String value) {

        if (this.conditions.length() == 0) {
            this.conditions.append(" WHERE ");
        } else {
            this.conditions.append(this.unionForConditions);
        }

        this.conditions.append(field).append(' ');
        this.conditions.append(compare).append(' ');
        this.conditions.append(value);
    }

    /**
     * Union between conditions.
     */
    private String unionForConditions = " AND ";

    @Override
    public void setAnd() {
        this.unionForConditions = " AND ";
    };

    @Override
    public void setOr() {
        this.unionForConditions = " OR ";
    };

    @Override
    public String getSelect() {
        StringBuilder select = new StringBuilder();
        select.append("SELECT ");

        for (int i = 0; i < this.fields.length; i++) {
            select.append(this.fields[i]);
            if (i < this.fields.length - 1) {
                select.append(", ");
            }
        }

        select.append(" FROM ").append(this.table);

        select.append(this.conditions);

        return select.toString();
    }

}
