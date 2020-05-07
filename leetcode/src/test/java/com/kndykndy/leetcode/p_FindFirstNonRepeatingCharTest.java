package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.kndykndy.leetcode.p_FindFirstNonRepeatingChar.Solution;
import com.kndykndy.leetcode.p_FindFirstNonRepeatingChar.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_FindFirstNonRepeatingCharTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertNull(solution.findFirstNonRepeatingChar(null));
            assertNull(solution.findFirstNonRepeatingChar(""));
            assertEquals('a', solution.findFirstNonRepeatingChar("abc"));
            assertEquals('e', solution.findFirstNonRepeatingChar("aabbccddefg"));
            assertNull(solution.findFirstNonRepeatingChar("aabbccdd"));
        }
    }
}
