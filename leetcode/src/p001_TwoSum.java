import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode #1 ~ Two Sum https://leetcode.com/problems/two-sum/
 *
 * 16 Mar 2018
 *
 * Problem statement: Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have exactly one solution, and
 * you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9.
 * As nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * Solutions:
 * 1. Naive combinations
 * 2. Kind of selection sort -- pick up item, then choose a complement for it
 * 3. Pick up item, look if has complement in a specific hash table, if not, add.
 */
public class p001_TwoSum {

    interface Solution {

        int[] twoSum(int[] nums, int target);

    }

    @SuppressWarnings("WeakerAccess")
    private static class SolutionImpl1 implements Solution {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 1) {
                return null;
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }

            return null;
        }

    }

    @SuppressWarnings("WeakerAccess")
    private static class SolutionImpl2 implements Solution {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 1) {
                return null;
            }

            // key is an int, value is its index within a nums array
            final Map<Integer, Integer> caughtInts = new HashMap<>();

            Integer tempInt;
            for (int i = 0; i < nums.length; i++) {
                tempInt = caughtInts.get(target - nums[i]);
                if (tempInt != null) {
                    return new int[]{tempInt, i};
                } else {
                    caughtInts.put(nums[i], i);
                }
            }

            return null;
        }

    }

    public static void main(String[] args) {
        runTestSet(new SolutionImpl1());
        runTestSet(new SolutionImpl2());
    }

    private static void runTestSet(Solution solution) {
        int[] indexes;

        indexes = solution.twoSum(null, 0);
        assert indexes == null;

        indexes = solution.twoSum(new int[]{0}, 0);
        assert indexes == null;

        indexes = solution.twoSum(new int[]{1, 2}, 2);
        assert indexes == null;

        indexes = solution.twoSum(new int[]{1, 2}, 3);
        assert indexes != null;
        assert indexes.length == 2;
        assert indexes[0] == 0 && indexes[1] == 1;

        indexes = solution.twoSum(new int[]{1, 2, 3, 4, 5}, 9);
        assert indexes != null;
        assert indexes.length == 2;
        assert indexes[0] == 3 && indexes[1] == 4;

        indexes = solution.twoSum(new int[]{4, 2, 3, 1, 5}, 9);
        assert indexes != null;
        assert indexes.length == 2;
        assert indexes[0] == 0 && indexes[1] == 4;

        indexes = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assert indexes != null;
        assert indexes.length == 2;
        assert indexes[0] == 0 && indexes[1] == 1;
    }

}
