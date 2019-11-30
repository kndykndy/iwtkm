package com.kndykndy.epi.primitivetypes;

public class p41_WordParity {

    interface Solution {

        byte getParity(long word);
    }

    /**
     * Brute force, time O(n) (n bits in word) in all cases, space O(1)
     */
    public static class Solution1 implements Solution {

        @Override
        public byte getParity(long word) {
            byte result = 0;

            while (word != 0) {
                if ((word & 1) == 1) {
                    result ^= 1;
                }
                word >>>= 1;
            }

            return result;
        }
    }

    /**
     * Optimized, time O(n) (n bits in word), space O(1)
     */
    public static class Solution2 implements Solution {

        @Override
        public byte getParity(long word) {
            byte result = 0;

            while (word != 0) {
                word &= (word - 1);
                result ^= 1;
            }

            return result;
        }
    }
}
