package com.harry.datastructure;

import java.util.ArrayList;
import java.util.List;

public class testListy {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
        for (int i = 0; i <2 ; i++) {
            Test test = new Test((ArrayList<Integer>) list.clone());
            test.testList();
            System.out.println(test.list);
        }
        System.out.println(list);

    }
    public static class Test{
        List<Integer> list;
        public Test(List<Integer> list){
            this.list = list;
        }
        public void testList(){
            list.add(5);
        }
    }
}
