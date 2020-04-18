package com.kndykndy.leetcode;

public class p070_ClimbingStairs {

    interface Solution {

        int climbStairs(int n);
    }

    public static class Solution1 implements Solution {

        @Override
        public int climbStairs(int n) {
            return fib(n + 1);
        }

        private int fib(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }

            int n1 = 1, n2 = 1, nn = 3, t;
            while (nn++ <= n) {
                t = n1;
                n1 = n2;
                n2 = t + n1;
            }
            return n2;
        }
    }
}
