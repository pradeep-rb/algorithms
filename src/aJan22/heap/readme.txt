ToDo
632. Smallest Range Covering Elements from K Lists
973. K Closest Points to Origin
_______________________________________________________________________________________________________________________
632. Smallest Range Covering Elements from K Lists (good one)

pointers to every element on the list.
store pointed elements on to PQ, maintain min and max  (max can be obtained from prevMax ) check the range of min and max
move pointer of the min element and find a new range
stop when one of the list is exhausted.

Another approach. use a k way merge using pq to merge in to a single list.  Element in the new list is a key-value pair of
number and index
use a two pointer approach to find  the range where the range has atleast one element with one of the indices
this can be done by decrement the count of elements in each list as the pointers from either ends are moved stopping when
the counts of atleast one of the lists hits 0 from either ends.
_______________________________________________________________________________________________________________________
759. Employee Free Time

This is a k-way merge problem using priority queues
_______________________________________________________________________________________________________________________