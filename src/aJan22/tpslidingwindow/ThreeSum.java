package aJan22.tpslidingwindow;

import java.util.*;
//15. 3Sum

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans =  new HashSet<>();
        Set<Integer> dups =  new HashSet<>();
        Set<Integer> seen =  new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(dups.add(nums[i])) { // skip duplicate numbers
                seen.clear();
                for (int j = i + 1; j < n; j++) {
                    int complement = -nums[i] - nums[j];
                    if (seen.contains(complement)) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                    seen.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
