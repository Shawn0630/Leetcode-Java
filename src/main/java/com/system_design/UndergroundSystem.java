package com.system_design;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    // Map from station -> average time
    //
    Map<String, Pair<Integer, Integer>> averageTime;
    Map<Integer, Pair<String, Integer>> checkIns;
    public UndergroundSystem() {
        averageTime = new HashMap<>();
        checkIns = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        int checkInTime = checkIns.get(id).getValue();
        String start = checkIns.get(id).getKey();

        String key = start + "#" + stationName;
        int duration = t - checkInTime;

        if (averageTime.containsKey(key)) {
            Pair<Integer, Integer> pair = averageTime.get(key);
            averageTime.put(key, new Pair<>(pair.getKey() + 1, pair.getValue() + duration));
        } else {
            averageTime.put(key, new Pair<>(1, duration));
        }
    }

    public double getAverageTime(String startStation, String endStation) {

        return (double)averageTime.get(startStation + "#" + endStation).getValue() / (double)averageTime.get(startStation + "#" + endStation).getKey();
    }
}
