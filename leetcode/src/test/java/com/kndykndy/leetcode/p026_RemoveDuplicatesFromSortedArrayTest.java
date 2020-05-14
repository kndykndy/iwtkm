package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p026_RemoveDuplicatesFromSortedArray.Solution;
import com.kndykndy.leetcode.p026_RemoveDuplicatesFromSortedArray.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p026_RemoveDuplicatesFromSortedArrayTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(3, solution.removeDuplicates(new int[]{1, 2, 3}));
            assertEquals(3, solution.removeDuplicates(new int[]{1, 1, 2, 3}));
            assertEquals(3, solution.removeDuplicates(new int[]{1, 1, 1, 2, 3}));
            assertEquals(5, solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        }
    }
}
