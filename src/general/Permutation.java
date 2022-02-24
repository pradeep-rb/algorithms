package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutation {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int i =0; i < nums.length; i++) {
            numList.add(nums[i]);
        }

        permute(numList,  new ArrayList<>());
        return ans;
    }

    public void permute(List<Integer> numList, List<Integer> permutation) {

        if( numList.size() == 0) {
            ans.add(permutation);

        }
        else {

            for (Integer num: numList) {
                permute( numList.stream().filter(x -> x != num).collect(Collectors.toList()),
                        Stream.concat(permutation.stream(), Stream.of(num)).collect(Collectors.toList()));
            }
        }

    }

    public static void main(String[] args) {

        Permutation permutation = new Permutation();

        System.out.println(permutation.permute(new int[]{1, 2, 3}));

    }
}
