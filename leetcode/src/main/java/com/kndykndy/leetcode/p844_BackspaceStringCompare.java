package com.kndykndy.leetcode;

public class p844_BackspaceStringCompare {

    interface Solution {

        boolean backspaceCompare(String S, String T);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean backspaceCompare(String S, String T) {
            int p1 = S.length() - 1, p2 = T.length() - 1, bc1 = 0, bc2 = 0;
            char c1, c2;

            while (true) {

                c1 = p1 >= 0 ? S.charAt(p1) : 0;
                c2 = p2 >= 0 ? T.charAt(p2) : 0;

                if (c1 != '#' && c2 != '#') {
                    if (c1 == c2) {
                        p1--;
                        p2--;
                    } else {
                        return false;
                    }
                } else {
                    if (c1 == '#') {
                        while (p1 >= 0 && S.charAt(p1) == '#') {
                            bc1++;
                            p1--;
                        }
                        while (p1 >= 0 && S.charAt(p1) != '#' && bc1 != 0) {
                            bc1--;
                            p1--;
                        }
                    }

                    if (c2 == '#') {
                        while (p2 >= 0 && T.charAt(p2) == '#') {
                            bc2++;
                            p2--;
                        }
                        while (p2 >= 0 && T.charAt(p2) != '#' && bc2 != 0) {
                            bc2--;
                            p2--;
                        }
                    }
                }

                if (p1 == p2 && p1 < 0) {
                    return true;
                }
            }
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public boolean backspaceCompare(String S, String T) {
            final String s = bsImpl(S);
            final String t = bsImpl(T);
//        System.out.println(String.format("\"%s\" ~ \"%s\"", s, t));
            return s.equals(t);
        }

        private String bsImpl(String str) {
            final char[] ch = new char[str.length()];

            int p = 0, len = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '#') {
                    ch[p++] = str.charAt(i);
                    len++;
                } else {
                    p--;
                    len--;
                    if (p < 0) {
                        p = 0;
                        len = 0;
                    }
                }
            }

            return (len > 0) ? new String(ch, 0, len) : "";
        }
    }
}
