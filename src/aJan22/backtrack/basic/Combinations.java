package aJan22.backtrack.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//77
public class Combinations {

    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>>  backtrack(int[] nums, int kRem,  int start, List<Integer> path)  {

        if(kRem == 0) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length && kRem > 0; i++) {
            path.add(nums[i]);
            backtrack(nums, kRem-1, i+1, path);
            path.remove(path.size() - 1);
        }

        return  ans;
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i-1] = i;
        //Arrays.stream(nums).forEach(System.out::println);
        return backtrack(nums, k, 0, new ArrayList<>());
    }


    public static void main(String[] args) {
        Combinations comb = new Combinations();
        //System.out.println(comb.combine(8, 3));
        System.out.println(comb.combine(4, 2));
    }

}
