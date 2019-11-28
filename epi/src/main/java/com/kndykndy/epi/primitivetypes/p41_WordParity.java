package com.kndykndy.epi.primitivetypes;

public class p41_WordParity {

    interface Solution {

        byte getParity(long word);
    }

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
}
