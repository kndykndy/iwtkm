# Leetcode problems

[My Leetcode profile](https://leetcode.com/kndykndy/)

### Leetcode numbered tasks

|   | # | Title | Difficulty | Key & notes |
| - | - | ----- | ---------- | ----------- |
:white_check_mark: | 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | Time O(n) & space O(n) with counterparts in map.
:white_check_mark: | 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers) | Medium | Iterate both, construct LN on the fly.
:white_check_mark: | 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) | Medium |
:white_check_mark: | 4 | [Find Median Sorted Array](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard |
:white_check_mark: | 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) | Medium |
:white_check_mark: | 6 | [Zig-Zag conversion](https://leetcode.com/problems/zigzag-conversion) | Medium |
:white_check_mark: | 7 | [Reverse Integer](https://leetcode.com/problems/reverse-integer) | Easy | % and /
:white_check_mark: | 8 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi) | Medium | Get numbers as str.charAt(i) - '0'
:white_check_mark: | 9 | [Palindrome Number](https://leetcode.com/problems/palindrome-number) | Easy | % and /
|   | 10 | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | Hard | 
:white_check_mark: | 33 | [Search Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Search rotation idx with manual binary search, then do Arrays.bS for both parts.
:white_check_mark: | 53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | Easy | **Kadane**'s algorithm.
:white_check_mark: | 64 | [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/) | Medium | Subvisit & memoize.
:white_check_mark: | 122 | [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Easy | **Draw**! Sum if next is bigger than prev.
:white_check_mark: | 124 | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/) | Hard | Recurse then memoize max sum and return from recursion.
:white_check_mark: | 136 | [Simple Number](https://leetcode.com/problems/single-number/) | Easy | O(n) with a set. O(n) XOR all values.
:white_check_mark: | 146 | [LRU Cache](https://leetcode.com/problems/lru-cache/) | Medium | Use **deque** for recent usage and map.
:white_check_mark: | 155 | [Min Stack](https://leetcode.com/problems/min-stack/) | Easy | Keep two **deques**: data and min-stack.
:white_check_mark: | 200 | [Number of Islands](https://leetcode.com/problems/number-of-islands/) | Medium | Go thru matrix and if 1, waterize all around recursively.
:white_check_mark: | 201 | [Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | Medium | It's 0 if m=0 or m&n=0 or m/n leading zeros aren't equal immediately, else do & for all.
:white_check_mark: | 202 | [Happy Number](https://leetcode.com/problems/happy-number/) | Easy | Calculate & remember each iteration. Return false if num already occurred.
:white_check_mark: | 221 | [Maximal Square](https://leetcode.com/problems/maximal-square/) | Medium | **DP** 0 matrix. If 1 the min(-1 -1, -1 0, 0 -1) + 1.
:white_check_mark: | 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | Easy | Keep ptr, increase it only when meet not zero, nullify rest at second pass.
:white_check_mark: | 287 | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | Medium | A list with cycle problem actually. **Tortoise&Hare**.
:white_check_mark: | 525 | [Contiguous Array](https://leetcode.com/problems/contiguous-array/) | Medium | **Draw**! Keep map max-result to idx-of-that-result.
:white_check_mark: | 543 | [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) | Easy | From root: get sum of l/r heights, max of recursive diameter calls, take max of them.
:white_check_mark: | 560 | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | Medium | O(n^2) simple folded fors. O(n) map conseq-sum to its-occurance, getOrDefault+merge.
:white_check_mark: | 678 | [Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/solution/) | Medium | Do both left-to-right and right-to-left passes, check for extra parenthesis.
:white_check_mark: | 844 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | Easy | Keep two idxs: if encounter #, first while++ it's still #, then while-- if not.
:white_check_mark: | 876 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Keep two pointers, increase second only when first/2>second.
:white_check_mark: | 1008 | [Construct Binary Search Tree from Preorder Traversal](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | Medium | O(n^2) construct each node from root. O(n) create root, for each pop items from stack that is less than new node.
:white_check_mark: | 1046 | [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) | Easy | **PQ**, add all to it, take two from it each step.
:white_check_mark: | 1143 | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | Medium | **DP** 0 matrix; if ch1=ch2 dp[-1][-1]+1, max(dp[-1][],dp[][-1]) otherwise.

### Misc unnumbered Leetcode tasks

|   | Title | Difficulty (subjective) | Key & notes |
| - | ----- | ----------------------- | ----------- |
| :white_check_mark: | [Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/) | Hard | **BFS** with subsearch if nodes are equal.
| :white_check_mark: | [Counting Elements (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/) | Easy | Add all items to **set**, do second pass.
| :white_check_mark: | [First Unique Number (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/) | Medium | Keep two **sets**: repeated and unique or single LinkedHashMap
| :white_check_mark: | [Leftmost Column with at Least a One (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/) | Medium | Start from top-right, if 1 go left, if 0 go down.
| :white_check_mark: | [Perform String Shifts (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/) | Medium | Calculate shift and then do rotation.
