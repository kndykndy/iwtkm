package com.kndykndy.leetcode;

public class p191_Number1Bits {

    interface Solution {

        int hammingWeight(int n);
    }

    public static class Solution1 implements Solution {

        @Override
        public int hammingWeight(int n) {
            int result = 0;

            while (n != 0) {
                n &= (n - 1);
                result++;
            }

            return result;
        }
    }
}
