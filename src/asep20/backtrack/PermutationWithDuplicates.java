package asep20.backtrack;

import java.util.*;
//https://leetcode.com/problems/permutations-ii/solution/
public class PermutationWithDuplicates {

    List<List<Integer>> result = new ArrayList<>();

    int length = 0;

    public void permuteUnique(LinkedList<Integer> path, Map<Integer, Integer> counter) {
        if(path.size() == length) {
             result.add(new ArrayList<>(path));
             return;
         }
         for(int num:   counter.keySet()) {
            if( counter.get(num) - Collections.frequency(path, num) > 0) {
                path.add(num);
                permuteUnique(path, counter);
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        length = nums.length;
        Map<Integer, Integer> counter = new LinkedHashMap<>();
        for (Integer num: nums)  counter.put(num, counter.getOrDefault(num, 0) + 1);
        permuteUnique( new LinkedList<>(), counter);
        return result;
    }


    public static void main(String[] args) {
        PermutationWithDuplicates perm = new PermutationWithDuplicates();
        perm.permuteUnique( new int[] {1, 1, 2});
    }

}
