package com.kndykndy.leetcode;

public class p122_BestTimeToBuyAndSellStockII {

    interface Solution {

        int maxProfit(int[] prices);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0;
            }

            final int len = prices.length;
            final int[] profit = new int[len];

            int max = 0;
            for (int i = len - 2; i >= 0; i--) {
                if (prices[i] >= prices[i + 1]) {
                    profit[i] = profit[i + 1];
                    continue;
                }

                max = Math.max(max, maxProfitImpl(prices, profit, i));
            }

            return max;
        }

        private int maxProfitImpl(int[] prices, int[] profit, int sf) {

            int len = prices.length;

            if (sf > len - 1) {
                return 0;
            }
            if (profit[sf] != 0) {
                return profit[sf];
            }

            int max = 0;
            for (int i = sf; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (prices[j] > prices[i]) {
                        profit[i] = Math.max(
                            profit[i],
                            prices[j] - prices[i] + maxProfitImpl(prices, profit, j + 1));
                        if (profit[i] > max) {
                            max = profit[i];
                        }
                    }
                }
            }

            profit[sf] = Math.max(profit[sf], max);

            return max;
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
    }
}
