package com.system_design;





import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.put(key, map.getOrDefault(key, new ArrayList<>()));
        map.get(key).add(new Pair<>(timestamp, value));
    }

    //   def bisect_left(self, a, x):
    //		'''returns i where all a[:i] is less than x'''
    //        lo, hi = 0, len(a)
    //        while lo < hi:
    //            mid = lo + (hi - lo) // 2
    //            if a[mid] < x: lo = mid + 1
    //            else: hi = mid
    //        return lo
    //
    //    def bisect_right(self, a, x):
    //		'''returns i where all a[:i] is less than or equal to x'''
    //        lo, hi = 0, len(a)
    //        while lo < hi:
    //            mid = lo + (hi - lo) // 2
    //            if a[mid] > x: hi = mid
    //            else: lo = mid + 1
    //        return lo
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } else {
            // find greater than
            List<Pair<Integer, String>> nodes = map.get(key);
            int left = 0, right = nodes.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                Pair<Integer, String> pair = nodes.get(mid);
                if (pair.getKey() > timestamp) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } // exit condition left == right
            return left == 0 ? "" : nodes.get(left - 1).getValue();
        }
    }
}
