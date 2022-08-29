package aJan22.misc;

/*
        //1010
       Variation of the classic two some problem

       Brute force is n^2. Try to do in one pass
       Intuition: Similar to two sum. Except the understanding of what it means to be a complement of a number.
       Every number is reduced to the range 0 t 60 by   t % 60.
       A complement would be the following: given t and its complement x whose existence need to be checked,    (x + t)  = multiple of 60
         x = ((multiple of 60) - t)
         reducing it to the range  0 to 60, like we did t,
         x =  ((multiple of 60) - t) % 60.

       the multiple is chosen to be  540 because the max value of t is 500. 540 is the next biggest multiple.

       General 2 sum algo:
       Maintain a map /  cache where you store every number and its freq.
       when you go through a number,
        a) check if its complement exists in the cache and if it does add it to the total count
        b) store the number in to the cache


 */
public class DivisibleBy60ModuloComplement {

    public int numPairsDivisibleBy60(int[] time) {
        int[] remCnt = new int[60];
        int ans = 0;

        for (int i = 0; i < time.length ; i++) {
            int t = time[i];
            // what I need for a modulo complement
            ans += remCnt[ (540 - t) % 60 ];
            // what I am
            remCnt[ t % 60 ] ++;
        }

        return ans;
    }
}
