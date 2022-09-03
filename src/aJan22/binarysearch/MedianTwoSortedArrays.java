package aJan22.binarysearch;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] a, int[] b) {

        if ( b.length > a.length) return findMedianSortedArrays(b, a);

        int n = a.length;
        int m = b.length;

        int sb = 0, eb = m;

        while (sb <= eb) {

            int pb =  (sb + eb) / 2 ;
            // n + m + 1 :  the plus 1 is added so that in case of odd total length, partition a ends up having more numbers.
            // partition b keeps moving by a factor of log(m). so partition a needs to expressed in terms of how much partition b has moved
            int pa =   (n + m + 1) / 2 - pb;

            /*
                    pa = partion a, to the left of it is aL and at pa, we have aR
                    pb = partion b, to the left of it is bL and at pb, we have bR
             */

            int aL  = pa == 0 ? Integer.MIN_VALUE : a[pa - 1];
            int bL  = pb == 0 ? Integer.MIN_VALUE : b[pb - 1];

            int aR = pa == n ? Integer.MAX_VALUE : a[pa];
            int bR = pb == m ? Integer.MAX_VALUE : b[pb];


            if ( aL <= bR  && bL <= aR) {  // we have found the correct partition on A and B
                int maxL = Math.max(aL, bL);
                int minR = Math.min(aR, bR);

                // total length is even
                if(  (n + m) % 2 == 0 )  return   (double) (maxL + minR) / 2;
                else return   Math.max(aL, bL); // we have made sure that partition a always has one element more than b in case of odd

            }
            else if ( aL > bR ) { // bR is smaller than aL. move to the right in b.
                sb = pb + 1;
            }
            else { // bL > aR  move to the left in b
                eb = pb - 1;
            }
        }
        return 0;
    }

}
