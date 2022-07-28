package com.harry.interpreter;

import java.util.HashMap;

public abstract class Expression {
    // a + b - c
    // 解释公式和数值, key 就是公式(表达式) 参数[a,b,c], value 就是就是具体值
    // HashMap {a=10, b=20}
    public abstract int interpreter(HashMap<String, Integer> var);

}
