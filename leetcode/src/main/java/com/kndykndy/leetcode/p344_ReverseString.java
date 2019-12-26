package com.kndykndy.leetcode;

import java.util.Arrays;

public class p344_ReverseString {

    interface Solution {

        void reverseString(char[] s);
    }

    public static class Solution1 implements Solution {

        @Override
        public void reverseString(char[] s) {
            if (s == null || s.length <= 1) {
                return;
            }

            int len = s.length;
            char tmpChar;
            for (int i = 0; i < len / 2; i++) {
                tmpChar = s[len - 1 - i];
                s[len - 1 - i] = s[i];
                s[i] = tmpChar;
            }
        }
    }

    public static void main(String[] args) {
        char[] s = "Hello!".toCharArray();
        new Solution1().reverseString(s);
        System.out.println(Arrays.equals(s, "!olleH".toCharArray()));
    }
}
