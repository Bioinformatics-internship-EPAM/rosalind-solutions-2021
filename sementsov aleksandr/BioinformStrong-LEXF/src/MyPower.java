package com.company;

public class MyPower {
    static int res;
    public static int pow(int level, int number) {
        res = 1;
        for (int i = 0; i < level; i++) {
            res *= number;
        }
        return res;
    }

    //builder pattern
    public static int pow(int level) {
        res = 1;
        for (int i = 0; i < level; i++) {
            res *= 2;
        }
        return res;
    }
}
