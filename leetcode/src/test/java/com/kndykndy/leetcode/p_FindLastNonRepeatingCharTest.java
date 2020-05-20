package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p_FindLastNonRepeatingChar.Solution;
import com.kndykndy.leetcode.p_FindLastNonRepeatingChar.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p_FindLastNonRepeatingCharTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(0, solution.getLastNonRepeated(null));
            assertEquals(0, solution.getLastNonRepeated(""));
            assertEquals('c', solution.getLastNonRepeated("abc"));
            assertEquals('b', solution.getLastNonRepeated("abcc"));
            assertEquals('a', solution.getLastNonRepeated("abbcc"));
            assertEquals(0, solution.getLastNonRepeated("aabbcc"));
        }
    }
}
