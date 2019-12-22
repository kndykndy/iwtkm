package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p9_PalindromeNumber.Solution;
import com.kndykndy.leetcode.p9_PalindromeNumber.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p9_PalindromeNumberTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertFalse(solution.isPalindrome(-1));
            assertFalse(solution.isPalindrome(-111));
            assertFalse(solution.isPalindrome(10));
            assertFalse(solution.isPalindrome(122));

            assertTrue(solution.isPalindrome(0));
            assertTrue(solution.isPalindrome(11));
            assertTrue(solution.isPalindrome(222));
            assertTrue(solution.isPalindrome(3113));
            assertTrue(solution.isPalindrome(12321));
            assertTrue(solution.isPalindrome(999999999));
            assertTrue(solution.isPalindrome(2147447412));
        }
    }
}
