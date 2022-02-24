package aJan22.divconq;

public class ReversePairMS {


    /*
       493.  Divide and conquer
       Build the recurrence relation: divde: one value of the pair comes from the left and the other from the right
       key observation 1: comparing every left element with something on the right gives n^2
       but when you sort the left and the right halves and maintain a pointer to elements in the left and right halves, you could do the search in linear time.
       This is because, for every element in the left ( since the right, left halves are sorted and) you only need to start the comparison from where the right pointer is -
        - this is not exactly a double loop

       key observation 2: since we are thinking of sorting in a divide and conquer context, merge sort is the ideal candidate and the  'reverse pair search' can be embeded seamlessly in the
       combine phase of the merge sort.
     */

    int mergeSort(int[] nums) {
        int res =  mergeSortSub(nums, 0, nums.length - 1);
        //Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
        System.out.println("res: " + res );
        return  res;
    }

    /*
        souped up merge sort  to find reverse pairs
     */
    private int mergeSortSub(int[] nums, int l, int r) {
        if (l >= r) return 0 ;
        int res = 0;

        int m =  (r + l) / 2;

        res += mergeSortSub(nums, l, m);
        res += mergeSortSub(nums, m+1, r);

        int i=l; int j = m+1; int k = 0;
        int p = m + 1;
        int[] merged = new int[r-l+1];

        while(i <= m) {
            /*
              when you sort the left and the right halves and maintain a pointer to elements in the left and right halves, you could do the search in linear time.
             This is because, for every element in the left ( since the right, left halves are sorted and) you only need to start the comparison from where the right pointer is
               - this is not exactly inner loop of a double nested loop set . It will only result in  n comparisons due to the pointer p.
             */
            while( p <= r && nums[i] > 2 * nums[p]) p++;
            res += p - ( m + 1);

            while (j <= r && nums[i] >= nums[j])  merged[k++] = nums[j++];
            merged[k++] = nums[i++];
        }

        while(j <= r)  merged[k++] = nums[j++];

        System.arraycopy(merged, 0, nums, l, merged.length);

        return  res;

    }


    public static void main(String[] args) {
        ReversePairMS ms = new ReversePairMS();
        ms.mergeSort(new int[] {2,4,3,5,1});

    }

}
