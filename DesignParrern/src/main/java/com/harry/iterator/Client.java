package com.harry.iterator;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<College> collegeList = new ArrayList<>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();
        collegeList.add(computerCollege);
        collegeList.add(infoCollege);
        OutPutImpl outPut = new OutPutImpl(collegeList);
        outPut.printCollege();

    }
}
