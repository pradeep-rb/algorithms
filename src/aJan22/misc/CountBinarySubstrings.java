package aJan22.misc;

//696
//learning :  jumped to the solution without seeing an obvious pattern / testing with multiple inputs
// earlier conclusions of the final answer were actually incorrect and lead to a wrong algorithm
/*
    Once you write down the count of consecutive groups of ones and zeros,
    you will see that min count between the two consecutive groups contribute to the final answer.
    Coding it up after that is trivial.


 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {

        int prevGrpCnt = 0;
        int currGrpCnt = 1;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {

            if( s.charAt(i) != s.charAt(i-1) ) {
                //the first ans > 0 is recorded after the second transition, not the first since prev = 0
                ans = Math.min(prevGrpCnt, currGrpCnt);
                prevGrpCnt = currGrpCnt;
                currGrpCnt = 1;
            }
            else currGrpCnt++;

        }
        // the end of array is treated as another transition
        ans += Math.min(prevGrpCnt, currGrpCnt);
        return  ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings("000000110011"));
    }

}
