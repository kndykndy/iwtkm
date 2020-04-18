package com.kndykndy.leetcode;

public class p541_ReverseStringII {

    interface Solution {

        String reverseStr(String s, int k);
    }

    public static class Solution1 implements Solution {

        @Override
        public String reverseStr(String s, int k) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            final int sLen = s.length();
            final char[] reverseChars = new char[sLen];
            int kk = 0;
            while (kk < sLen) {
                if ((kk / k) % 2 == 0) {
                    for (int i = (kk + k - 1 < sLen ? kk + k - 1 : sLen - 1), j = kk; i >= kk;
                        i--, j++) {
                        reverseChars[j] = s.charAt(i);
                    }
                    kk += k;
                } else {
                    reverseChars[kk] = s.charAt(kk);
                    kk++;
                }
            }

            return new String(reverseChars);
        }
    }
}
