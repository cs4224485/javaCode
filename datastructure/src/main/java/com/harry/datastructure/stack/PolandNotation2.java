package com.harry.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation2 {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
        //2. 因为直接对 str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的 List
        // 即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        // 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String expression = "100+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("rpnList=" + infixExpressionList);
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println(suffixExpreesionList);
        System.out.printf("expression=%d", calculate(suffixExpreesionList)); // ?

    }
    //完成对逆波兰表达式的运算
    /*
    *   1)从左至右扫描，将 3 和 4 压入堆栈；
        2)遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
        3)将 5 入栈；
        4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
        5)将 6 入栈；
        6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
    */

    public static int calculate(List<String> ls) {
        // 创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历ls
        for (String item : ls) {
            // 这里使用正则表达式取出数
            if (item.matches("\\d+")) {
                // 匹配多位数
                stack.push(item);
            } else {
                // pop出两个数，并运算 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把 res 入栈
                System.out.println(res);
                stack.push("" + res);
            }

        }
        //最后留在 stack 中的数据是运算结果
        return Integer.parseInt(stack.pop());

    }
    //即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
    //方法：将得到的中缀表达式对应的 List => 后缀表达式对应的 List
    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>(); // 符号栈
        // 说明：因为s2这个栈在整个转换过程中没有pop操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里就不用stack 直接用list
        List<String> s2 = new ArrayList<String>(); // 储存中间结果的 Lists2

        // 遍历ls
        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); //!!! 将(弹出s1栈，消除小括号
            }else {
                // 当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中心的栈顶运算符相比较
                // 问题：我们缺少一个比较优先级高低的方法
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ) {
                    s2.add(s1.pop());
                }
                //还需要将 item 压入栈
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2; //注意因为是存放到 List, 因此按顺序输出就是对应的后缀表达式对应的 List
    }
    // 将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getListString(String suffixExpression) {
    //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        return new ArrayList<String>(Arrays.asList(split));
    }
    public static List<String> toInfixExpressionList(String expression){
        ArrayList<String> ls = new ArrayList<>();
        int index = 0;
        String str = ""; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到 c
        do {
            //如果 c 是一个非数字，我需要加入到 ls
            if((c=expression.charAt(index)) < 48 || (c=expression.charAt(index)) > 57) {
                ls.add("" + c);
                index++; //i 需要后移
            } else { //如果是一个数，需要考虑多位数
                str = "";
                while (index < expression.length() && (c=expression.charAt(index)) >= 48 && (c=expression.charAt(index)) <= 57){
                    str += c;//拼接
                    index++;
                }
                ls.add(str);
            }
            }while (index < expression.length());
        return ls;
    }
}


// 编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println(operation);
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}