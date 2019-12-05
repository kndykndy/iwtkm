package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kndykndy.leetcode.p100_SameTree.Solution;
import com.kndykndy.leetcode.p100_SameTree.Solution1;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p100_SameTreeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            assertTrue(solution.isSameTree(new TreeNode(1), new TreeNode(1)));
            assertTrue(solution.isSameTree(TreeNode.from(1, 2, 3), TreeNode.from(1, 2, 3)));
            assertTrue(solution.isSameTree(TreeNode.from(1, null, 3), TreeNode.from(1, null, 3)));
            assertTrue(solution.isSameTree(TreeNode.from(1, 2, null), TreeNode.from(1, 2, null)));
        }
    }

    @Test
    void test2() {
        for (Solution solution : solutions) {
            assertFalse(solution.isSameTree(new TreeNode(1), new TreeNode(2)));
            assertFalse(solution.isSameTree(TreeNode.from(1, 2, 3), TreeNode.from(1, 3, 2)));
            assertFalse(solution.isSameTree(
                TreeNode.from(1, null, 3), TreeNode.from(1, null, null)));
            assertFalse(solution.isSameTree(
                TreeNode.from(1, 2, null), TreeNode.from(1, null, null)));
        }
    }
}
