package com.kndykndy.leetcode;

public class p121_BestTimeBuySellStock {

    interface Solution {

        int maxProfit(int[] prices);
    }

    /**
     * Best, time O(n), space O(1)
     */
    public static class Solution1 implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, maxProfit = 0;

            for (int price : prices) {
                if (price < min) {
                    min = price;
                }
                if (price > min) {
                    maxProfit = Math.max(maxProfit, price - min);
                }

            }
            return maxProfit;
        }
    }
}
