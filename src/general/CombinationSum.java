package general;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationSum {
    Set<List<Integer>> answer = new HashSet();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        combineSum(candidates, new ArrayList<>(), target);
        return  answer.stream().collect(Collectors.toList());
    }

    void combineSum(int[] candidates, List<Integer> combination, int target) {
        if(target == 0) {
            Collections.sort(combination);
            answer.add(combination);
        }
        else if( target > 0) {
            for(int candidate: candidates) {
                if(candidate <= target) {

                    combineSum(candidates,
                            Stream.concat( Stream.of(candidate), combination.stream()).collect(Collectors.toList()),
                            target - candidate);
                }
                else break;
            }

        }
    }



    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{ 6 , 7 , 3, 2}, 7 ));

    }
}
