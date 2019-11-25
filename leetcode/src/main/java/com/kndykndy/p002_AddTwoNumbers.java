package main.java.com.kndykndy;

import java.math.BigInteger;
import main.java.com.kndykndy.support.ListNode;

/**
 * Leetcode #2 ~ Add Two Numbers https://leetcode.com/problems/add-two-numbers
 *
 * 10 Mar 2018
 *
 * Problem statement: You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list. You may assume the two numbers do not contain
 * any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class p002_AddTwoNumbers {

    interface Solution {

        ListNode addTwoNumbers(ListNode l1, ListNode l2);

    }

    public static class Solution1 implements Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return bigIntToInvList(invListToBigInt(l1).add(invListToBigInt(l2)));
        }

        private BigInteger invListToBigInt(ListNode listNode) {
            assert listNode != null;

            BigInteger result = BigInteger.ZERO;
            BigInteger k = BigInteger.ONE;

            while (listNode != null) {
                result = result.add(k.multiply(BigInteger.valueOf(listNode.val)));
                listNode = listNode.next;
                k = k.multiply(BigInteger.TEN);
            }

            return result;
        }

        private ListNode bigIntToInvList(BigInteger value) {
            if (value.equals(BigInteger.ZERO)) {
                return new ListNode(0);
            }

            ListNode result = null;
            ListNode lastListNode = null;

            while (value.compareTo(BigInteger.ZERO) != 0) {
                if (lastListNode != null) {
                    lastListNode.next = new ListNode(value.mod(BigInteger.TEN).intValue());
                    lastListNode = lastListNode.next;
                } else {
                    lastListNode = new ListNode(value.mod(BigInteger.TEN).intValue());
                }
                if (result == null) {
                    result = lastListNode;
                }
                value = value.divide(BigInteger.TEN);
            }

            return result;
        }

    }

    public static class Solution2 implements Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return null;
            }

            ListNode result = null;

            ListNode lastNode = null;
            ListNode newListNode;

            int carry = 0, tempSum;

            while (l1 != null || l2 != null) {
                tempSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
                if (tempSum < 10) {
                    newListNode = new ListNode(tempSum);
                    carry = 0;
                } else {
                    newListNode = new ListNode(tempSum % 10);
                    carry = 1;
                }

                if (lastNode == null) {
                    lastNode = newListNode;
                } else {
                    lastNode.next = newListNode;
                    lastNode = lastNode.next;
                }

                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;

                if (result == null) {
                    result = newListNode;
                }
            }

            if (carry != 0) {
                lastNode.next = new ListNode(1);
            }

            return result;
        }

    }

    public static void main(String[] args) {
        runTestSet(new Solution1());
        runTestSet(new Solution2());
    }

    @SuppressWarnings("AssertWithSideEffects")
    private static void runTestSet(Solution solution) {
        ListNode sumListNode;

        sumListNode = solution
            .addTwoNumbers(ListNode.fromValues(2, 4, 3), ListNode.fromValues(5, 6, 4));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(7, 0, 8));

        sumListNode = solution
            .addTwoNumbers(ListNode.fromValues(0), ListNode.fromValues(0));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(0));

        sumListNode = solution.addTwoNumbers(
            ListNode.fromValues(9),
            ListNode.fromValues(1, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1));

        sumListNode = solution
            .addTwoNumbers(ListNode.fromValues(2, 4, 3), ListNode.fromValues(5, 6, 4));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(7, 0, 8));

        sumListNode = solution.addTwoNumbers(ListNode.fromValues(0), ListNode.fromValues(0));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(0));

        sumListNode = solution.addTwoNumbers(
            ListNode.fromValues(9),
            ListNode.fromValues(1, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1));

        /*
         * (1) + (1->2->3) = (2->2->3)
         */
        sumListNode = solution.addTwoNumbers(ListNode.fromValues(1), ListNode.fromValues(1, 2, 3));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(2, 2, 3));

        /*
         * (1->2->3) + (9) = (0->3->3)
         */
        sumListNode = solution.addTwoNumbers(ListNode.fromValues(1, 2, 3), ListNode.fromValues(9));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(0, 3, 3));

        /*
         * (5) + (5) = (0->1)
         */
        sumListNode = solution.addTwoNumbers(ListNode.fromValues(5), ListNode.fromValues(5));
        assert sumListNode != null;
        assert sumListNode.equals(ListNode.fromValues(0, 1));
    }

}
