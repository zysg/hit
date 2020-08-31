package com.htsc;

public abstract class Expression {

    protected String left,right;

    public Expression(String left,String right) {
        this.left=left;
        this.right=right;
    }
    public abstract String toString();
}
