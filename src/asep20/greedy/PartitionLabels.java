package asep20.greedy;

import java.util.*;
//https://leetcode.com/problems/partition-labels/submissions/

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();

        int i=0;
        for(Character c: S.toCharArray()) {
            charMap.put(c, i++);
        }

        int  end =  charMap.get(S.charAt(0));
        int  start = 0;

        for (int j = start; j <= end; j++) {
            if(charMap.get( S.charAt(j) ) > end ) {
              end = charMap.get(S.charAt(j));
          }
          if(j ==  end)  {
              ans.add(end-start+1);
              start = end+1;
              if(end+1 < S.length())
              end =  charMap.get(S.charAt(end+1));
          }
        }

        return  ans;
    }


    public static void main(String[] args) {
        PartitionLabels  pl = new PartitionLabels();

//        pl.partitionLabels("ababcbacadefegdehijhklij");
//       pl.partitionLabels("caedbdedda");
//       pl.partitionLabels("eaaaabaaec");


    }

}
