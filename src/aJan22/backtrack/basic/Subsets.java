package aJan22.backtrack.basic;

import java.util.ArrayList;
import java.util.List;


//78. Subsets

public class Subsets {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> backtrack(int[] nums, List<Integer>  path, int first)  {
        ans.add(new ArrayList<>(path));

        for (int i = first; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            path.remove(path.size() - 1 );
        }
        return ans;
    }


    public List<List<Integer>> subsets(int[] nums) {
        return backtrack(nums, new ArrayList<>(), 0);
    }

    public static void main(String[] args) {
        Subsets sub = new Subsets();
        System.out.println(sub.subsets(new int[]{1, 2, 3}));
    }

}

