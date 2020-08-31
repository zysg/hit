package com.htsc;

import org.junit.Assert;
import org.junit.Test;

public class getSqlTest {
    @Test
    public void Test_Singleexp() {
        Assert.assertEquals("Select * from table where Company Name == \"HTSC\"",
                            getSql.printSql("Company Name == \"HTSC\""));
    }
    @Test
    public void Test_ANDExp() {
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") AND (age < 30)",
                getSql.printSql("(Company Name == \"HTSC\")&&(age < 30)"));
    }
    @Test
    public void Test_ORExp() {
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") OR (sex != \"Male\")",
                getSql.printSql("(Company Name == \"HTSC\")||(sex != \"Male\")"));
    }
    @Test
    public void Test_CombinationExp1() {
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") OR ((age < 30) AND (sex != \"Male\"))",
                getSql.printSql("(Company Name == \"HTSC\")||((age < 30)&&(sex != \"Male\"))"));
    }
    @Test
    public void Test_CombinationExp2() {
        Assert.assertEquals("Select * from table where ((Company Name == \"HTSC\") AND (age < 30)) OR (sex != \"Male\")",
                getSql.printSql("((Company Name == \"HTSC\")&&(age < 30))||(sex != \"Male\")"));
    }
}
