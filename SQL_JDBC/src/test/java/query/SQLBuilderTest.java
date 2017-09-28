package query;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 28.09.2017.
 */
public class SQLBuilderTest {

    @Test
    public void getSelect() {

        // data
        final String[] fields = {"fieldName1", "fieldName2", "fieldName3"};
        final String table = "tableName";

        final SQLBuilder sqlBuilder = new SQLBuilder(fields, table);

        // expect
        final StringBuilder expect = new StringBuilder("SELECT fieldName1, fieldName2, fieldName3 FROM tableName");

        // assert
        Assert.assertThat(sqlBuilder.getSelect(), Is.is(expect.toString()));



        // add condition
        sqlBuilder.addCondition(fields[0], "LIKE", "'%cond%'");

        // expect
        expect.append(" WHERE fieldName1 LIKE '%cond%'");

        // assert
        Assert.assertThat(sqlBuilder.getSelect(), Is.is(expect.toString()));



        // add condition
        sqlBuilder.addCondition(fields[1], ">", "15");

        // expect
        expect.append(" AND fieldName2 > 15");

        // assert
        Assert.assertThat(sqlBuilder.getSelect(), Is.is(expect.toString()));



        // add condition
        sqlBuilder.setOr();
        sqlBuilder.addCondition(fields[2], "<", "10");

        // expect
        expect.append(" OR fieldName3 < 10");

        // assert
        Assert.assertThat(sqlBuilder.getSelect(), Is.is(expect.toString()));
    }

}