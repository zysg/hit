package com.htsc;

public class NotExpression extends Expression {

    public NotExpression(String left,String right) {
        super(left, right);
    }

    @Override
    public String toString() { return "NOT " + left.toString(); }
}
