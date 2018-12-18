import java.util.Arrays;

/**
 * Leetcode #16 ~ 3Sum Closest
 * https://leetcode.com/problems/3sum-closest
 *
 * 26 Mar 2018
 *
 * Problem statement:
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given
 * number, target. Return the sum of the three integers. You may assume that each input would have
 * exactly one solution.
 *
 * Examples:
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class p016_ThreeSumClosest {

    @SuppressWarnings("WeakerAccess")
    private static final class Solution {

        int wrapperForThreeSumClosest(int[] nums, int target) {
            System.out.print("Case for " + Arrays.toString(nums) + ", target " + target);
            Arrays.sort(nums);
            System.out.print(", sorted " + Arrays.toString(nums) + "\n");

            final long l = System.currentTimeMillis();

            final int result = threeSumClosest(nums, target);

            System.out.println("Result: " + result + ""
                + ", took " + (System.currentTimeMillis() - l) + "ms\n");

            return result;
        }

        @SuppressWarnings("unused")
        private void debugPrint(String p, int[] n, int i1, int i2, int i3) {
            System.out.println(p
                + " " + i1 + " " + i2 + " " + i3
                + ": " + n[i1] + " " + n[i2] + " " + n[i3]
                + ", sum: " + (n[i1] + n[i2] + n[i3]));
        }

        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }

            Arrays.sort(nums);

            Integer result = null;

            int i1 = 0, i2, i3;
            int s;

            while (i1 < nums.length - 2) {
                i2 = i1 + 1;
                i3 = nums.length - 1;

                while (i2 < i3) {
                    s = nums[i1] + nums[i2] + nums[i3];

                    if (s != target) {
                        if (s < target) {
                            i2++;
                        } else {
                            i3--;
                        }

                        if (result == null || Math.abs(target - result) > Math.abs(target - s)) {
                            result = s;
                        }
                    } else {
                        return target;
                    }
                }

                i1++;
            }

            return result != null ? result : 0;
        }

    }

    public static void main(String[] args) {
        assert new Solution().wrapperForThreeSumClosest(new int[]{0, 0, 0}, 1) == 0;
        assert new Solution().wrapperForThreeSumClosest(new int[]{0, 0, 0, 0}, 1) == 0;
        assert new Solution().wrapperForThreeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 3) == 3;

        assert new Solution().wrapperForThreeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2;
        assert new Solution().wrapperForThreeSumClosest(new int[]{-4, -1, 1, 2}, 5) == 2;
        assert new Solution().wrapperForThreeSumClosest(new int[]{-4, -1, 1, 2, 3}, 5) == 4;
        assert new Solution().wrapperForThreeSumClosest(new int[]{-4, -1, 1, 2, 3}, 1) == 1;

        assert new Solution().wrapperForThreeSumClosest(new int[]{-4, -1, 1, 2, 3}, -1) == -1;
        assert new Solution().wrapperForThreeSumClosest(new int[]{-4, -1, 1, 2, 3}, -4) == -4;
        assert new Solution().wrapperForThreeSumClosest(new int[]{-4, -1, 1, 2, 3}, -5) == -4;
    }

}
