package com.kndykndy.leetcode;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kndykndy.leetcode.p297_SerializeDeserializeBinaryTree.Solution;
import com.kndykndy.leetcode.p297_SerializeDeserializeBinaryTree.Solution1;
import com.kndykndy.leetcode.util.TreeNode;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class p297_SerializeDeserializeBinaryTreeTest {

    private List<Solution> solutions;

    @BeforeEach
    void setUp() {
        solutions = Collections.singletonList(new Solution1());
    }

    @Test
    void test1() {
        for (Solution solution : solutions) {
            TreeNode root;

            assertEquals("[]", solution.serialize(null));
            assertEquals("[1]", solution.serialize(TreeNode.from(1, null, null)));
            assertEquals("[1,2,3]", solution.serialize(TreeNode.from(1, 2, 3)));
            assertEquals("[1,2]", solution.serialize(TreeNode.from(1, 2, null)));
            assertEquals("[1,null,3]", solution.serialize(TreeNode.from(1, null, 3)));

            root = TreeNode.from(3, 2, 4);
            root.left.left = new TreeNode(1);
            assertEquals("[3,2,4,1]", solution.serialize(root));

            root = TreeNode.from(1, 3, null);
            root.left.right = new TreeNode(4);
            assertEquals("[1,3,null,null,4]", solution.serialize(root));

            root = TreeNode.from(1, 2, 3);
            TreeNode.add(root.right, 4, 5);
            assertEquals("[1,2,3,null,null,4,5]", solution.serialize(root));

            root = TreeNode.from(1, 2, 3);
            root.right.left = new TreeNode(4);
            assertEquals("[1,2,3,null,null,4]", solution.serialize(root));
        }
    }

    @Test
    void test2() {
        for (Solution solution : solutions) {
//            assertTrue(solution.deserialize("[1,2,3]").isEqual(TreeNode.from(2, 1, 3)));
//            assertTrue(solution.deserialize("[1,2,3,null,null,4,5]").isEqual(null));
        }
    }

    @Test
    void test3() {
        for (Solution solution : solutions) {
            final String[] testCases = new String[]{
                "[]",
                "[1]",
                "[1,2]",
                "[1,null,3]",
                "[1,2,3]",
                "[1,2,3,4]",
                "[1,2,3,null,5]",
                "[1,2,3,null,null,6]",
                "[1,3,null,null,4]",
                "[1,2,3,null,null,null,7]",
                "[1,2,3,null,null,6,7]",
                "[1,2,3,4,5,6,7]",
                "[5,2,3,null,null,2,4,3,1]"
            };
            for (String testCase : testCases) {
                System.out.println("Running testcase: " + testCase);
                assertEquals(testCase, solution.serialize(solution.deserialize(testCase)));
            }
        }
    }
}
