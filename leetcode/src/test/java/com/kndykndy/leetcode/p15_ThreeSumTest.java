package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p15_ThreeSum.Solution;
import com.kndykndy.leetcode.p15_ThreeSum.Solution1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p15_ThreeSumTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            List<List<Integer>> result;

            result = solution.threeSum(new int[]{0, 0, 0});
            assertEquals(1, result.size());
            assertTrue(result.contains(Arrays.asList(0, 0, 0)));

            result = solution.threeSum(new int[]{0, 0, 0, 0});
            assertEquals(1, result.size());
            assertTrue(result.contains(Arrays.asList(0, 0, 0)));

            result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
            assertEquals(2, result.size());
            assertTrue(result.contains(Arrays.asList(-1, -1, 2)));
            assertTrue(result.contains(Arrays.asList(-1, 0, 1)));

            result = solution.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
            assertEquals(6, result.size());
            assertTrue(result.contains(Arrays.asList(-4, -2, 6)));
            assertTrue(result.contains(Arrays.asList(-2, -2, 4)));
            assertTrue(result.contains(Arrays.asList(-4, 2, 2)));
            assertTrue(result.contains(Arrays.asList(-4, 1, 3)));
            assertTrue(result.contains(Arrays.asList(-4, 0, 4)));
            assertTrue(result.contains(Arrays.asList(-2, 0, 2)));

            result = solution.threeSum(new int[]{3, 0, -2, -1, 1, 2});
            assertEquals(3, result.size());
            assertTrue(result.contains(Arrays.asList(-2, -1, 3)));
            assertTrue(result.contains(Arrays.asList(-2, 0, 2)));
            assertTrue(result.contains(Arrays.asList(-1, 0, 1)));

            result = solution.threeSum(new int[]{-2, 0, 1, 1, 2});
            assertEquals(2, result.size());
            assertTrue(result.contains(Arrays.asList(-2, 1, 1)));
            assertTrue(result.contains(Arrays.asList(-2, 0, 2)));

            result = solution.threeSum(
                new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
            assertEquals(6, result.size());
            assertTrue(result.contains(Arrays.asList(-2, -2, 4)));
            assertTrue(result.contains(Arrays.asList(-5, 1, 4)));
            assertTrue(result.contains(Arrays.asList(-4, 1, 3)));
            assertTrue(result.contains(Arrays.asList(-2, 1, 1)));
            assertTrue(result.contains(Arrays.asList(-4, 0, 4)));
            assertTrue(result.contains(Arrays.asList(0, 0, 0)));
        }
    }
}
