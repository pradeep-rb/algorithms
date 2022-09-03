package aJan22.misc;


// 829
/*
  //9  = 4 + 5
  //9 =  2 + 3 + 4 ( 2 +  (2 + 1) + (2+2))

   N  = x + (x+1)  + (x+2) + (x+2).. + (x+n)
   N =  (n+1)*x + (1 + 2 + 3... n)
   N - (1+ 2+ 3.. n) = (n+1)*x
   we meed to count the number of 'n's for which
   N - (1+ 2+ 3.. n) % (n + 1) == 0 is true.  (n = 1 to   as long  as N - sum > 0)
 */
public class ConsecutiveNumberSum {


    public int consecutiveNumbersSum(int N) {
        int sum = 0;
        int i = 1;
        int count = 1;

        while (N - sum > 0) {
            sum += i;
            if( N - sum > 0 && (N - sum) % (i + 1) == 0  ) count++;
            i++;
        }

        return count;
    }
}
