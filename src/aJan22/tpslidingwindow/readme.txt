11. Container With Most Water
 height = [1,8,6,2,5,4,8,3,7]  Ans = 49
 For all pairs of points, maximize the are of the bounded rectangle. n^2
 How to reduce the number of pairs ?
 pick two points on either extremes, calculate area, skip the smaller point.
 This essentially reduces the 'n' comparisons we'd otherwise be making.
 rinse and repeat while tracking the max area

Brute force is  doing n^2 calculations.    The key to solving this problem is asking yourself is L
Can I skip some calculations in favor of the others ? you can, just leave the smaller of every pair you compare from further comparisons
------------------------------------------------------------------------------------------------------------------------
31. Next Permutation

Try a big number and  notice the pattern :  .
158476531 Next perm is : 158513467

1) 1584765341  to 158 5 16 4 37   swap 5 and 4 because 5 is the next greatest number after 4.
2) reverse the rest of the characters after 5
158 5 76 4 31   ->  1585 13467


------------------------------------------------------------------------------------------------------------------------
https://medium.com/@timpark0807/leetcode-is-easy-sliding-window-c44c11cc33e1
https://medium.com/leetcode-patterns/leetcode-pattern-2-sliding-windows-for-strings-e19af105316b


*  maintain a left and a right pointer.
*  TRY TO INCREMENT AND DECREMENT THE WINDOW ONE ELEMENT AT AT TIME

def sliding_window(nums):
    # Iterate over elements in our input
        # Meet the condition to stop expansion
            # Process the current window
        # Contract the left side of the window
           # Additional processing if necessary
        # Expand the Right side of the window



ToDo
723. Candy Crush  :bloomberg
239H. Sliding Window Maximum
Longest Substring with At Most K Distinct Characters
Longest Repeating Character Replacement
Maximize the Confusion of an Exam
1871. Jump Game VII   : took a whole to solve, practice again




