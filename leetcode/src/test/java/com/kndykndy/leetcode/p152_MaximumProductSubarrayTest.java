package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p152_MaximumProductSubarray.Solution;
import com.kndykndy.leetcode.p152_MaximumProductSubarray.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p152_MaximumProductSubarrayTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
            assertEquals(8, solution.maxProduct(new int[]{2, 3, -2, 4, 2}));
            assertEquals(56, solution.maxProduct(new int[]{-2, 7, -4}));
            assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));
            assertEquals(24, solution.maxProduct(new int[]{2, -5, -2, -4, 3}));
//            assertEquals(, solution.maxProduct(new int[]{}));
        }
    }
}
