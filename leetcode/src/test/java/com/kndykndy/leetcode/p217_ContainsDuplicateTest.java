package com.kndykndy.leetcode;

import static com.kndykndy.leetcode.p217_ContainsDuplicate.containsDuplicate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class p217_ContainsDuplicateTest {

    @Test
    void test1() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicate(new int[]{1, 2, 3}));
    }
}
