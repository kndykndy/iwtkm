package com.kndykndy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p46_Permutations {

    interface Solution {

        List<List<Integer>> permute(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            final List<List<Integer>> result = new ArrayList<>();

            permuteImpl(0, nums, result);

            return result;
        }

        private void permuteImpl(int startIdx, int[] nums, List<List<Integer>> result) {
            if (startIdx == nums.length - 1) {
                result.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
                return;
            }

            for (int i = startIdx; i < nums.length; i++) {
                swap(nums, startIdx, i);
                permuteImpl(startIdx + 1, nums, result);
                swap(nums, startIdx, i);
            }
        }

        private static void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        new Solution1().permute(new int[]{1, 2, 3})
            .forEach(it -> System.out.println(
                it.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","))));
    }
}
