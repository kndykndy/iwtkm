package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.ListNode;

/**
 * Leetcode #206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * 21 Jun 2018
 *
 * E.g.
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Hint:
 * Iterative: Increment head before manipulations with currentNode.
 * Recursive: Remember next position before recursive call.
 */
public class p206_ReverseLinkedList {

    interface Solution {

        ListNode reverseList(ListNode head);
    }

    /**
     * Iterative solution.
     */
    public static class Solution1 implements Solution {

        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode currentNode = null, nextNode = null;

            while (head != null) {
                currentNode = head;
                head = head.next;

                currentNode.next = nextNode;
                nextNode = currentNode;
            }

            return currentNode;
        }
    }

    /**
     * Recursive solution.
     */
    public static class Solution2 implements Solution {

        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            final ListNode nextNode = head.next;
            final ListNode newHead = reverseList(nextNode);
            nextNode.next = head;
            head.next = null;

            return newHead;
        }
    }

    public static class Solution3 implements Solution {

        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode currentNode = head;
            ListNode nextNode;
            ListNode newList = null;

            while (currentNode != null) {
                nextNode = currentNode.next;
                if (newList != null) {
                    currentNode.next = newList;
                    newList = currentNode;
                } else {
                    newList = currentNode;
                    newList.next = null;
                }
                currentNode = nextNode;
            }

            return newList;
        }
    }
}
