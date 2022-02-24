package asep20.divconquer;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
//https://leetcode.com/problems/median-of-two-sorted-arrays/
//4


public class MedianSortedarrays {


    public double getMedian(int[] a, int[] b) {

        int  mid = (a.length + b.length +1) / 2;

        int sb = 0;
        int eb = b.length ;
        int ma, mb;

        while( sb <= eb) {

            mb =  (sb + eb) / 2;
            //how did this happen ?
            ma =  mid - mb  ;
    
            int aLeft = ma == 0 ? Integer.MIN_VALUE: a[ma-1];
            int bLeft = mb == 0 ? Integer.MIN_VALUE:  b[mb-1];

            int aRight = ma == a.length ? Integer.MAX_VALUE : a[ma];
            int bRight =  mb == b.length ? Integer.MAX_VALUE: b[mb];

            int maxL =  Math.max( aLeft, bLeft );
            int minR =  Math.min( aRight, bRight );

            if (aLeft <= bRight &&  bLeft <= aRight) {
                //found median
                //even
                if( (a.length + b.length) % 2 ==0  ){
                    return    (double) (maxL + minR) /2 ;
                }
                else {
                    return   Math.max(aLeft, bLeft);
                }
            }
            else if( bLeft > aRight )  { // partition too far on the right of b, move to left in b
                eb = mb - 1;
            }
            else { // partition too far on the left of b, move right of b
                sb = mb + 1;
            }

        }
        return 0;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return   getMedian( nums1.length > nums2.length ? nums1 : nums2, nums1.length > nums2.length ? nums2 : nums1);
    }

    public static void main(String[] args) {
        MedianSortedarrays msa = new MedianSortedarrays();
        msa.findMedianSortedArrays(new int[] {4, 20, 32, 50, 55, 61}, new int[] {1, 5, 22, 30,   70} );
    }
}
