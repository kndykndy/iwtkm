package com.kndykndy.leetcode;

import com.kndykndy.leetcode.p226_InvertBinaryTree.Solution;
import com.kndykndy.leetcode.p226_InvertBinaryTree.Solution1;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p226_InvertBinaryTreeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            // todo
//            TreeNode node = solution.invertTree(TreeNode.deserialize("[4,2,7,1,3,6,9]"));
//            assertTrue("[4,7,2,9,6,3,1]", TreeNode.serialize(node));
        }
    }
}
