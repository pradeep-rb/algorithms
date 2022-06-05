package aJan22.backtrack.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//46

public class Permutation {

    List<List<Integer>> ans = new ArrayList<>();

    List<List<Integer>> backtrack(int[] nums, LinkedList<Integer> path)   {
        if (path.size() == nums.length) {
            ans.add( new ArrayList<>(path));
        }

        for (int num: nums) {
            if(path.contains(num)) continue;
            path.add(num);
            backtrack(nums, path);
            path.removeLast();
        }
        return ans;
    }

    List<List<Integer>> permute(int[] nums) {
        return backtrack(nums, new LinkedList());
    }



    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(new int[] {1,2,3}));
    }
}
