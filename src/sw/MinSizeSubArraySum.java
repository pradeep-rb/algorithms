package sw;

public class MinSizeSubArraySum {

    //https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
    /*
    Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray
    whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
     */

    /*
        log(n*k)
     */
    public static int findMinSubArray(int S, int[] arr) {


       int  j=0, sum=0, min = arr.length;

       for (int i =0 ; i < arr.length;  i++) {
           sum=0;
           j=i;
           while (sum < S && j < arr.length ) {
               sum += arr[j++];
           }
           if(sum >=  S) {
               min = Math.min(min, j - i);
           }
       }

        return min ;
    }



    public static int findMinSubArray2(int S, int[] arr) {


        int  j=0, sum=0, min = arr.length;

        for (int i =0 ; i < arr.length;  i++) {

            while (sum < S && j < arr.length ) {
                sum += arr[j++];
            }
            if(sum >=  S) {
                min = Math.min(min, j - i);
            }
            sum -= arr[i];
        }

        return min ;
    }



    public static void main(String[] args) {
        int result;
         result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);


         result = MinSizeSubArraySum.findMinSubArray2(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("2Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray2(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("2Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray2(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("2Smallest subarray length: " + result);
    }
}
