Todo:
    1000h merge stones
     741h : cherry pick
     Matrix Chain multiplication, LIS are their own categories
     Merge interval problems*


Leetcode DP categories
https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns
https://leetcode.com/discuss/general-discussion/1000929/solved-all-dynamic-programming-dp-problems-in-7-months
https://leetcode.com/discuss/general-discussion/592146/Dynamic-Programming-Summary

DP Blogs
https://codeforces.com/blog/entry/67679
https://codeforces.com/blog/entry/43256


max sub array
stocks
robber3 (rob 1 and rob2)
paint house2 (paint house1)
paint fence :   TRICKY
----------

718:  Maximum length of repeated subarray
Input: A = [1,2,3,2,1], B = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
subarray start at i from A and j from B
if A[i]==B[i]
dp[i][j] = dp[i+1][j+1] + 1
---------

322: coin change
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
DP on amount( i is amount)
dp[i] = 1 + min (dp[i - C1], dp[i - C2],.... dp[i - Ck])
----------------

91. Decode Ways
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Following is the intuition behind the dp solution. (It can be easily developed by doing examples of up to dp[4])
At poistion i, we can simply add the new character to the end of the path taken so far or combine it  with the previous character at i-1
No. of paths after simply adding a new character  to the paths that ended at i-1 =  DP[i-1]
No. of paths after  combining the  new character  with prev character(are the paths that ended at i-2 ) =  DP[i-2]
therefore dp[i] = d[i-1] + dp[i-2]. but conditions apply (you can't always combine)

----------------------------
5. Longest Palindromic Substring
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

mistake:  picked an index, using that center started expanding. Was thinking of a 1D DP. Coming up with a recurrance relation was difficult
solutuion:  2d  boolean DP. Base =   if i == j, dp[i][j] == true,
recurrence: dp[i][j] =  dp[i-1][j+1]  if a[i] == a[j].  keep track of max as j - i  and save the index of the max value
-----------------------------
1048. Longest String Chain *******  good probem cz it has sevaral dp soln.

1st Suboptimal dp Solution
sort asc word length
dp[i]   = dp[j] + 1  ( j is from 0 to i-1) if a[i] is a predecessor
Complexity :  O ( NlogN  + N^2L)=  o(N( logN + NL))  - This might be ineffiecient if N >>> L

2nd better dp solution
sort asc word length
for word i, delete one character at a time and get the predecessor length from a DP map
* Here the memoization happens in a map instead of DP array. The map stores predecessors with the lenght of the word chain formed so far
Complexity:  Why is bottom up  DP approach Time complexity:  O (N (logN + L^2)). instead of O (N (logN + L)).
Where did the extra L come from ?  It says L is for creating each predecessor.
The remove charAt(i) on stringBuilder incurrs a cost of L I guess.
------------------------------------------------------------
Knapsack Problem
W = (1, 2, 3) V = (6, 10 , 12).  Capacity = 5

        1       2       3       4         5(c from 0 to N)
1       6       6       6       6         6

           (6, 10)  (6,6+10)  (6,6+10)  (6,6+10)
2       6     10       16      16        16

           (10, )   (16,16+0) (16,6+12)   (16,10+12)
3       6    10        16       18        22
(i from 0 to 3)



dp[i][c] =   max(dp[i-1][c], dp[i-1][c - W[i]]  + V[i])
--------------------------------------------------
983.  Min cost of tickets   1 day or 7 day or 30 passes with costs[i].  Minimize $$$
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.

solution:
if not traveling on day i then dp[i] = dp[i-1]
if traveling on day i then dp[i] =  min ( 2+ dp[i-2],  7+ dp[i-7], 15 + dp[i-30])
--------------------------------------------------------------
174 Dungeon game: -ve: health, +ve : orbs. Go from 0,0 to 2,2


-2       -3       3                 -2(7)     -3(5)   3(*)
                                    (8)      (14)    (2)

                                     (16)     (15)
-5      -10       1                 -5       -10     1(*)
                 (5)              (6)       (11)     (5)


10       30(1)   -5                10(1)    30(1)    -5 (6)
                                  (*)       (*)       (6)

 dp[r-1][c-1] = dungeon[r-1][c-1] > 0 ? 1 : 1 - dungeon[r-1][c-1];

  dp[i][j] = Math.min(dungeon[i][j] >= dp[i + 1][j] ? 1 : dp[i+1][j] ==  Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i + 1][j] - dungeon[i][j],
                            dungeon[i][j] >= dp[i][j + 1] ? 1 : dp[i][j + 1] ==  Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j + 1] -  dungeon[i][j]);


or

// in the cell where the princess is, if I have an orb, all it takes is a health of 1 right before I get there
// else I need 1 more than how much my health will be depleted by (-ve health )
dp[r-1][c-1] = dungeon[r-1][c-1] > 0 ? 1 : 1 - dungeon[r-1][c-1];
// How much health do I need, considering the right or the bottom cell (places I gotta go)
int need =  Math.min(dp[i + 1][j],  dp[i][j + 1]  )  - dungeon[i][j];
//but  if my needs are more than satisfied by an orb in the current cell, then all I need is a health of 1
//  else I need what  I need
dp[i][j] = dungeon[i][j] >= dp[i + 1][j]  || dungeon[i][j] >= dp[i ][j+1]   ? 1 : need;
----------------------------------------------------------------------------------------------------------------------------------------------------
312 Bursting Balloons: probably the hardest DP problem
The number of states in the solutions seems to evolve as follows 1) all possible permutations N!. 2) all possible subsets in a set 2^n.
 3)all possible subarrays in an array N* ((N+1)/2) ~ N^2. So the question we need to ask ourselves is how can I reduce the number of states?
By memoization obviously. But if memoization still doesn't get you a linear run time complexity, then perhaps there is a better way to memoize.
The important takeaway from the problems are not the solutions themselves but,
learning to think about the number of states involved in each solution and trying to see if there is a better way to reduce the number of states.
Knowing that there are N^2 subarrays in an array (and therefore N^2 states) will now force me to want to divide any array that I see / look for a potential divide  and conquer solution.


The number of states in the solutions seems to evolve as follows
1) all possible permutations N!. 2) all possible subsets in a set 2^n. 3)all possible sub-arrays in an array N* ((N+1)/2) ~ N^2.
So the question we need to ask ourselves is how can I reduce the number of states?
By memoization obviously. But if memoization still doesn't get you a linear run time complexity, then perhaps there is a better way to memoize.

------------------------------------------------------------------------------------------------------------------------------------------
300 Longest increasing subsequence. (check 435)
Arrays.fill(dp, 1)
if(arr[j] > arr[i])  dp[i] =  Math.max( dp[i], 1+dp[j])
return max(dp)
Same technique can be used for finding longest overlapping intervals(435)
------------------------------------------------------------------------------------------------------------------------------------------


