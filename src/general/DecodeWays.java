package general;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<Integer, Integer> waysMap = new HashMap<>();

    public int numDecodings(String s) {
        return  numDecodings(s, 0);
    }

    public int numDecodings(String s, int idx) {
        if(waysMap.containsKey(idx)) {
            return waysMap.get(idx);
        }

        if(idx > s.length()-1) return 1;

        int numWays = 0;
        if( idx + 1 <= s.length() &&  Integer.parseInt( s.substring(idx, idx+1)) <= 26 &&  Integer.parseInt( s.substring(idx, idx+1)) > 0 ){
            numWays += numDecodings(s, idx+1);
        }
        if( idx + 2 <= s.length() &&  Integer.parseInt( s.substring(idx, idx+2)) <= 26 &&  Integer.parseInt( s.substring(idx, idx+1)) > 0){
            numWays +=  numDecodings(s, idx+2);
        }
        waysMap.put(idx, numWays);

        return numWays;
    }




    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();

        System.out.println(dw.numDecodings("0"));
//        System.out.println(dw.numDecodings("226"));
//        System.out.println(dw.numDecodings("226221224124"));
//        System.out.println(dw.numDecodings("0"));

    }
}
