package asep20.divconquer.failed;

import java.util.*;

public class MedianOfSortedArraysAttempt {


//      void split(int x[], int s, int e, int count) {
//
//      }


      double getMedian(int[] a, int sa, int ea, int[] b, int sb, int eb, int l, int r ) {


           while( ea - sa > 1 && eb - sb > 1  ) {
               // right here is pretty stupid.. split one array and the other has to be slipt accordingly
               int ma =  (sa + ea) / 2;
               int mb =  (sb + eb) / 2;

               if(a.length > 0 && a[ma] > b[mb]) {

                   if(ea - sa > 1) {
                       r += ea - ma;
                       ea = ma;

                   }
                   if(eb - sb > 1) {
                       l +=  mb - sb;
                       sb = mb;
                   }
               }
               else {
                   if(ea - sa > 1) {
                       l +=  ma - sa;
                       sa = ma;

                   }
                   if(eb - sb > 1) {
                       r +=   eb - mb;
                       eb = mb;
                   }
               }

           }

            int lRem = (a.length + b.length - 1) / 2  - l;
            int rRem = (a.length + b.length - 1) / 2  - r;


          LinkedList<Integer> q = new LinkedList<>();


          if(a.length == 1) q.add(a[sa]);
          else if(a.length > 1 ) {
              q.add(a[sa]);
              q.add(a[ea]);
          }

          if(b.length == 1) q.add(b[sb]);
          else if(b.length > 0) {
              q.add(b[sb]);
              q.add(b[eb]);
          }


          Collections.sort(q);

          for (int i = 0; i < lRem; i++) {
              q.removeFirst();
          }
          for (int i = 0; i < rRem; i++) {
              q.removeLast();
          }

          return  q.size() == 1 ?  q.get(0): (double) (q.get(0) + q.get(1))/2 ;
      }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return   getMedian(nums1, 0, nums1.length -1, nums2, 0, nums2.length -1, 0 , 0  );
    }


    public static void main(String[] args) {

        MedianOfSortedArraysAttempt msa = new MedianOfSortedArraysAttempt();
        //msa.findMedianSortedArrays(new int[] {4, 20, 32, 50, 55, 61}, new int[] {1, 5, 22, 30, 35,  70} );
        System.out.println(msa.findMedianSortedArrays(new int[] { 100}, new int[] {1,3,4,5, 6} ));

    }
}
