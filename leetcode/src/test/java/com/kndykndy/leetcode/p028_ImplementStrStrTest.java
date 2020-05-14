package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p028_ImplementStrStr.Solution;
import com.kndykndy.leetcode.p028_ImplementStrStr.Solution1;
import com.kndykndy.leetcode.p028_ImplementStrStr.Solution2;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p028_ImplementStrStrTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Arrays.asList(new Solution1(), new Solution2());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(-1, solution.strStr("", "a"));
            assertEquals(0, solution.strStr("", ""));
            assertEquals(0, solution.strStr("a", ""));
            assertEquals(0, solution.strStr("a", "a"));

            assertEquals(9, solution.strStr("mississippi", "pi"));
            assertEquals(1, solution.strStr("mississippi", "issi"));
            assertEquals(4, solution.strStr("mississippi", "issip"));
            assertEquals(-1, solution.strStr("mississippi", "issipi"));
        }
    }
}
