package general;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        char[] wordArr = word.toCharArray();

        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j] == wordArr[0]) {
                    board[i][j] = '0';
                    if(dfs(board, i, j , wordArr, 1)) return true;
                    board[i][j] = wordArr[0];
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, int x, int y, char[] word, int k) {
        int rows = board.length;
        int cols = board[0].length;

        if(k == word.length){
            return true;
        }

        int dirs[][]  = new int[][]  {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        for(int[] dir: dirs)  {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if( x1 >= 0 && x1 < rows && y1 >=0 && y1 < cols  && board[x1][y1] == word[k]) {
                board[x1][y1] = '0';
                if( dfs(board, x1, y1 , word, k+1)) return  true;
                board[x1][y1] = word[k];
            }

        }

        return  false;
    }


    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        
        char board[][] = new char[][]
                        {
                          {'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}
                        };
       // System.out.println(ws.exist(board, "ABCCED"));

        board = new char[][]
                {
                        {'a', 'a'},
                };
       // System.out.println(ws.exist(board, "aaa"));
        
        board = new char[][]  {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        System.out.println(ws.exist(board, "AAB"));
                
        

    }
}
