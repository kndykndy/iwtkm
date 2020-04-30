# Leetcode problems

| # | Statement | Key & notes |
| - | --------- | ----------- |
[1](https://leetcode.com/problems/two-sum/) | Two Sum | Time O(n) & space O(n) with counterparts in map.
[2](https://leetcode.com/problems/add-two-numbers) | Add Two Numbers | Iterate both, construct LN on the fly.
[3](https://leetcode.com/problems/longest-substring-without-repeating-characters) | Longest Substring Without Repeating Characters | _TODO_
[4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Find Median Sorted Array | **Hard**. _TODO_
[5](https://leetcode.com/problems/longest-palindromic-substring) | Longest Palindromic Substring | _TODO_
[6](https://leetcode.com/problems/zigzag-conversion) | Zig-Zag conversion | _TODO_
[7](https://leetcode.com/problems/reverse-integer) | Reverse Integer | % and /
[8](https://leetcode.com/problems/string-to-integer-atoi) | String to Integer (atoi) | Get numbers as str.charAt(i) - '0'
[9](https://leetcode.com/problems/palindrome-number) | Palindrome Number | % and /
[10](https://leetcode.com/problems/regular-expression-matching/) | Regular Expression Matching | **Hard**. _TODO_
[33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Search Rotated Sorted Array | Search rotation idx with manual binary search, then do Arrays.bS for both parts.
[53](https://leetcode.com/problems/maximum-subarray/) | Maximum Subarray | **Kadane**'s algorithm.
[64](https://leetcode.com/problems/minimum-path-sum/) | Minimum Path Sum | Subvisit & memoize.
[122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Best Time to Buy and Sell Stock II | **Draw**! Sum if next is bigger than prev.
[124](https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/) | Binary Tree Maximum Path Sum | **Hard**. Recurse then memoize max sum and return from recursion.
[136](https://leetcode.com/problems/single-number/) | Simple Number | 
[146](https://leetcode.com/problems/lru-cache/) | LRU Cache | Use **deque** for recent usage and map.
[155](https://leetcode.com/problems/min-stack/) | Min Stack | Keep two **deques**: data and min-stack.
[200](https://leetcode.com/problems/number-of-islands/) | Number of Islands | Go thru matrix and if 1, waterize all around recursively.
[201](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | Bitwise AND of Numbers Range | It's 0 if m=0 or m&n=0 or m/n leading zeros aren't equal immediately, else do & for all.
[202](https://leetcode.com/problems/happy-number/) | Happy Number | Calculate & remember each iteration. Return false if num already occurred.
[221](https://leetcode.com/problems/maximal-square/) | Maximal Square | **DP** 0 matrix. If 1 the min(-1 -1, -1 0, 0 -1) + 1.
[283](https://leetcode.com/problems/move-zeroes/) | Move Zeroes | Keep ptr, increase it only when meet not zero, nullify rest at second pass.
[287](https://leetcode.com/problems/find-the-duplicate-number/) | Find the Duplicate Number | A list with cycle problem actually. **Tortoise&Hare**.
[525](https://leetcode.com/problems/contiguous-array/) | Contiguous Array | **Draw**! Keep map max-result to idx-of-that-result.
[543](https://leetcode.com/problems/diameter-of-binary-tree/) | Diameter of Binary Tree | From root: get sum of l/r heights, max of recursive diameter calls, take max of them.
[560](https://leetcode.com/problems/subarray-sum-equals-k/) | Subarray Sum Equals K | O(n^2) simple folded fors. O(n) map conseq-sum to its-occurance, getOrDefault+merge.
[678](https://leetcode.com/problems/valid-parenthesis-string/solution/) | Valid Parenthesis String | Do both left-to-right and right-to-left passes, check for extra parenthesis.
[844](https://leetcode.com/problems/backspace-string-compare/) | Backspace String Compare | Keep two idxs: if encounter #, first while++ it's still #, then while-- if not.
[876](https://leetcode.com/problems/middle-of-the-linked-list/) | Middle of the Linked List | Keep two pointers, increase second only when first/2>second.
[1008](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | Construct Binary Search Tree from Preorder Traversal | O(n^2) construct each node from root. O(n) create root, for each pop items from stack that is less than new node.
[1046](https://leetcode.com/problems/last-stone-weight/) | Last Stone Weight | **PQ**, add all to it, take two from it each step.
[1143](https://leetcode.com/problems/longest-common-subsequence/) | Longest Common Subsequence | **DP** 0 matrix; if ch1=ch2 dp[-1][-1]+1, max(dp[-1][],dp[][-1]) otherwise.
[Without number](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/) | Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree | **BFS** with subsearch if nodes are equal.
[Without number](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/) | Counting Elements | Add all items to **set**, do second pass.
[Without number](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/) | First Unique Number | Keep two **sets**: repeated and unique or single LinkedHashMap
[Without number](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/) | Leftmost Column with at Least a One | Start from top-right, if 1 go left, if 0 go down.
[Without number](https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/) | Perform String Shifts | Calculate shift and then do rotation.
