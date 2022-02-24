package general;

import java.util.ArrayList;
import java.util.List;
//does not work, ugly as hell, check asep20 package
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        //  board[0][1] = 1;
        nQueens(board, n);

        List<List<String>> qBoard = new ArrayList<>();
        List<String> brdList = new ArrayList<>();

        for(int i=0; i< board.length; i++ ) {
            System.out.println("");

            String ans = "";
            for (int j = 0; j < board.length; j++) {
                if( board[i][j] == 1) {
                    ans += "Q";
                }
                else {
                    ans += ".";
                }

                if(j == board.length -1) {
                    brdList.add(ans);
                    ;                }
                System.out.print( board[i][j] + " ");
            }
        }
        qBoard.add(brdList);

        return qBoard;
    }

    boolean nQueens(int[][] board, int N) {

        if(N == 0) return  true;
        for(int i=0; i< board.length; i++ ) {
            for(int j=0; j< board.length; j++ ) {
                if( isAttacked(i, j, board, N)) {
                    continue;
                }
                board[i][j] = 1;
                if(nQueens(board,   N-1)) {
                    return true;
                }
                board[i][j] = 0;
            }
        }
        return false;
    }


    boolean isAttacked(int i, int j, int[][] board,int  N) {

        //if(board[i][j] == 1 ) return  true;

        for(int x=0; x < board.length; x++) {
            if(board[x][j] == 1)  return  true;
        }

        for(int x=0; x < board.length; x++) {
            if(board[i][x] == 1)  return  true;
        }

        int dirs[][]  = new int[][]{ {1,1}, {-1,-1}, {-1, 1}, {1, -1} };

        for (int[] dir : dirs) {
            int xPos = 0;
            int yPos = 0;
            for(int q=0; q<board.length; q++) {
                xPos =  i  + dir[0] * q;
                yPos =  j  + dir[1] * q;

                if(xPos < 0 || xPos > board.length-1 || yPos < 0 || yPos > board.length-1) {
                    break;
                } else if (board[xPos][yPos] == 1 ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
