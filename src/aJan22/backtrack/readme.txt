https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/detailsaboutbacktracking
https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

Todo:
  complexity analysis of backtracking problems
  46 Permutation: try a more efficient solution
  47. Permutations II - refer notes
  90. Subsets II - refer notes
  784. Letter Case Permutation
  320. Generalized Abbreviation
  31. Next Permutation
  2116. Check if a Parentheses String Can Be Valid
  79 Word Search
  132. Palindrome Partitioning II
  1745. Palindrome Partitioning IV

-------------------------------------------------------------------------------------------------------------------------
Order to revisit the problems:
46 Permutations
78 Subsets
77 Combinations
22 Generate parantheses
131. Palindrome Partitioning
93 RestoreIPAddresses
79 Word Search
140 word break 2
-------------------------------------------------------------------------------------------------------------------------
** the key in backtracking is you are presented with choosing multiple choice.
  if you make a selection and pass the partial answer to the recursion, be sure to undo that selection(backtrack),
   make a new selection and pass the new partial answer to the next recursion.


Backtracking:
```
    def backtrack(Path, Seletion List  ):
      if meet the End Conditon:
         result.add(Path)
         return

    for seletion in Seletion List:
         select (in to 'Path')
         backtrack(Path, Seletion List)
         deselect (from 'Path')
```
-------------------------------------------------------------------------------------------------------------------------
Following backtrack with Memoization (top down DP)
    630. Course Schedule III
    435. Non-overlapping Intervals
    140. Word Break II
-------------------------------------------------------------------------------------------------------------------------
140 Word Break II
Time complexity is 2^n -   All possible subsets in a set in the worst case.
-------------------------------------------------------------------------------------------------------------------------
90. Subsets II all possible subsets without duplicates
same as subset 1 (all possible subsets) but
1) sort the input array initially
2) before backtracking, check if nums[i-1] = nums[i]
-------------------------------------------------------------------------------------------------------------------------
47. Permutations II



