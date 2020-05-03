package com.kndykndy.leetcode;

public class p013_RomanToInteger {

    interface Solution {

        int romanToInt(String s);
    }

    public static class Solution1 implements Solution {

        @Override
        public int romanToInt(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int r = 0, i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == 'I') {
                    r += 1;
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                        r += 3; // 4-1, which was already summed
                        i++;
                    }
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                        r += 8;
                        i++;
                    }
                } else if (c == 'V') {
                    r += 5;
                } else if (c == 'X') {
                    r += 10;
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                        r += 30;
                        i++;
                    }
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                        r += 80;
                        i++;
                    }
                } else if (c == 'L') {
                    r += 50;
                } else if (c == 'C') {
                    r += 100;
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                        r += 300;
                        i++;
                    }
                    if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                        r += 800;
                        i++;
                    }
                } else if (c == 'D') {
                    r += 500;
                } else if (c == 'M') {
                    r += 1000;
                }
                i++;
            }
            return r;
        }
    }
}
