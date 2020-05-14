# LeetCode problems

[My LeetCode profile](https://leetcode.com/kndykndy/)

### Intermediate achievements

* Finished [30-Day-LeetCoding Challenge](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/)

### LeetCode numbered tasks

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
:white_check_mark: | 11 | [Container with Most Water](https://leetcode.com/problems/container-with-most-water/) | Medium | Time O(n), space O(1): count max for: (j - i) * Math.min(height[i], height[j])
:white_check_mark: | 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Easy | Go thru string, check for next symbol in extra cases.
:white_check_mark: | 14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Easy | Calc min word length first.
:white_check_mark: | 15 | [3Sum](https://leetcode.com/problems/3sum) | Medium | Sort, set i1=0,i2=1,i3=length-1, fix i1, find sum of the rest two complement to fixed.
:white_check_mark: | 16 | [3Sum Closet](https://leetcode.com/problems/3sum-closest) | Medium | Sort, set i1=0,i2=1,i3=length-1, fix i1, find sum of the rest two as min closest.
:white_check_mark: | 17 | [Letter Combinations of a Phone number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium | Use map of button to string of letters. Set indexes to 0, then iterate bottom-up.
:white_check_mark: | 18 | [4Sum](https://leetcode.com/problems/4sum) | Medium | Sort, set i1=0,i2=1,i3=2,i4=length-1, then for-while-while
:white_check_mark: | 19 | [Remove Nth Node from End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Use two pointers (start second with null), remember head.
:white_check_mark: | 20 | [Valid Parenthesis](https://leetcode.com/problems/valid-parentheses) | Easy | Use **Deque**, peek & remove complement parenthesis.
:white_check_mark: | 21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Choose min of two head, append to new list.
:white_check_mark: | 23 | [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Add all items from all lists to min **PQ** first.
|   | 24 | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | Medium | 
:white_check_mark: | 26 | [Remove Duplicates From Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | Introduce idx, increase it & rewrite when num[i] not equal to num[idx].
:white_check_mark: | 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | Easy | Introduce idx, increase it & rewrite when not equal to val.
:white_check_mark: | 28 | [Implement strStr()](https://leetcode.com/problems/implement-strstr/) | Easy | When chars are equal, iterate both then check for full inclusion, otherwise decrease i1 by coincided amount of chars + 1.    
|   | 29 | [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/) | Medium | 
:white_check_mark: | 33 | [Search Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Search rotation idx with manual binary search, then do Arrays.bS for both parts.
:white_check_mark: | 41 | [First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | Hard | **Read explanation in the solution.**
 | 42 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | Hard | 
:white_check_mark: | 44 | [Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | Hard | **DP** boolean matrix. 0,0 true. If s=p||p=? then -1,-1. If * then -1,0||0,-1. Else false.
:white_check_mark: | 45 | [Jump Game II](https://leetcode.com/problems/jump-game-ii/) | Hard | **DP**. Take num[0] and recurse for it down to zero. Memoize ways to get to each pos.
:white_check_mark: | 46 | [Permutations](https://leetcode.com/problems/permutations) | Medium | Fix index and swap all other indexes.
:white_check_mark: | 47 | [Permutations II](https://leetcode.com/problems/permutations-ii) | Medium | Fix index and swap all other indexes, if they are not equal to a fixed one.
:white_check_mark: | 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams) | Medium | Convert each str to char array and then add to map as key. 
:white_check_mark: | 53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | Easy | **Kadane**'s algorithm.
|   | 54 | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix) | Medium |
|   | 56 | [Merge Intervals](https://leetcode.com/problems/merge-intervals) | Medium |
|   | 59 | [Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | Medium |
|   | 62 | [Unique Paths](https://leetcode.com/problems/unique-paths/) | Medium | **DP**
:white_check_mark: | 64 | [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/) | Medium | Subvisit & memoize.
|   | 67 | [Add Binary](https://leetcode.com/problems/add-binary) | Easy |
:white_check_mark: | 70 | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | Easy | fib(n + 1) 
|   | 78 | [Subsets](https://leetcode.com/problems/subsets) | Medium
|   | 82 | [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | Medium |
|   | 90 | [Subsets II](https://leetcode.com/problems/subsets-ii) | Medium
:white_check_mark: | 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii) | Medium | 
|   | 98 | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | Medium |
:white_check_mark: | 122 | [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Easy | **Draw**! Sum if next is bigger than prev.
:white_check_mark: | 124 | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | Recurse then memoize max sum and return from recursion.
:white_check_mark: | 136 | [Simple Number](https://leetcode.com/problems/single-number/) | Easy | O(n) with a set. O(n) XOR all values.
:white_check_mark: | 146 | [LRU Cache](https://leetcode.com/problems/lru-cache/) | Medium | Use **deque** for recent usage and map.
:white_check_mark: | 151 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string) | Medium | Go thru str, cut words before a space and insert into a StringBuffer. 
:white_check_mark: | 155 | [Min Stack](https://leetcode.com/problems/min-stack/) | Easy | Keep two **deques**: data and min-stack.
:white_check_mark: | 191 | [Number of 1 bits](https://leetcode.com/problems/number-of-1-bits/) | Easy | Do n&=(n-1) while not 9.
:white_check_mark: | 198 | [House Robber](https://leetcode.com/problems/house-robber/) | Eady| Actually Medium. **DP**. dp+1=max(dp,dp-1+numi).
|   | 199 | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view) | Medium |
:white_check_mark: | 200 | [Number of Islands](https://leetcode.com/problems/number-of-islands/) | Medium | Go thru matrix and if 1, waterize all around recursively.
:white_check_mark: | 201 | [Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | Medium | It's 0 if m=0 or m&n=0 or m/n leading zeros aren't equal immediately, else do & for all.
:white_check_mark: | 202 | [Happy Number](https://leetcode.com/problems/happy-number/) | Easy | Calculate & remember each iteration. Return false if num already occurred.
|   | 204 | [Count Primes](https://leetcode.com/problems/count-primes/) | Easy |
:white_check_mark: | 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | Easy | 
:white_check_mark: | 221 | [Maximal Square](https://leetcode.com/problems/maximal-square/) | Medium | **DP** 0 matrix. If 1 the min(-1 -1, -1 0, 0 -1) + 1.
|   | 236 | [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree) | Medium |
|   | 237 | [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list) | Easy |
:white_check_mark: | 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | Easy | Keep ptr, increase it only when meet not zero, nullify rest at second pass.
:white_check_mark: | 287 | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | Medium | A list with cycle problem actually. **Tortoise&Hare**.
|   | 300 | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | **DP**
:white_check_mark: | 322 | [Coin Change](https://leetcode.com/problems/coin-change/) | Medium | **DP**. Hard actually. Read explanation in the solution.
|   | 331 | [Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/) | Medium |
:white_check_mark: | 344 | [Reverse String](https://leetcode.com/problems/reverse-string) | Easy | Use temp char and swap chars.
|   | 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Medium |
:white_check_mark: | 387 | [First Unique Char in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) | Easy | Use **LinkedHashMap**.
|   | 435 | [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals) | Medium |
:white_check_mark: | 518 | [Coin Change II](https://leetcode.com/problems/coin-change-2/) | Medium | **DP**. Hard actually. Read explanation in the solution.
:white_check_mark: | 525 | [Contiguous Array](https://leetcode.com/problems/contiguous-array/) | Medium | **Draw**! Keep map max-result to idx-of-that-result.
:white_check_mark: | 541 | [Reverse String II](https://leetcode.com/problems/reverse-string-ii) | When should reverse, use helper to reverse from-to and use swap in it.
:white_check_mark: | 543 | [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) | Easy | From root: get sum of l/r heights, max of recursive diameter calls, take max of them.
:white_check_mark: | 557 | [Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii) | Easy | Use two SB, insert new char at 0 at second, when encounter space, append second to first.
:white_check_mark: | 560 | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | Medium | O(n^2) simple folded FORs. O(n) map conseq-sum to its-occurrence, getOrDefault+merge.
|   | 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | Medium |
|   | 572 | [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/) | Easy |
:white_check_mark: | 678 | [Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/solution/) | Medium | Do both left-to-right and right-to-left passes, check for extra parenthesis.
|   | 829 | [Consecutive Numbers Sum](https://leetcode.com/problems/consecutive-numbers-sum/) | Hard |
|   | 836 | [Rectangle Overlap](https://leetcode.com/problems/rectangle-overlap/) | Easy | 
:white_check_mark: | 844 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | Easy | Keep two idxs: if encounter #, first while++ it's still #, then while-- if not.
:white_check_mark: | 876 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Keep two pointers, increase second only when first/2>second.
:white_check_mark: | 1008 | [Construct Binary Search Tree from Preorder Traversal](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | Medium | O(n^2) construct each node from root. O(n) create root, for each pop items from stack that is less than new node.
:white_check_mark: | 1046 | [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) | Easy | **PQ**, add all to it, take two from it each step.
:white_check_mark: | 1143 | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | Medium | **DP** 0 matrix; if ch1=ch2 dp[-1][-1]+1, max(dp[-1][],dp[][-1]) otherwise.

### Misc unnumbered LeetCode tasks

|   | Title | Difficulty (subjective) | Key & notes |
| - | ----- | ----------------------- | ----------- |
| :white_check_mark: | [Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/) | Hard | **BFS** with subsearch if nodes are equal.
| :white_check_mark: | [Counting Elements (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/) | Easy | Add all items to **set**, do second pass.
| :white_check_mark: | [Find First Non-Repeating Character](https://leetcode.com/discuss/interview-question/125015/first-non-repeating-character-in-a-string) | Easy | Use **LHM** for frequencies, merge all to it then get first.
| :white_check_mark: | Find First Repeating Character | Easy | Use **LHM** for frequencies, merge all to it then get first.
| :white_check_mark: | [First Unique Number (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/) | Medium | Keep two **sets**: repeated and unique or single LinkedHashMap
| :white_check_mark: | [Game of Battleships](https://leetcode.com/discuss/interview-question/538068/) | Medium | Parse, build ships, shoot, get statistics.
| :white_check_mark: | [Leftmost Column with at Least a One (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/) | Medium | Start from top-right, if 1 go left, if 0 go down.
| :white_check_mark: | [Load Balancer](https://leetcode.com/discuss/interview-question/506287/) | Medium | Setup three groups, enlarge leftmost and rightmost, check if equal. 
| :white_check_mark: | [Multiply Two Numbers Without Using Multiplication](https://leetcode.com/discuss/interview-question/532188/Microsoft-or-Phone-or-Multiply-two-numbers-without-using-multiplication) | Easy | Remember sign, sum up until k<min(a,b).  
| :white_check_mark: | [Perform String Shifts (Challenge)](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/) | Medium | Calculate shift and then do rotation.
