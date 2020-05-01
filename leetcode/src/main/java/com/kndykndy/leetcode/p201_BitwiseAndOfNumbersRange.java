package com.kndykndy.leetcode;

public class p201_BitwiseAndOfNumbersRange {

    interface Solution {

        int rangeBitwiseAnd(int m, int n);
    }

    public static class BruteForceSolution implements Solution {

        public int rangeBitwiseAnd(int m, int n) {
            if (m == 0) {
                return 0;
            }

            int result = m;

            for (int i = m; i >= 0 && i <= n; i++) {
                result &= i;
            }

            return result;
        }
    }

    public static class Solution1 implements Solution {

        @Override
        public int rangeBitwiseAnd(int m, int n) {
            if (m == 0) {
                return 0;
            }

            if ((m & n) == 0) {
                return 0;
            }

            if (Integer.numberOfLeadingZeros(m) == Integer.numberOfLeadingZeros(n)) {
                int result = m;
                for (int i = m + 1; i >= 0 && i <= n; i++) {
                    result &= i;
                }
                return result;
            } else {
                return 0;
            }
        }
    }
}
