package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.kndykndy.leetcode.p344_ReverseString.Solution;
import com.kndykndy.leetcode.p344_ReverseString.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p344_ReverseStringTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        char[] s;

        for (Solution solution : solutions) {
            s = "Hello!".toCharArray();
            solution.reverseString(s);
            assertArrayEquals("!olleH".toCharArray(), s);
        }
    }
}
