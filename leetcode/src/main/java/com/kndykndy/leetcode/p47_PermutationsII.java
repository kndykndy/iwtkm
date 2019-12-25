package com.kndykndy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p47_PermutationsII {

    interface Solution {

        List<List<Integer>> permuteUnique(int[] nums);
    }

    public static class Solution1 implements Solution {

        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
            final Set<List<Integer>> result = new HashSet<>();

            permuteImpl(0, nums, result);

            return new ArrayList<>(result);
        }

        private void permuteImpl(int startIdx, int[] nums, Set<List<Integer>> result) {
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

    public static class Solution2 implements Solution {

        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
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
                if (i != startIdx && nums[i] == nums[startIdx]) {
                    continue;
                }
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
        new Solution2().permuteUnique(new int[]{1, 1, 2})
            .forEach(it -> System.out.println(
                it.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","))));
    }
}
