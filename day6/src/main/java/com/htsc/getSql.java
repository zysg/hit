package com.htsc;

import java.util.Stack;

public class getSql {
    public static String generate(String s) {
        Stack<Character> bracket = new Stack<Character>();
        Stack<String> str = new Stack<String>();
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c == '(') {
                bracket.push(c);
            }
            else if(c == '&'||c == '|') {
                i++;
                bracket.push(c);
            }
            else if(c == '!'&&s.charAt(i+1)!='=') {
                bracket.push(c);
            }
            else if(c == ')') {
                    if(bracket.peek() == '(') {
                        str.push(tmp);
                        tmp = "";
                        bracket.pop();
                    }
                    else if(bracket.peek() == '|') {
                        String temp2=str.pop(); temp2="("+temp2+")";
                        String temp1=str.pop(); temp1="("+temp1+")";
                        Expression expression = new OrExpression(temp1, temp2);
                        str.push(expression.toString());
                        bracket.pop();
                        if(bracket.peek() == '(')  bracket.pop();
                    }
                    else if (bracket.peek() == '&') {
                        String temp2=str.pop(); temp2="("+temp2+")";
                        String temp1=str.pop(); temp1="("+temp1+")";
                        Expression expression = new AndExpression(temp1, temp2);
                        str.push(expression.toString());
                        bracket.pop();
                        if(bracket.peek() == '(')  bracket.pop();
                    }
                    else if (bracket.peek() == '!') {
                        String temp = str.pop();
                        Expression expression = new NotExpression(temp, temp);
                        str.push(expression.toString());
                        bracket.pop();
                        if (bracket.peek() == '(') bracket.pop();
                    }
            }
            else {
                tmp += (c+"");
            }
        }
        if(!tmp.equals(""))
            str.push(tmp);
        while(!bracket.empty()) {
            if(bracket.peek() == '|') {
                String temp2=str.pop(); temp2="("+temp2+")";
                String temp1=str.pop(); temp1="("+temp1+")";
                Expression expression = new OrExpression(temp1, temp2);
                str.push(expression.toString());
                bracket.pop();
            }
            else if(bracket.peek() == '&') {
                String temp2=str.pop(); temp2="("+temp2+")";
                String temp1=str.pop(); temp1="("+temp1+")";
                Expression expression = new AndExpression(temp1, temp2);
                str.push(expression.toString());
                bracket.pop();
            }
            else if(bracket.peek() == '!') {
                String temp=str.pop();
                Expression expression = new NotExpression(temp, temp);
                str.push(expression.toString());
                bracket.pop();
            }
            else {
                bracket.pop();
            }
        }
        return str.peek();
    }

    public static String printSql(String s) {
        String res = "Select * from table where ";
        res += generate(s);
        return res;
    }
}
