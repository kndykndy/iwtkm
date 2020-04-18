package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p033_SearchRotatedSortedArray.Solution;
import com.kndykndy.leetcode.p033_SearchRotatedSortedArray.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p033_SearchRotatedSortedArrayTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            int[] nums = new int[]{5};
            assertEquals(0, solution.search(nums, 5));
            assertEquals(-1, solution.search(nums, 0));

            nums = new int[]{0, 1};
            assertEquals(0, solution.search(nums, 0));
            assertEquals(1, solution.search(nums, 1));
            assertEquals(-1, solution.search(nums, 5));

            nums = new int[]{1, 0};
            assertEquals(1, solution.search(nums, 0));
            assertEquals(0, solution.search(nums, 1));
            assertEquals(-1, solution.search(nums, 5));

            nums = new int[]{3, 1, 2};
            assertEquals(1, solution.search(nums, 1));
            assertEquals(2, solution.search(nums, 2));
            assertEquals(0, solution.search(nums, 3));
            assertEquals(-1, solution.search(nums, 5));

            nums = new int[]{1, 3, 5};
            assertEquals(-1, solution.search(nums, 2));

            assertEquals(0, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
            assertEquals(6, solution.search(new int[]{1, 2, 4, 5, 6, 7, 0}, 0));
            assertEquals(5, solution.search(new int[]{2, 4, 5, 6, 7, 0, 1}, 0));
            assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
            assertEquals(3, solution.search(new int[]{5, 6, 7, 0, 1, 2, 4}, 0));
            assertEquals(2, solution.search(new int[]{6, 7, 0, 1, 2, 4, 5}, 0));
            assertEquals(1, solution.search(new int[]{7, 0, 1, 2, 4, 5, 6}, 0));
        }
    }
}
