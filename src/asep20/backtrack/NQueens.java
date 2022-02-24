package asep20.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://leetcode.com/problems/n-queens/
// beautiful code. marked improvement from before.
public class NQueens {
    int n=0;
    //directions for diagonal check
    // two directions are enough since we are filling only one row at a time, Its enough if we look backwards
    int[][] dirs = new int[][]{{-1,-1}, {-1,1}};
    List<List<String>> result = new ArrayList<>();

    boolean isAttacked(boolean board[][], int r, int c) {
        //check columns
        for (int i = 0; i < n; i++) {
            if (board[r][i]) return true;
        }
        //check rows
        for (int i = 0; i < n; i++) {
            if (board[i][c]) return true;
        }
        //check diagonal on 2 directions
        for(int[] dir:  dirs) {
            int i = r, j = c;
            while(i >= 0  && i < n && j >= 0 && j < n){
                if( i != r && j != c && board[i][j] ) return true;
                i = i + dir[0];
                j = j + dir[1];
            }
        }
        return false;
    }

    public void nQueens(boolean board[][], int r) {
        if(r == n){
            addToResult(board);
            return;
        }
        //At every row check for valid moves, back track if no valid moves found
        for (int j = 0; j < n; j++) { //col
            if (!isAttacked(board, r, j)) {
                board[r][j] = true;
                nQueens(board, r + 1);
                board[r][j] = false;//backtrack
            }
        }
    }

    private void addToResult(boolean[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += board[i][j] ? "Q" : ".";
            }
            ans.add(row);
        }
        result.add(ans);
    }


    public List<List<String>> solveNQueens(int n) {
        if(n == 1) {
            result.add( new ArrayList<>(Arrays.asList("Q")));
            return  result;
        }
        this.n = n;
        nQueens(new boolean[n][n], 0);
        return  result;
    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(5));
    }
}
