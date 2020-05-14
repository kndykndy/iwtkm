package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p027_RemoveElement.Solution;
import com.kndykndy.leetcode.p027_RemoveElement.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p027_RemoveElementTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(4, solution.removeElement(new int[]{3, 2, 2, 2, 3, 2, 3}, 3));
            assertEquals(3, solution.removeElement(new int[]{3, 2, 2, 2, 3, 2, 3}, 2));
            assertEquals(2, solution.removeElement(new int[]{3, 2, 2, 3}, 3));
            assertEquals(5, solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        }
    }
}
