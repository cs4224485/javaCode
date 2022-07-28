package com.harry.interpreter;

import java.util.HashMap;

public class AddExpression extends SymbolExpression{

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }
    //处理相加
    // var 仍然是 {a=10,b=20}..
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
