package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p10000_CountingElements.Solution;
import com.kndykndy.leetcode.p10000_CountingElements.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p10000_CountingElementsTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(2, solution.countElements(new int[]{1, 2, 3}));
            assertEquals(0, solution.countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
            assertEquals(3, solution.countElements(new int[]{1, 3, 2, 3, 5, 0}));
            assertEquals(2, solution.countElements(new int[]{1, 1, 2, 2}));
        }
    }
}
