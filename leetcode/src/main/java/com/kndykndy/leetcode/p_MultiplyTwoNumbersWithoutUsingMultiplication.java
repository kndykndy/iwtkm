package com.kndykndy.leetcode;

public class p_MultiplyTwoNumbersWithoutUsingMultiplication {

    interface Solution {

        long multiply(int factor1, int factor2);
    }

    public static class Solution1 implements Solution {

        @Override
        public long multiply(int factor1, int factor2) {
            long result = 0;

            int k = 0;

            int sign = (factor1 < 0 ^ factor2 < 0) ? -1 : 1;
            factor1 = Math.abs(factor1);
            factor2 = Math.abs(factor2);

            while (k++ < Math.min(factor1, factor2)) {
                result += Math.max(factor1, factor2);
            }

            return result * sign;
        }
    }
}
