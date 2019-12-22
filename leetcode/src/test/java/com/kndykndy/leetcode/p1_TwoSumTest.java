package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.kndykndy.leetcode.p1_TwoSum.BruteForceSolution;
import com.kndykndy.leetcode.p1_TwoSum.Solution;
import com.kndykndy.leetcode.p1_TwoSum.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p1_TwoSumTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertNull(solution.twoSum(null, 0));

            assertNull(solution.twoSum(new int[]{0}, 0));

            assertNull(solution.twoSum(new int[]{1, 2}, 2));
        }
    }

    @Test
    void test2() {
        for (Solution solution : solutions) {
            assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{1, 2}, 3));

            assertArrayEquals(new int[]{3, 4}, solution.twoSum(new int[]{1, 2, 3, 4, 5}, 9));

            assertArrayEquals(new int[]{0, 4}, solution.twoSum(new int[]{4, 2, 3, 1, 5}, 9));

            assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
        }
    }
}
