package aJan22.dynamicprog.burstballloon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
312  This is a sub optimal top down solution
Sub optimal because this memoizes 2^n states (number of all all possible subsets in a set).
Is there a better set of states to memoize ? turns out there is.  Number of all subarrays in an array is n^2 and thus n^2 states
 */
public class BurstBalloonsTDSubOpt {

     int result = Integer.MIN_VALUE;
     Map<String, Integer> memo = new HashMap<>();


    public int maxCoins(StringBuilder nums) {
        if(nums.length() == 2) return 0;
        if(memo.containsKey(nums.toString())) return memo.get(nums.toString());
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length()-1 ; i++) {

            int left =  Character.getNumericValue(nums.charAt(i-1));
            int num = Character.getNumericValue(nums.charAt(i));
            int right = Character.getNumericValue(nums.charAt(i+1));
            nums.deleteCharAt(i);
            int val = maxCoins(nums);
            result = Math.max( val + left*num*right, result );
            //System.out.println("key " + nums.toString() + " value " + val );
            if(!memo.containsKey(nums.toString())) memo.put(nums.toString(), val);
            nums.insert(i, num);

        }

        return result;
    }


    public int maxCoins(int[] nums) {
        String newNums = "1" + Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining()) + "1";
        return maxCoins(new StringBuilder(newNums));
    }

    public static void main(String[] args) {
        BurstBalloonsTDSubOpt bb = new BurstBalloonsTDSubOpt();
        System.out.println(bb.maxCoins(new int[] {3,1,5,8}));
    }
}
