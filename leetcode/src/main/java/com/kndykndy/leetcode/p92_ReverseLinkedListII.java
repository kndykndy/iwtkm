package com.kndykndy.leetcode;

import com.kndykndy.leetcode.util.ListNode;

public class p92_ReverseLinkedListII {

    interface Solution {

        ListNode reverseBetween(ListNode head, int m, int n);
    }

    public static class Solution1 implements Solution {

        @Override
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || n <= m) {
                return head;
            }

            int k = 1;
            ListNode tempNode = head;
            ListNode reverseCurrentNode = null, reverseNextNode = null, reverseLastNode = null;
            ListNode lastPreReverseNode = null, firstPostReverseNode = null;

            while (tempNode != null) {
                if (k >= m && k <= n) {
                    reverseCurrentNode = tempNode;

                    ++k;
                    tempNode = tempNode.next;

                    reverseCurrentNode.next = reverseNextNode;
                    reverseNextNode = reverseCurrentNode;
                    if (reverseLastNode == null) {
                        reverseLastNode = reverseCurrentNode;
                    }

                    continue;
                } else {
                    if (k < m) {
                        lastPreReverseNode = tempNode;
                    } else { // k > n
                        if (firstPostReverseNode == null) {
                            firstPostReverseNode = tempNode;
                        }
                    }
                }

                ++k;
                tempNode = tempNode.next;
            }

            if (lastPreReverseNode != null) {
                lastPreReverseNode.next = reverseCurrentNode;
            }
            if (firstPostReverseNode != null) {
                reverseLastNode.next = firstPostReverseNode;
            }

            return lastPreReverseNode != null ? head : reverseCurrentNode;
        }
    }
}
