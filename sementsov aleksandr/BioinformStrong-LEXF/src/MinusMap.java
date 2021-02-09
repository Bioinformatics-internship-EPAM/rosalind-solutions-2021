package com.company;

import java.util.Arrays;

public class MinusMap {


    //-------------------------------
    //SubClasses
    public static class ReWriter {
        static int[] buffer;
        static int sizeOfBuffer;
        public static int[] ReWrite(int[] sourceData) {
            sizeOfBuffer = sourceData.length;
            buffer = new int[sizeOfBuffer];
            for (int k = sizeOfBuffer-1; k > -1; k--) {
                buffer[k] = sourceData[k];
            }
            return buffer;
        }
    }
    //-------------------------------


    int[][] minusMap;

    MinusMap(int n) {
        minusMap = new int[MyPower.pow(n)][n];
        for (int i = 0; i < MyPower.pow(n); i++) {
            Arrays.fill(minusMap[i], 0);
        }

        //starting from i = 1, because, in real, the first cortege is null string
        for (int i = 1; i < MyPower.pow(n); i++) {
            for (int j = n-1; j > -1; j--) {

                //I don't like recursive call (:
                if (minusMap[i][j] == 0) {
                    minusMap[i][j] = 1;
                    break;
                }
                else {
                    minusMap[i][j] = 0;
                }
            }
            try {
                minusMap[i+1] = ReWriter.ReWrite(minusMap[i]);
            }
            catch (Exception e) { System.out.println("MinusMap is ready!"); }
        }
    }

    MinusMap(int n, int numeration) {
        minusMap = new int[MyPower.pow(n,numeration)][n];
        for (int i = 0; i < MyPower.pow(n,numeration); i++) {
            Arrays.fill(minusMap[i], 0);
        }

        //для того, чтобы первая строка была нулевая, начнём с i=1
        for (int i = 1; i < MyPower.pow(n, numeration); i++) {
            for (int j = n-1; j > -1; j--) {

                //I don't like recursive call (:
                if (minusMap[i][j] != (numeration - 1)) {
                    minusMap[i][j] += 1;
                    break;
                }
                else {
                    minusMap[i][j] = 0;
                }
            }
            try {
                minusMap[i+1] = ReWriter.ReWrite(minusMap[i]);
            }
            catch (Exception e) { System.out.println("MinusMap is ready!"); }
        }
    }

    public boolean GetMap() {
        try {
            for (int i = 0; i < minusMap.length; i++) {
                for (int j = 0; j < minusMap[i].length; j++) {
                    System.out.print(minusMap[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void GetMap(int[] combination) {
        for (int i = 0; i < minusMap.length; i++) {
            for (int j = 0; j < minusMap[i].length; j++) {
                if (minusMap[i][j] == 0) {
                    System.out.print(combination[j]*(-1));
                }
                else {
                    System.out.print(combination[j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void GetMap(char[] parsedDict) {
        MyWriter.GoSave();
        for (int i = 0; i < minusMap.length; i++) {
            for (int j = 0; j < minusMap[i].length; j++) {
                System.out.print(parsedDict[minusMap[i][j]]);
                MyWriter.WriteResult(parsedDict[minusMap[i][j]]);
            }
            System.out.println();
            MyWriter.WriteResult('\n');
        }
    }

    public int GetMap(int[] combination, int counter) {
        for (int i = 0; i < minusMap.length; i++) {
            for (int j = 0; j < minusMap[i].length; j++) {
                if (minusMap[i][j] == 0) {
                    System.out.print(combination[j]*(-1));
                }
                else {
                    System.out.print(combination[j]);
                }
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
        return counter;
    }
}


