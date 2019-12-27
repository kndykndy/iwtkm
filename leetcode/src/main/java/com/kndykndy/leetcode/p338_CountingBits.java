package com.kndykndy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class p338_CountingBits {

    interface Solution {

        int[] countBits(int num);
    }

    public static class Solution1 implements Solution {

        private static final Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            for (int i = 0; i < 256; i++) {
                put(i, countBits((byte) i));
            }
        }};

        private static int countBits(byte x) {
            int result = 0;

            for (int i = 0; i < 8; i++) {
                if ((x & (1 << i)) >= 1) {
                    result++;
                }
            }

            return result;
        }

        @Override
        public int[] countBits(int num) {
            final int[] result = new int[num + 1];

            for (int i = 0; i <= num; i++) {
                result[i] = map.get(i & 0xFF) +
                    map.get((i >> 8) & 0xFF) +
                    map.get((i >> 16) & 0xFF) +
                    map.get((i >> 24) & 0xFF);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        new Solution1().countBits(2);
    }
}
