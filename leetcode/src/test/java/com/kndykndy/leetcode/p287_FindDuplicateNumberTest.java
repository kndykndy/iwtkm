package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p287_FindDuplicateNumber.Solution;
import com.kndykndy.leetcode.p287_FindDuplicateNumber.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p287_FindDuplicateNumberTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(1, solution.findDuplicate(new int[]{1, 1}));
            assertEquals(1, solution.findDuplicate(new int[]{1, 1, 2}));
            assertEquals(1, solution.findDuplicate(new int[]{1, 1, 1, 1, 1}));
            assertEquals(2, solution.findDuplicate(new int[]{2, 2, 2, 2, 2}));
            assertEquals(1, solution.findDuplicate(new int[]{1, 2, 3, 4, 1}));
            assertEquals(2, solution.findDuplicate(new int[]{1, 2, 3, 4, 2}));
            assertEquals(3, solution.findDuplicate(new int[]{1, 2, 3, 4, 3}));
            assertEquals(4, solution.findDuplicate(new int[]{1, 2, 3, 4, 4}));
            assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
            assertEquals(2, solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
            assertEquals(4, solution.findDuplicate(new int[]{1, 4, 4, 2, 4}));
            assertEquals(2, solution.findDuplicate(new int[]{3, 2, 2, 2, 4}));
        }
    }
}
