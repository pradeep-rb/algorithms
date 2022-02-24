package sw;

class MaxSumSubArrayOfSizeK {

  //https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
  /*

  Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
   */

  public static int findMaxSumSubArray(int k, int[] arr) {

    int sum =0;
    int max=0;
    for(int i = 0 ; i <= arr.length-k; i++) {
      sum=0;
      for (int j = i; j < i+k; j++) {
        sum += arr[j];
      }
      max = Math.max(max, sum);
    }

    return max;
  }


  public static int findMaxSumSubArray2(int k, int[] arr) {

    int  sum=0, max=0, i=0;

     for(int j=0; j < arr.length; j++) {
       sum += arr[j];
       if(j >= k-1) {
         max = Math.max(sum, max);
         sum -= arr[i++];
       }
     }

    return max;
  }
  
  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));

    System.out.println("2.Maximum sum of a subarray of size K: "
            + MaxSumSubArrayOfSizeK.findMaxSumSubArray2(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("2.Maximum sum of a subarray of size K: "
            + MaxSumSubArrayOfSizeK.findMaxSumSubArray2(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}