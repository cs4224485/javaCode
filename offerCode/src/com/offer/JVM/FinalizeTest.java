package com.offer.JVM;
class Tank{
    protected void finalize(){
        System.out.println(1232);
    }
}

public class FinalizeTest {
    public static void main(String[] args) {
        new Tank();
        while (true){
            new Tank();
        }
//        System.gc();
    }
}
