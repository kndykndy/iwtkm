package com.kndykndy.leetcode;

public class p518_CoinChangeII {

    interface Solution {

        /**
         * You are given coins of different denominations and a total amount of money. Write a
         * function to compute the number of combinations that make up that amount. You may assume
         * that you have infinite number of each kind of coin.
         *
         * Example 1:
         * Input: amount = 5, coins = [1, 2, 5]
         * Output: 4
         * Explanation: there are four ways to make up the amount:
         * 5=5
         * 5=2+2+1
         * 5=2+1+1+1
         * 5=1+1+1+1+1
         *
         * Example 2:
         * Input: amount = 3, coins = [2]
         * Output: 0
         * Explanation: the amount of 3 cannot be made up just with coins of 2.
         *
         * Example 3:
         * Input: amount = 10, coins = [10]
         * Output: 1
         */
        int change(int amount, int[] coins);
    }

    public static class Solution1 implements Solution {

        @Override
        public int change(int amount, int[] coins) {
            /*
             * e.g. 1: amount 11, coins [2,5]
             *
             * Starting with the dp array:
             * 1,0,0,0,0,0,0,0,0,0,0,0 -- amount+1 items
             *
             * for coin 2:
             * 1,0,1,0,1,0,1,0,1,0,1,0 -- start with position 2 as coin>=amount
             *
             * then for coin 5:
             * 1,0,1,0,1,1,1,1,1,1,2,1 -- start with position 5 as coin>=amount, last item is answer
             *
             * e.g. 2: amount 5, coins [1,2,5]
             *
             * Starting with the dp array:
             * 1,0,0,0,0,0 -- amount+1 items
             *
             * for coin 1:
             * 1,1,1,1,1,1
             *
             * for coin 2:
             * 1,1,2,2,3,3
             *
             * for coin 5:
             * 1,1,2,2,3,4 -- answer is 4
             */

            final int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j < amount + 1; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            return dp[amount];
        }
    }
}
