package com.kndykndy.leetcode;

public class p011_ContainerWithMostWater {

    interface Solution {

        int maxArea(int[] height);
    }

    /**
     * Time O(n), space O(1).
     */
    public static class Solution1 implements Solution {

        @Override
        public int maxArea(int[] height) {
            int maxSquare = 0;
            int i = 0, j = height.length - 1;
            while (i < j) {
                maxSquare = Math.max(maxSquare, (j - i) * Math.min(height[i], height[j]));
                if (height[i] < height[j]) {
                    i++;
                } else if (height[j] < height[i]) {
                    j--;
                } else {
                    if (height[i + 1] < height[j - 1]) {
                        j--;
                    } else if (height[j - 1] < height[i + 1]) {
                        i++;
                    } else {
                        i++;
                        j--;
                    }
                }
            }
            return maxSquare;
        }
    }
}
