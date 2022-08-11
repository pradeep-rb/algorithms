
------------------------------------------------------------------------------------------------------------------------------------------

381H. Insert Delete GetRandom O(1) - Duplicates allowed

User ArrayList + Hashmap

Key:  The order of elements in the ArrayList does not matter
Therefore to make remove() operation from an arraylist o(1) instead of o(n), simply
overwrite the value at the index to remove with the last value of the ArrayList.
Then remove the last item in the array list.

------------------------------------------------------------------------------------------------------------------------------------------
1570. Dot Product of Two Sparse Vectors

1) HashMap might not be very efficient due to
 a) resizing and therefore re-distributing the keys after the load-factor is reached
 b) The random access while iterating through a hash map (and subsequent cache misses?: according to leetcode
    discussions: din't get that part)