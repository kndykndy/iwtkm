package com.kndykndy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class p202_HappyNumber {

    interface Solution {

        boolean isHappy(int n);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isHappy(int n) {
            final Set<Integer> occurredIterations = new HashSet<>();
            while (n != 1) {
                n = nextHappyIteration(n);
                if (occurredIterations.contains(n)) {
                    return false;
                }
                occurredIterations.add(n);
            }
            return true;
        }

        private int nextHappyIteration(int n) {
            int result = 0;
            while (n != 0) {
                int r = n % 10;
                result += r * r;
                n /= 10;
            }
            return result;
        }
    }
}
