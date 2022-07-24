package com.offer.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestThrow {
    public void testThrow  () throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(new File("/test.txt"));
    }

    public static void main(String[] args) {
        TestThrow testThrow = new TestThrow();


    }
}
