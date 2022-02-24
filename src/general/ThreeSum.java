package general;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer= new ArrayList();

        Map<Integer, List<Integer>> indexMap = new HashMap();

        for(int i =0; i < nums.length; i++) {
            List<Integer> list = indexMap.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            indexMap.put(nums[i], list);
        }

        for(int i=0; i < nums.length; i++) {
            int target = nums[i];
            for(int j =0; j < nums.length; j++) {
                if(i == j) continue;
                int complement  = -1 *( target + nums[j]);
                    if(indexMap.containsKey(complement) && getIndex(indexMap.get(complement), i, j) != -1) {
                    List<Integer> list = Arrays.asList(target, nums[j], nums[ getIndex(indexMap.get(complement), i, j)]);
                    if(!isMember(answer, list)) {
                        answer.add(list);
                    }
                }
            }
        }

        return answer;
    }

    int getIndex(List<Integer> idxList, int i, int j) {

        for(int x: idxList) {
            if(x != i && x!=j) {
                return x;
            }
        }
        return -1;
    }

    boolean isMember(List<List<Integer>> answers, List<Integer> target) {
        for(List<Integer> answer: answers) {
            Collections.sort(answer);
            Collections.sort(target);
            if( answer.equals(target)) {
                return true;
            }
        }
        return  false;
    }


    public static void main(String[] args) {
        ThreeSum threeSum =  new ThreeSum();
        System.out.println(threeSum.threeSum( new int[] {-1,0,1,2,-1,-4}));
    }
}
