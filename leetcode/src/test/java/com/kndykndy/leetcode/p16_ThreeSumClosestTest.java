package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p16_ThreeSumClosest.Solution;
import com.kndykndy.leetcode.p16_ThreeSumClosest.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p16_ThreeSumClosestTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.threeSumClosest(new int[]{0, 0, 0}, 1));
            assertEquals(0, solution.threeSumClosest(new int[]{0, 0, 0, 0}, 1));
            assertEquals(3, solution.threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 3));

            assertEquals(2, solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
            assertEquals(2, solution.threeSumClosest(new int[]{-4, -1, 1, 2}, 5));
            assertEquals(4, solution.threeSumClosest(new int[]{-4, -1, 1, 2, 3}, 5));
            assertEquals(1, solution.threeSumClosest(new int[]{-4, -1, 1, 2, 3}, 1));

            assertEquals(-1, solution.threeSumClosest(new int[]{-4, -1, 1, 2, 3}, -1));
            assertEquals(-4, solution.threeSumClosest(new int[]{-4, -1, 1, 2, 3}, -4));
            assertEquals(-4, solution.threeSumClosest(new int[]{-4, -1, 1, 2, 3}, -5));
        }
    }
}
