package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p004_FindMedianSortedArrays.Solution;
import com.kndykndy.leetcode.p004_FindMedianSortedArrays.BruteForceSolution;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p004_FindMedianSortedArraysTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new BruteForceSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
            assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
            assertEquals(1.0, solution.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}));
        }
    }
}
