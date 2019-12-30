package com.kndykndy.leetcode.util;

public class Utils {

    private Utils() {
    }

    public static void printBooleanMatrix(boolean[][] m) {
        for (boolean[] mvalue : m) {
            for (int j = 0; j < m[0].length; j++) {
//                System.out.print((char) ('A' + String.valueOf(mvalue[j]).charAt(0) - 'a'));
                System.out.print(mvalue[j] ? "T " : "- ");
            }
            System.out.println();
        }
    }
}
