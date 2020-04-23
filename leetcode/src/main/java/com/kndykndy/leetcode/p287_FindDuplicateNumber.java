package com.kndykndy.leetcode;

public class p287_FindDuplicateNumber {

    interface Solution {

        int findDuplicate(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public int findDuplicate(int[] nums) {
            int fullproduct = 1, onecnt = 0;
            for (int num : nums) {
                fullproduct *= num;
                if (num == 1) {
                    onecnt++;
                }
            }
            if (fullproduct == 1 || onecnt > 1) {
                return 1;
            }

            int rp = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                rp *= i + 1;
            }
            System.out.println("fp:" + fullproduct + " rp:" + rp + " 1cnt:" + onecnt);
            if (fullproduct % rp == 0) {
                return fullproduct / rp;
            }

            for (int num : nums) {
                if (rp % num == 0) {
                    rp /= num;
                } else {
                    return num;
                }
            }

            return 0;
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public int findDuplicate(int[] nums) {
            int fullproduct = 1, onecnt = 0;
            for (int num : nums) {
                fullproduct *= num;
                if (num == 1) {
                    onecnt++;
                }
            }
            if (fullproduct == 1 || onecnt > 1) {
                return 1;
            }

            int rp=0; // todo
            for (int num : nums) {
                if (fullproduct % (num*num) == 0) {
                    rp /= num;
                } else {
                    return num;
                }
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findDuplicate(new int[]{1, 1}) + " should be 1");
        System.out.println(new Solution1().findDuplicate(new int[]{1, 1, 2}) + " should be 1");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1, 1, 1, 1, 1}) + " should be 1");
        System.out
            .println(new Solution1().findDuplicate(new int[]{2, 2, 2, 2, 2}) + " should be 2");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1, 2, 3, 4, 1}) + " should be 1");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1, 2, 3, 4, 2}) + " should be 2");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1, 2, 3, 4, 3}) + " should be 3");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1, 2, 3, 4, 4}) + " should be 4");
        System.out
            .println(new Solution1().findDuplicate(new int[]{3,1,3,4,2}) + " should be 3");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1,3,4,2,2}) + " should be 2");
        System.out
            .println(new Solution1().findDuplicate(new int[]{1,4,4,2,4}) + " should be 4");
        System.out
            .println(new Solution1().findDuplicate(new int[]{3,2,2,2,4}) + " should be 2");
    }
}
