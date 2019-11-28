package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p153_FindMinimumRotatedSortedArray.Solution;
import com.kndykndy.leetcode.p153_FindMinimumRotatedSortedArray.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p153_FindMinimumRotatedSortedArrayTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.findMin(new int[]{0, 1}));
            assertEquals(1, solution.findMin(new int[]{2, 1}));
            assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
            assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
            assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
        }
    }
}
