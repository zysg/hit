package com.htsc;

public class AndExpression extends Expression{

    public AndExpression(String left, String right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return left.toString() + " AND " + right.toString();
    }
}
