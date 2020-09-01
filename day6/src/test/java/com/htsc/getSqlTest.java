package com.htsc;

import org.junit.Assert;
import org.junit.Test;

public class getSqlTest {
    @Test
    public void Test_Singleexp() {//只有一个表达式
        Assert.assertEquals("Select * from table where Company Name == \"HTSC\"",
                            getSql.printSql("Company Name == \"HTSC\""));
    }
    @Test
    public void Test_ANDExp() {//AND连接的表达式
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") AND (age < 30)",
                getSql.printSql("(Company Name == \"HTSC\")&&(age < 30)"));
    }
    @Test
    public void Test_ORExp() {//OR连接的表达式
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") OR (sex != \"Male\")",
                getSql.printSql("(Company Name == \"HTSC\")||(sex != \"Male\")"));
    }
    @Test
    public void Test_NOTExp() {//NOT的表达式
        Assert.assertEquals("Select * from table where NOT isExisted",
                getSql.printSql("!isExisted"));
    }
    @Test
    public void Test_MultiAnd() {//两个AND嵌套的表达式
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") AND ((contactName != null) AND (age > 20))",
                getSql.printSql("(Company Name == \"HTSC\")&&(contactName != null)&&(age > 20)"));
    }
    @Test
    public void Test_MultiOR() {//两个OR嵌套的表达式
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") OR ((contactName != null) OR (age > 20))",
                getSql.printSql("(Company Name == \"HTSC\")||(contactName != null)||(age > 20)"));
    }

    @Test
    public void Test_ORAND() {//OR和AND嵌套的表达式
        Assert.assertEquals("Select * from table where (Company Name == \"HTSC\") OR ((age < 30) AND (sex != \"Male\"))",
                getSql.printSql("(Company Name == \"HTSC\")||((age < 30)&&(sex != \"Male\"))"));
    }
    @Test
    public void Test_ANDOR() {//AND和OR嵌套的表达式
        Assert.assertEquals("Select * from table where ((Company Name == \"HTSC\") AND (age < 30)) OR (sex != \"Male\")",
                getSql.printSql("((Company Name == \"HTSC\")&&(age < 30))||(sex != \"Male\")"));
    }
    @Test
    public void Test_NotAnd() {//NOT和AND嵌套的表达式
        Assert.assertEquals("Select * from table where NOT (Company Name == \"HTSC\") AND (contactName != null)",
                getSql.printSql("!((Company Name == \"HTSC\")&&(contactName != null))"));
        Assert.assertEquals("Select * from table where NOT (Company Name == \"HTSC\") AND ((contactName != null) AND (age >= 20))",
                getSql.printSql("!((Company Name == \"HTSC\")&&(contactName != null)&&(age >= 20))"));
    }
    @Test
    public void Test_NotAndOR() {//OR、AND和OR嵌套的表达式
        Assert.assertEquals("Select * from table where NOT (Company Name == \"HTSC\") OR (contactName != null)",
                getSql.printSql("!((Company Name == \"HTSC\")||(contactName != null))"));
        Assert.assertEquals("Select * from table where NOT (Company Name == \"HTSC\") OR ((contactName != null) AND (age >= 20))",
                getSql.printSql("!((Company Name == \"HTSC\")||(contactName != null)&&(age >= 20))"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void Test_Exception() {//括号不匹配的情况抛出异常
        getSql.printSql("(Company Name == \"HTSC\")&&((age < 30)");
    }
}