package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p151_ReverseWordsString.BruteForceSolution;
import com.kndykndy.leetcode.p151_ReverseWordsString.Solution;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p151_ReverseWordsStringTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new BruteForceSolution());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
            assertEquals("world! hello", solution.reverseWords("  hello world!  "));
            assertEquals("example good a", solution.reverseWords("a good   example"));
        }
    }
}
