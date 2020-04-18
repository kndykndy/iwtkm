package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p018_FourSum.Solution;
import com.kndykndy.leetcode.p018_FourSum.Solution1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p018_FourSumTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            final List<List<Integer>> result = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
            assertEquals(3, result.size());
            assertTrue(result.contains(Arrays.asList(-2, 0, 0, 2)));
            assertTrue(result.contains(Arrays.asList(-2, -1, 1, 2)));
            assertTrue(result.contains(Arrays.asList(-1, 0, 0, 1)));
        }
    }
}
