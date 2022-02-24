package general;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r2 = matrix.length -1;
        if(r2 <0) return false;
        int c2 = matrix[0].length -1;
        if(c2 <0) return false;
        int r1 = 0;
        int c1 = 0;

        int midR = 0;
        int midC = 0;
        while (r1+1 < r2 && c1+1 < c2) {
            midR = (r1 + r2) / 2;
            midC = (c1 + c2) / 2;

            if (matrix[midR][midC] == target) return true;
            else if ( target < matrix[midR][midC] ) {
                r2 = midR -1;
                c2= midC -1;

            } else if (target > matrix[midR][midC] ) {
                r1 = midR +1;
                c1= midC +1;
            }
        }

        if ( binarySearch(matrix[r1], 0, c1, target) || binarySearch(matrix[r2], 0, c2, target)) {
            return true;
        }
        int arr1[] = new int[r1+1];
        for (int i = 0; i <= r1; i++) {
            arr1[i] = matrix[i][c1];
        }

        int arr2[] = new int[r2+1];
        for (int i = 0; i <= r2; i++) {
            arr2[i] = matrix[i][c2];
        }

        if ( binarySearch(arr2, 0, r2  , target) || binarySearch(arr1, 0, r1  , target)) {
            return true;
        }

        return false;
    }


    public  boolean binarySearch(int[] arr, int l, int r,  int target) {

        int mid = 0;
        while(l <= r) {
            mid = (r + l) / 2 ;

            if(target < arr[mid]) {
                r = mid -1;
            }
            else if(target > arr[mid]) {
                l = mid + 1;
            }
            else {
                return true;
            }
        }

        return  false ;
    }

    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
//
//        int mat[][] = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };


//        int mat[][] = new int[][]{
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}};

//        int mat[][] =  new int[][]{{1,4}, {2,5}};

        int mat[][] = new int[][]{
                {1, 2  ,3, 4,5},
                {6 ,7,  8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };


        System.out.println(sm.searchMatrix(mat, 5));
           //System.out.println(sm.binarySearch(new int[] {1, 4, 7, 11, 15},  0, 4, 6));

    }
}
