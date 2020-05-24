package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class p822_CardFlippingGame {

    interface Solution {

        /**
         * 1 <= fronts.length == backs.length <= 1000
         * 1 <= fronts[i] <= 2000
         * 1 <= backs[i] <= 2000
         */
        int flipgame(int[] fronts, int[] backs);
    }

    public static class Solution1 implements Solution {

        @Override
        public int flipgame(int[] fronts, int[] backs) {
            final Set<Integer> same = new HashSet<>();

            for (int i = 0; i < fronts.length; i++) {
                if (fronts[i] == backs[i]) {
                    same.add(fronts[i]);
                }
            }

            int ans = 9999;

            for (int i = 0; i < fronts.length; i++) {
                if (!same.contains(fronts[i])) {
                    ans = Math.min(ans, fronts[i]);
                }
                if (!same.contains(backs[i])) {
                    ans = Math.min(ans, backs[i]);
                }
            }

            return ans % 9999;
        }
    }
}
