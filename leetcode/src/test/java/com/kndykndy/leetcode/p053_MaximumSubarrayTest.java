package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p053_MaximumSubarray.Solution;
import com.kndykndy.leetcode.p053_MaximumSubarray.Solution1;
import com.kndykndy.leetcode.p053_MaximumSubarray.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p053_MaximumSubarrayTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
            assertEquals(21, solution.maxSubArray(new int[]{2, 3, 4, 5, 7}));
            assertEquals(1, solution.maxSubArray(new int[]{-2, 1}));
            assertEquals(0, solution.maxSubArray(new int[]{-1, 0, -2}));
            assertEquals(5, solution.maxSubArray(new int[]{2, 0, 3, -2}));
        }
    }
}
