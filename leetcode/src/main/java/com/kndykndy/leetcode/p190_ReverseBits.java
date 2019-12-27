package com.kndykndy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class p190_ReverseBits {

    interface Solution {

        int reverseBits(int n);
    }

    public static class BruteForceSolution implements Solution {

        @Override
        public int reverseBits(int n) {
            int result = 0;

            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) >= 1) {
                    result |= (1 << 31 - i);
                }
            }
            if (n < 0) {
                result++;
            }

            return result;
        }
    }

    public static class Solution2 implements Solution {

        private static final Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            for (int i = 0; i < 32; i++) {
                put(1 << i, 1 << (31 - i));
            }
        }};

        @Override
        public int reverseBits(int n) {
            int result = 0;

            int nn;
            while (n != 0) {
                nn = n & ~(n - 1);
                n &= ~nn;
                result |= map.get(nn);
            }

            return result;
        }
    }
}
