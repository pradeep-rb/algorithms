package asep20.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/partition-labels/submissions/
public class PartitionLabels2 {

    public List<Integer> partitionLabels(String S) {

        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();

        int i=0;
        for(Character c: S.toCharArray()) {
            charMap.put(c, i++);
        }

        int cnt = 0;
        int end=Integer.MIN_VALUE;

        for (int j = 0; j < S.length() ; j++) {
            end = Math.max(end,  charMap.get(S.charAt(j)));
            cnt++;
            if(j == end) {
                ans.add(cnt);
                cnt=0;
            }
        }

        return  ans;
    }


    public static void main(String[] args) {
        PartitionLabels2 pl = new PartitionLabels2();

        pl.partitionLabels("ababcbacadefegdehijhklij");
       pl.partitionLabels("caedbdedda");
       pl.partitionLabels("eaaaabaaec");
    }

}
