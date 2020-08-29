import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testSql() {

        Generate generate = new Generate();
        generate.createSubSql("Company Name", "aaa", "equal");
        assertEquals("Select * from table where Company Name = aaa", generate.generateSql());
    }

    @Test
    public void testSqlAnd() {
        Generate generate = new Generate();
        generate.createSubSql("Company Name", "aaa", "equal");
        generate.createSubSql("Contact title", "bbb", "notequal", "and");
        assertEquals("Select * from table where Company Name = aaa and Contact title <> bbb", generate.generateSql());
    }

    @Test
    public void testSqlOr() {
        Generate generate = new Generate();
        generate.createSubSql("Company Name","aaa","equal");
        generate.createSubSql("Phone","6", "contains","or");
        assertEquals("Select * from table where Company Name = aaa or Phone CONTAINS 6",generate.generateSql());
    }
}
