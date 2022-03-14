package aJan22.graph;

/*
   the implementation with DFS seems pretty straightforward.
    However, its simple only because we are looking for an increasing sequence and hence there are no cycles.
    We don't have to explicitly detect cycles which is usually the case in DFS.
    If this isn't obvious at first, you might end up writing complicated code.

 */
public class LongestIncreasingPath {

    int dirs[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private  int r,c;

    public int longestIncreasingPath(int[][] matrix) {

         r = matrix.length;
         c = matrix[0].length;

        int[][] memo = new int[r][c ];

        int ans =  0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans  = Math.max(dfs(matrix, memo, i, j), ans );
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int[][] memo, int i, int j) {

        if(memo[i][j] > 0 ) return memo[i][j];

        for (int newDir[] : dirs) {
            int x  =  i + newDir[0];
            int y  =  j + newDir[1];

            //matrix[x][y] > matrix[i][j] : this condition also takes care of the cycle, since the path is increasing
            if( 0 <= x && x < r && 0 <= y && y < c &&   matrix[x][y] > matrix[i][j] ) {
                memo[i][j]  = Math.max( dfs(matrix, memo, x, y), memo[i][j] );
            }
        }

        return ++memo[i][j];
    }


    public static void main(String[] args) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        System.out.println(lip.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
