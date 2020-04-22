package com.kndykndy.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p543_DiameterOfBinaryTree.Solution;
import com.kndykndy.leetcode.p543_DiameterOfBinaryTree.Solution1;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class p543_DiameterOfBinaryTreeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {

            final TreeNode tree = TreeNode.from(1, -1, 3);
            tree.left = TreeNode.from(2, 4, 5);

            assertEquals(3, solution.diameterOfBinaryTree(tree));
        }
    }
}
