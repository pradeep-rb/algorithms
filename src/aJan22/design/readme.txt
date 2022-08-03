
------------------------------------------------------------------------------------------------------------------------------------------

381H. Insert Delete GetRandom O(1) - Duplicates allowed

User ArrayList + Hashmap

Key:  The order of elements in the ArrayList does not matter
Therefore to make remove() operation from an arraylist o(1) instead of o(n), simply
overwrite the value at the index to remove with the last value of the ArrayList.
Then remove the last item in the array list.

------------------------------------------------------------------------------------------------------------------------------------------
