package com.harry.interpreter;

import java.util.HashMap;

public class VarExpression extends Expression{

    private String key; // key=a,key=b,key=c

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
