package com.kndykndy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class p020_ValidParenthesis {

    interface Solution {

        boolean isValid(String s);
    }

    public static class Solution1 implements Solution {

        @Override
        public boolean isValid(String s) {
            final Deque<Character> d = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    d.addFirst(c);
                } else {
                    if (d.isEmpty()) {
                        return false;
                    }
                    if (c == ')') {
                        if (d.peekFirst() == '(') {
                            d.removeFirst();
                        } else {
                            return false;
                        }
                    } else if (c == '}') {
                        if (d.peekFirst() == '{') {
                            d.removeFirst();
                        } else {
                            return false;
                        }
                    } else if (c == ']') {
                        if (d.peekFirst() == '[') {
                            d.removeFirst();
                        } else {
                            return false;
                        }
                    }
                }
            }
            return d.isEmpty();
        }
    }
}
