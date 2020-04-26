package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.ListNode;

public class p876_MiddleOfTheLinkedList {

    interface Solution {

        /**
         * The number of nodes in the given list will be between 1 and 100.
         */
        ListNode middleNode(ListNode head);
    }

    public static class Solution1 implements Solution {

        @Override
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            int n = 0;
            ListNode nHead = head;
            while (nHead != null) {
                n++;
                nHead = nHead.next;
            }

            n /= 2;
            nHead = head;
            while (n != 0) {
                n--;
                nHead = nHead.next;
            }

            return nHead;
        }
    }

    public static class Solution2 implements Solution {

        @Override
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            int n = 0, pn = 0;
            ListNode nHead = head, pHead = head;
            while (nHead != null) {
                n++;
                if (n / 2 > pn) {
                    pn++;
                    pHead = pHead.next;
                }

                nHead = nHead.next;
            }

            return pHead;
        }
    }
}
