package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRank2 {

    public static int countTeams(int count, int k) {
        int cnt = 0;
        if(k == 0) {
            return  0;
        }
        else {
            for (int i = 1; i <= count; i++) {
                for (int j = 0; j < count; j++) {
                    cnt += 1 + countTeams(count - i, k - 1);
                }
            }
        }
        return cnt;
    }


    public static int countTeams(List<Integer> skills, int k, int l, int r) {
        // Write your code here

        List<Integer> team = new ArrayList<>();
        for(int skill : skills) {
            if( skill >= l && skill <= r) {
                team.add(skill);
            }
        }

        return countTeams(team.size(), k);
        //return countTeams(2,1);

    }

    public static void main(String[] args) {

        HackerRank2 hr =  new HackerRank2();

        System.out.println(hr.countTeams(Arrays.asList(new Integer[]{ 4, 8, 5, 6}),
                1, 5, 7));

    }
}
