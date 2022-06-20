package aJan22.dynamicprog;

import java.util.*;


//740
/*

    revise : this involved the decomposition of the  original input array in to something that would lend itself to the
    DP model of iterating over the input set and interleaving partial results

 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> points = new TreeMap<>();

        for (int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num  );
        }
        List<Integer> pointsList = new ArrayList<>(points.keySet());

        int oneBackSc = points.get(pointsList.get(0));
        int twoBackSc = 0;
        int score =  points.get(pointsList.get(0));
        for (int i = 1; i <  pointsList.size(); i++) {
            int num = pointsList.get(i);
            int prevNum = pointsList.get(i-1);
            score =   num - prevNum == 1 ?  Math.max(oneBackSc, twoBackSc + points.get(num))
                                                     :      points.get(num) + oneBackSc;

            twoBackSc = oneBackSc;
            oneBackSc = score;
        }
        return score;
    }


    public static void main(String[] args) {
        DeleteAndEarn de = new DeleteAndEarn();
        System.out.println(de.deleteAndEarn(new int[]{3,4,2}));
        System.out.println(de.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println(de.deleteAndEarn(new int[]{3, 1}));
        System.out.println(de.deleteAndEarn(new int[]{5, 3, 7}));
        System.out.println(de.deleteAndEarn(new int[]{5, 4, 7}));
    }



}
