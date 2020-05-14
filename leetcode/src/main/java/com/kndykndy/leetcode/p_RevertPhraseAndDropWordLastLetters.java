package com.kndykndy.leetcode;

public class p_RevertPhraseAndDropWordLastLetters {

    interface Solution {

        String revert(String inputStr);
    }

    public static class Solution1 implements Solution {

        @Override
        public String revert(String inputStr) {
            if (inputStr == null || inputStr.length() == 0) {
                return inputStr;
            }

            final StringBuilder resultSb = new StringBuilder();
            StringBuilder wordSb = new StringBuilder();

            for (int i = 0; i < inputStr.length(); i++) {
                if (!Character.isWhitespace(inputStr.charAt(i))) {
                    wordSb.append(inputStr.charAt(i));
                } else {
                    if (wordSb.length() != 0) {
                        wordSb.deleteCharAt(wordSb.length() - 1);
                        resultSb.append(wordSb.reverse());

                        if (i != inputStr.length() - 1) {
                            resultSb.append(inputStr.charAt(i)); // adding whitespace char as well
                        }

                        wordSb = new StringBuilder();
                    }
                }
            }

            if (wordSb.length() != 0) {
                wordSb.deleteCharAt(wordSb.length() - 1);
                resultSb.append(wordSb.reverse());
            }

            return resultSb.toString();
        }
    }
}
