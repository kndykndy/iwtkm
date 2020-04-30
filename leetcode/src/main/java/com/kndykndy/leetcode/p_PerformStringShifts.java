package com.kndykndy.leetcode;

public class p_PerformStringShifts {

    interface Solution {

        /**
         * 1 <= s.length <= 100
         * s only contains lower case English letters.
         * 1 <= shift.length <= 100
         * shift[i].length == 2
         * 0 <= shift[i][0] <= 1
         * 0 <= shift[i][1] <= 100
         */
        String stringShift(String s, int[][] shift);
    }

    public static class Solution1 implements Solution {

        @Override
        public String stringShift(String s, int[][] shift) {
            if (s.length() <= 1) {
                return s;
            }

            int length = s.length();

            int totalMove = 0;
            for (int[] cshift : shift) {
                totalMove += cshift[0] == 1 ? cshift[1] : -cshift[1];
            }

            if (totalMove == 0) {
                return s;
            }
            totalMove %= length;
            if (totalMove < 0) {
                totalMove = length + totalMove;
            }

            char[] c = new char[length];

            for (int i = 0; i < length; i++) {
                if (totalMove + i < length) {
                    c[totalMove + i] = s.charAt(i);
                } else {
                    c[i - (length - totalMove)] = s.charAt(i);
                }
            }

            return new String(c);
        }
    }
}
