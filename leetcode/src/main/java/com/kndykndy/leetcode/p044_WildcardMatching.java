package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.Utils;

public class p044_WildcardMatching {

    interface Solution {

        boolean isMatch(String s, String p);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }

            final int sLen = s.length(), pLen = p.length();
            char pchar;

            final boolean[][] m = new boolean[sLen + 1][pLen + 1];
            m[0][0] = true;
            int k = 0;
            while (k < pLen && p.charAt(k) == '*') {
                m[0][k++ + 1] = true;
            }

            for (int i = 1; i < sLen + 1; i++) {
                for (int j = 1; j < pLen + 1; j++) {
                    pchar = p.charAt(j - 1);
                    if (pchar == s.charAt(i - 1) || pchar == '?') {
                        m[i][j] = m[i - 1][j - 1];
                    } else if (pchar == '*') {
                        m[i][j] = m[i - 1][j] || m[i][j - 1];
                    } else {
                        m[i][j] = false;
                    }
                }
            }
            System.out.println("s: \"" + s + "\", p: \"" + p + "\"");
            Utils.printBooleanMatrix(m);

            return m[sLen][pLen];
        }
    }
}
