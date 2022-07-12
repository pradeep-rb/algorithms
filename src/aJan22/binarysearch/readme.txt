* One can use Binary Search to solve a lot of problems where the solution using BS is non-obvious
https://leetcode.com/discuss/general-discussion/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems


BS Pattern:



* Furthest B Reach (1642),  Split array max sum (410):
    1) Guess the answer
            Establish an upper and lower bound for the ansert
    2) need a function to check if the answer is a correct in reasonable time
            Whats the answer's relationship with other parameters for the problem
    3) BS for an answer on the answer space. The answer needs to be already sorted on some property
            Adjust the answer according to how far off the answer is. May have to check the answer's relationship to
            other parameters(s)

*  Other BS solutions use BS in combination with other techniques to  speed up the process
    These problems have a linear search component that can be sped up BS.


    m =  (l + h) /2  + 1
    l = m,  h = m - 1
    variation :
    l <= h    m =   (l + h) / 2, l = m+ 1, h = m - 1

* Technique to identify:  Furthest B Reach (1642),  Split array max sum (410): 875 koko eating banana
    1) When the answer has an upper and a lower bound : you could do a linear search of all values from lower to upper.
    2) the answer space is sorted in some order
    3) there is a reasonably easy algorithm to determine if the answer is correct.
    4) Additionally check if how changing one of the parameters affects the answer

ToDO
162 find peak element
34. Find First and Last Position of Element in Sorted Array
1011. Capacity To Ship Packages Within D Days
427 construct a quad tree

------------------------------------------------------------------------------------------------------------------------------------------
 875 koko eating banana
 lower bound: no. of elements in array. upper bound: max number.  Could do a linear search of the answer space
 optimize by doing a binary search of the answer space
 ------------------------------------------------------------------------------------------------------------------------------------------

