# Leetcode problems

| # | Statement | Key & notes |
| - | --------- | ----------- |
[1](https://leetcode.com/problems/two-sum/) | Two Sum | time O(n), space O(n) with counterparts in map
[2](https://leetcode.com/problems/add-two-numbers) | Add Two Numbers | iterate both, construct LN on the fly
[3](https://leetcode.com/problems/longest-substring-without-repeating-characters) | Longest Substring Without Repeating Characters
[4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Find Median Sorted Array | Hard;
[5](https://leetcode.com/problems/longest-palindromic-substring) | Longest Palindromic Substring
[6](https://leetcode.com/problems/zigzag-conversion) | Zig-Zag conversion
[7](https://leetcode.com/problems/reverse-integer) | Reverse Integer | % and /
[8](https://leetcode.com/problems/string-to-integer-atoi) | String to Integer (atoi) | get numbers as str.charAt(i) - '0'
[9](https://leetcode.com/problems/palindrome-number) | Palindrome Number | % and /
10 | Regular Expression Matching | todo
[33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Search Rotated Sorted Array | search rotation idx with manual binary search, then do Arrays.bS
[64](https://leetcode.com/problems/minimum-path-sum/) | Minimum Path Sum | subvisit & memoize
[122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Best Time to Buy and Sell Stock II | draw; sum if next is bigger than prev
[146](https://leetcode.com/problems/lru-cache/) | LRU Cache | Use deque (recent usage) and map
[201](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | Bitwise AND of Numbers Range | it's 0 if m=0 or m&n=0 or m/n leading zeros aren't equal, else do & for all
[287](https://leetcode.com/problems/find-the-duplicate-number/) | Find the Duplicate Number | A list with cycle problem actually; use Tortoise&Hare
[525](https://leetcode.com/problems/contiguous-array/) | Contiguous Array | draw; keep map max_result-to-idx_of_that_result
[543](https://leetcode.com/problems/diameter-of-binary-tree/) | Diameter of Binary Tree | from root: get sum of l/r heights, max of recursive diameter calls, take max of them
[560](https://leetcode.com/problems/subarray-sum-equals-k/) | Subarray Sum Equals K | O(n^2) simple for in for; o(n) map conseq_sum-to-its_occurance, getOrDefault+merge
[844](https://leetcode.com/problems/backspace-string-compare/) | Backspace String Compare | maintain two idxs: if encounter #, first while++ it's still #, then while-- if not
[1008](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | Construct Binary Search Tree from Preorder Traversal | O(n^2) construct each new node from root; O(n) create root, for each pop items from stack that is less than new node
10000 | Counting Elements | Add all items to set, do second pass
10012 | Leftmost Column with at Least a One | interactive; start from top-right, if 1 go left, if 0 go down 
