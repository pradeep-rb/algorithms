package aJan22.misc;

import java.util.TreeSet;

//1395
public class CountTeams {

    /*
        Intuition:  On first glance this looks like a backtracking solution due to the increasing / decreasing subsequence.
        However, couple of things to notice
        1) the number of elements is only 3 in the subsequence, so there might be a clever technique that could might be more efficient
        2) the ask is to return the number of subsequences. there is no need to actually backtrack and find / count all the subsequences/
        // surely there is an mathematical way to get the count instead of exploring all possible subsequences and counting them

        for every element between 1 to n-1,   count the no of elements less to the left and greater to the right
         ans += less to left * greater to the right
         and vice versa for the other way
        this is a 0(n^2) soution
     */
    public int numTeams(int[] rating) {

        int result = 0;

        for (int i = 1; i < rating.length -1 ; i++) {
            int[] less = new int[2];
            int[] greater = new int[2];
            for (int j = 0; j <  rating.length; j++) {
                if( rating[i] < rating[j]) {
                   ++less[ i < j ? 0 : 1];
                }
                else if( rating[i] > rating[j]) {
                    ++greater[ i < j ? 0 : 1];
                }
            }
            result += less[0] * greater[1]  + less[1] * greater[0];

        }
        return result;
    }

    /*
        this is still 0(n^2),m as treset.size() is a O(n) function.
        if we were to use a custom DS instead of TreeSet that would give count in O(logn), the solution would be O(nlogn)

        Todo:
            re-implement with a  custom BST to get the count of elements greater or lesser than a given element in logn
     */
    public int numTeams2(int[] rating) {

        int result = 0;
        TreeSet<Integer>  left = new TreeSet<>();
        TreeSet<Integer>  right = new TreeSet<>();

        for (int i = 0; i < rating.length; i++) right.add(rating[i]);

        for (int i = 0; i <  rating.length; i++) {
            int r = rating[i];
            right.remove(r);
            result += left.headSet(r).size() * right.tailSet(r).size();
            result += right.headSet(r).size() * left.tailSet(r).size();
            left.add(r);
        }

        return result;
    }


    public static void main(String[] args) {
        CountTeams ct = new CountTeams();
        //System.out.println(ct.numTeams( new int[]{2,5,3,4,1}));
        System.out.println(ct.numTeams2( new int[]{2,5,3,4,1}));
    }

}
