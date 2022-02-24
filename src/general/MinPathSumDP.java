package general;

public class MinPathSumDP {
    public int minPathSum(int[][] grid) {

      if(grid.length ==0 && grid[0].length == 0)  return 0;
      int row = grid.length;
      int col = grid[0].length;

      int dp[][]  = new int[row][col];
      dp[row-1][col-1] = grid[row-1][col-1];

      int dirs[][] = { {1, 0}, {0 , 1} };



        for (int i = row-1; i >= 0 ; i--) {
            for (int j = col-1; j >= 0 ; j--) {
                if(i == row-1 && j == col -1) continue;
                int minSum = Integer.MAX_VALUE;
                for (int[] dir : dirs) {
                    int newxPos =  i + dir[0]; int newyPos = j + dir[1];
                    if( newxPos < row  && newyPos < col ) {
                        int temp = grid[i][j] +  dp[newxPos][newyPos];
                        if(temp < minSum) {
                            minSum = temp;
                        }
                    }
                }
                dp[i][j] = minSum;

            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        MinPathSumDP mp = new MinPathSumDP();

        int[][] input = new int[][]
                {{1,3,1},
                {1,5,1},
                {4,2,1}};

//        int[][] input = new int[][]
//                {{1,2},
//                {1,1}};

        System.out.println(mp.minPathSum(input));

    }


}
/*

 while(xpos !=0 || ypos !=0) {
          int minSum = Integer.MAX_VALUE;
          for (int[] dir : dirs) {
              int newxPos =  xpos + dir[0]; int newyPos = ypos + dir[1];
             if( newxPos >= 0 && newyPos >= 0 ) {
                 int temp = grid[newxPos][newyPos] +  dp[xpos][ypos];
                 if(temp < minSum) {
                     minSum = temp;
                     xpos = newxPos;
                     ypos = newyPos;
                 }
             }
          }
          dp[xpos][ypos] = minSum;
      }

 */