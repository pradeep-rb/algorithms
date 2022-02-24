package asep20.divconquer;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int input[]  ) {

        int start = 0;
        int end = input.length - 1;

        if(input.length < 2) return  input;

        int mid = (start + end +  1 )/ 2;

        int left[] = sort( Arrays.copyOfRange(input, start, mid)  );
        int right[] = sort( Arrays.copyOfRange(input, mid , end + 1));

        int ans[]  = new int[left.length + right.length];

        int i=0, j=0, cnt=0;
        while ( i < left.length && j < right.length) {
            if(left[i] < right[j] )  ans[cnt++] = left[i++];
            else ans[cnt++] = right[j++];
        }

        int rem[] = i == left.length  ? right : left;
        int k= i == left.length ? j: i;
        while (k < rem.length) {
            ans[cnt++] =  rem[k++];
        }

        return ans;
    }



    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.sort( new int[] { 8, 4,  9, -1, 12, 0, 5, 2, 3});

    }
}
