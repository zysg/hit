package com.htsc;

public class OrExpression extends Expression {

    public OrExpression(String left,String right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return left.toString() + " OR " + right.toString();
    }
}
