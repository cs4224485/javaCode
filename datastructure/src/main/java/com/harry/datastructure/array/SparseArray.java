package com.harry.datastructure.array;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SparseArray {

     public static void main(String[] args) {

         int[][] baseArray = new int[11][12];
         System.out.println();
         baseArray[2][2] = 1;
         baseArray[3][3] = 2;
         baseArray[3][11] = 2;
         printArray(baseArray);
         int[][] sparseArray = toSparseArray(baseArray);
         printArray(sparseArray);
         printArray(toBaseArray(sparseArray));
     }

    public static void printArray(int inputArray[][]){
        for (int i = 0; i <inputArray.length  ; i++) {
            System.out.println("\t");
            for (int j = 0; j <inputArray[i].length ; j++) {
                System.out.print("\t"+inputArray[i][j]);
            }
        }
    }
    public static int[][] toSparseArray(int baseArray[][]){
         int valueCount = 0;
        for (int i = 0; i <baseArray.length ; i++) {
            for (int j = 0; j <baseArray[i].length ; j++) {
                if (baseArray[i][j] > 0){
                    valueCount++;
                }
            }
        }
        int[][] sparseArray = new int[valueCount+1][3];
        sparseArray[0][0] = baseArray.length;
        sparseArray[0][1] = baseArray[0].length;
        sparseArray[0][2] = valueCount;
        int count = 0;
        for (int i = 0; i < baseArray.length; i++) {
            for (int j = 0; j < baseArray[0].length; j++) {
                if (baseArray[i][j] > 0){
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = baseArray[i][j];
                }
            }
        }
        return sparseArray;
    }
    public static int[][] toBaseArray(int sparseArray[][]){
         int [][] newArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            newArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
         return newArray;
    }
    public static void saveArray(int baseArray[][]){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("array.data"));
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(baseArray);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
