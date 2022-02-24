package asep20.backtrack;
//1395
//https://leetcode.com/problems/count-number-of-teams/
public class CountTeams {

    int totalInc = 0;
    int totalDec = 0;

    public void numTeamsInc(int[] rating, int idx, int count) {

        if(count == 3) {
            totalInc++;
            return;
        }
        for (int i = idx + 1; i < rating.length; i++) {
            if( rating[idx] <  rating[i]) {
                 numTeamsInc(rating, i, count + 1);
            }
        }

    }

    public void numTeamsDec(int[] rating, int idx, int count) {

        if(count == 3) {
            totalDec++;
            return;
        }
        for (int i = idx + 1; i < rating.length; i++) {
            if( rating[idx] >  rating[i]) {
                numTeamsDec(rating, i, count + 1);
            }
        }

    }

    public int numTeams(int[] rating) {
        if(rating == null || rating.length == 0) return 0;

        for (int i = 0; i < rating.length - 1; i++) {
            numTeamsInc(rating, i, 1);
            numTeamsDec(rating, i, 1);
        }
         return totalInc + totalDec;
    }


    public static void main(String[] args) {
        CountTeams ct = new CountTeams();
        //System.out.println(ct.numTeamsInc( new int[] {1, 2, 3, 4, 5}));
        System.out.println(ct.numTeams( new int[] {2,5,3,4,1}));
    }



}
