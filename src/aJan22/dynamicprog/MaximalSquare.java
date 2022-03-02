package aJan22.dynamicprog;


//221
public class MaximalSquare {


    //my own approach
    public int maximalSquare1(char[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int dp[][] = new int[r][c];

        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (matrix[i][j] == '1') {

                    if( i >= 1 && j >= 1  && matrix[i-1][j-1] == '1') {
                        int x = new Double(Math.sqrt( dp[i-1][j-1])).intValue();
                        int k = 1;
                        while (k <= x) {
                            if ( matrix[i-k][j] == '0' || matrix[i][j-k] == '0')  break;
                            k++;
                        }
                        dp[i][j] = new Double(Math.pow( k , 2 )).intValue();
                    }
                    else {
                        dp[i][j] = 1;
                    }

                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return  max;
    }


    //a better approach to eliminate the inner while loop
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length,c = matrix[0].length;
        int dp[][] = new int[r+1][c+1];
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1')  dp[i+1][j+1] = Math.min( dp[i][j],  Math.min(dp[i][j+1], dp[i+1][j]) ) + 1;
                max = Math.max(max,  dp[i+1][j+1]);
            }
        }
        return  max * max;
    }


    public static void main(String[] args) {
          MaximalSquare ms = new MaximalSquare();

//        System.out.println(ms.maximalSquare(new char[][]{{ '1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'  }} ));
//        System.out.println(ms.maximalSquare(new char[][]{{ '1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','1','1','1'  }} ));
//        System.out.println(ms.maximalSquare(new char[][]{{ '0', '1' }, { '1', '0' }} ));
//        System.out.println(ms.maximalSquare(new char[][]{{ '0' } } ));
//        System.out.println(ms.maximalSquare(new char[][]{{ '1', '1' }, { '1', '1' }} ));
//        System.out.println(ms.maximalSquare(new char[][]{{ '0','0','0','1'}, {'1','1','0','1'}, {'1','1','1','1'}, {'0','1','1','1' }, {'0','1','1','1' }} ));
        System.out.println(ms.maximalSquare(new char[][]{{ '1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'  }} ));
        System.out.println(ms.maximalSquare(new char[][]{{ '1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','1','1','1'  }} ));
        System.out.println(ms.maximalSquare(new char[][]{{ '0', '1' }, { '1', '0' }} ));
        System.out.println(ms.maximalSquare(new char[][]{{ '0' } } ));
        System.out.println(ms.maximalSquare(new char[][]{{ '1', '1' }, { '1', '1' }} ));
        System.out.println(ms.maximalSquare(new char[][]{{ '0','0','0','1'}, {'1','1','0','1'}, {'1','1','1','1'}, {'0','1','1','1' }, {'0','1','1','1' }} ));


    }

}
