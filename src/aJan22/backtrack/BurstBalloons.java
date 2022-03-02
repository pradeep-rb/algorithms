package aJan22.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BurstBalloons {

     int result = Integer.MIN_VALUE;
     Map<String, Integer> memo = new HashMap<>();

    public String resetNum(StringBuilder sb) {
        StringBuilder newNums = new StringBuilder(sb);
        newNums.deleteCharAt(0);
        newNums.deleteCharAt(newNums.length() - 1);
        return newNums.toString();
    }

    public int maxCoins(StringBuilder nums) {
        if(nums.length() == 2) return 0;
        String key  = resetNum(nums);
        if(memo.containsKey(key)) return memo.get(key);

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length()-1 ; i++) {

            int left =  Character.getNumericValue(nums.charAt(i-1));
            int num = Character.getNumericValue(nums.charAt(i));
            int right = Character.getNumericValue(nums.charAt(i+1));
            nums.deleteCharAt(i);
            int val = maxCoins(nums);
            result = Math.max( val + left*num*right, result );
            //System.out.println("key " + key + " value " + val );
            key  = resetNum(nums);
            if(!memo.containsKey(key)) memo.put(key, val);
            nums.insert(i, num);

        }

        return result;
    }


    public int maxCoins(int[] nums) {
        String newNums = "1" + Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining()) + "1";
        return maxCoins(new StringBuilder(newNums));
    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.maxCoins(new int[] {3,1,5,8}));
    }
}
