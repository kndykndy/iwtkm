package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p560_SubarraySumEqualsK.BruteForceSolution;
import com.kndykndy.leetcode.p560_SubarraySumEqualsK.Solution;
import com.kndykndy.leetcode.p560_SubarraySumEqualsK.Solution1;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p560_SubarraySumEqualsKTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new BruteForceSolution(), new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.subarraySum(new int[]{1, 1}, 5));
            assertEquals(1, solution.subarraySum(new int[]{1, 1, 1}, 3));
            assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
            assertEquals(2, solution.subarraySum(new int[]{1, 1, 1, 1}, 3));
            assertEquals(2, solution.subarraySum(new int[]{1, 2, 3}, 3));
            assertEquals(55, solution.subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
            assertEquals(1, solution.subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100));
        }
    }
}
