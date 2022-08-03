package aJan22.dynamicprog;

import java.util.HashMap;
import java.util.Map;

//1105

/*

    lesson :  in the first attempt note that the key doesn't depend on maxHeight.
    This is becuase maxHeight is never

 */
public class FilingBookCases {
    int[][] books;
    int shefWidth;

    Map<String, Integer> memo = new HashMap();


    //attempt 1
    public int findMinHeightATEEMPT1(int curr, int maxHeight, int wRem) {
        String key = curr +  ":" + wRem;
        if(memo.containsKey(key)) return memo.get(key);


        if(curr == books.length ) return 0;
        int[] currBook = books[curr];

        memo.put( key, currBook[0] <= wRem ? Math.min(  currBook[1] + findMinHeight(curr + 1, currBook[1], shefWidth - currBook[0]) , // new shelf
                (currBook[1] > maxHeight ? currBook[1] - maxHeight : 0) +  findMinHeight(curr + 1, Math.max(maxHeight, currBook[1]),wRem - currBook[0] )) // same shelf
                : currBook[1] + findMinHeight(curr + 1,  currBook[1], shefWidth - currBook[0])
        ); // new shelf

        return memo.get(key);
    }


    public int findMinHeight(int curr, int maxHeight, int wRem) {
        String key = curr  + ":" + wRem ;
        System.out.println(key);
        if(memo.containsKey(key)) return memo.get(key);


        if(curr == books.length ) return maxHeight;
        int[] currBook = books[curr];

        memo.put( key, currBook[0] <= wRem ? Math.min(   maxHeight + findMinHeight(curr + 1, currBook[1], shefWidth - currBook[0]) , // new shelf
                  findMinHeight(curr + 1, Math.max(maxHeight, currBook[1]),wRem - currBook[0] )) // same shelf
                : maxHeight + findMinHeight(curr + 1,  currBook[1], shefWidth - currBook[0])
        ); // new shelf

        return memo.get(key);
    }


    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shefWidth = shelfWidth;
        return findMinHeight(0, 0,  shelfWidth);
    }

    public static void main(String[] args) {
        FilingBookCases fbc = new FilingBookCases();
        System.out.println(fbc.minHeightShelves( new int[][]{ {1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4 ));
        //System.out.println(fbc.minHeightShelves( new int[][]{{ 1,3},{2,4},{3,2}}, 6 ));
        //System.out.println(fbc.minHeightShelves( new int[][]{{ 1,3},{2,4}}, 4 ));
    }

}
