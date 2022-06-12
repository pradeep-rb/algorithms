package aJan22.design;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;


//1396
/*
    Inorder to avoid overflow,
    instead of a running count of sum, one could store the average
    and calculate the new avg as =   avg * count + newtime /  count + 1

 */


class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> tripMap = new HashMap();
    Map<String, Integer>  totalTimeMap = new HashMap();
    Map<String, Integer>  totalCountMap = new HashMap();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        tripMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> currTrip = tripMap.remove(id);
        String tripKey =  currTrip.getKey() + ":" + stationName;
        totalTimeMap.put( tripKey, totalTimeMap.getOrDefault(tripKey, 0) +  t - currTrip.getValue() );
        totalCountMap.put( tripKey, totalCountMap.getOrDefault(tripKey, 0) +  1) ;
    }

    public double getAverageTime(String startStation, String endStation) {

        String key = startStation + ":"  + endStation;

        return new Double(totalTimeMap.get(key)) / new Double(totalCountMap.get(key));
    }
}

/*
    ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
[[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]

 */