package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.Utils;

public class p44_WildcardMatching {

    interface Solution {

        boolean isMatch(String s, String p);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }

            final int slen = s.length(), plen = p.length();
            char pchar;

            final boolean[][] m = new boolean[slen + 1][plen + 1];
            m[0][0] = true;
            int k = 0;
            while (k < plen && p.charAt(k) == '*') {
                m[0][k++ + 1] = true;
            }

            for (int i = 1; i < slen + 1; i++) {
                for (int j = 1; j < plen + 1; j++) {
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
            Utils.printBooleanMatrix(m);

            return m[slen][plen];
        }
    }
}
