package com.kndykndy.leetcode;

import com.kndykndy.leetcode.p010_RegularExpressionMatching.Solution;
import com.kndykndy.leetcode.p010_RegularExpressionMatching.Solution1;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p010_RegularExpressionMatchingTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
           /*
            * isMatch("aa","a") → false
            * isMatch("aa","aa") → true
            * isMatch("aaa","aa") → false
            * isMatch("aa", "a*") → true
            * isMatch("aa", ".*") → true
            * isMatch("ab", ".*") → true
            * isMatch("aab", "a*a*b") → true
            *
            *  ! isMatch("aa", "a");
//    assert new Solution().isMatch("aa", "aa");
//    assert !new Solution().isMatch("aaa", "aa");
//    assert new Solution().isMatch("aa", "a*");
    assert new Solution().isMatch("aa", ".*");
//    assert new Solution().isMatch("ab", ".*");
//    assert new Solution().isMatch("aab", "a*a*b");
//
//    assert new Solution().isMatch("aaaa", "a*a*");
//    assert new Solution().isMatch("aaaa", "aaa*");
//    assert new Solution().isMatch("aaaa", "aa*a");
//    assert new Solution().isMatch("aaaa", "a*aa");
//    assert new Solution().isMatch("aaaa", "a*a*a");
//
//    assert new Solution().isMatch("aaabbbccc", ".*.*..*");

//    assert !new Solution().isMatch("", "");
            */
        }
    }
}
