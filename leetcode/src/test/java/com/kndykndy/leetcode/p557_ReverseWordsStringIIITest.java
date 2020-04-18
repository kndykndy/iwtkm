package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p557_ReverseWordsStringIII.Solution;
import com.kndykndy.leetcode.p557_ReverseWordsStringIII.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p557_ReverseWordsStringIIITest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertEquals(
                "s'teL ekat edoCteeL tsetnoc",
                solution.reverseWords("Let's take LeetCode contest"));
        }
    }
}
