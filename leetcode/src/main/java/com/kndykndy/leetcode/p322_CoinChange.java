package com.kndykndy.leetcode;

import static com.kndykndy.leetcode.util.Utils.printIntArray;

import java.util.Arrays;

public class p322_CoinChange {

    interface Solution {

        int coinChange(int[] coins, int amount);
    }

    public static class Solution1 implements Solution {

        @Override
        public int coinChange(int[] coins, int amount) {
            /*
             * coins [2,5] amount 11
             *
             * [0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12] initial
             * [0, 12, 1, 12, 2, 12, 3, 12, 4, 12, 5, 12] for coin 2
             * [0, 12, 1, 12, 2, 1, 3, 2, 4, 3, 2, 4] for coin 5
             */

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            printIntArray(dp, "initial");

            for (int coin : coins) {
                for (int currentAmount = coin; currentAmount <= amount; currentAmount++) {
                    dp[currentAmount] = Math.min(
                        dp[currentAmount],
                        dp[currentAmount - coin] + 1);
                }
                printIntArray(dp, "for coin " + coin);
            }

            return dp[amount] <= amount ? dp[amount] : -1;
        }
    }
}
