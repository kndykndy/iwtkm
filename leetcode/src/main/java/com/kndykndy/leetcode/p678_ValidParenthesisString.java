package com.kndykndy.leetcode;

public class p678_ValidParenthesisString {

    interface Solution {

        boolean checkValidString(String s);
    }

    public static class OptimalSolution implements Solution {

        @Override
        public boolean checkValidString(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    p--;
                    if (p < 0) {
                        return false;
                    }
                } else {
                    p++;
                }
            }
            if (p == 0) {
                return true;
            }

            p = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    p--;
                    if (p < 0) {
                        return false;
                    }
                } else {
                    p++;
                }
            }

            return true;
        }
    }
}
