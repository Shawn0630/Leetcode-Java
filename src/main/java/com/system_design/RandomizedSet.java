package com.system_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
//    List<Integer> array;
//    Map<Integer, Integer> map;
//    Queue<Integer> removed;
//    Random random;
//    public RandomizedSet() {
//        array = new ArrayList<>();
//        map = new HashMap<>();
//        removed = new LinkedList<>();
//        random = new Random();
//    }
//
//    public boolean insert(int val) {
//        if (map.containsKey(val)) {
//            return false;
//        }
//        if (removed.isEmpty()) {
//            array.add(val);
//            map.put(val, array.size() - 1);
//        } else {
//            Integer index = removed.poll();
//            array.set(index, val);
//            map.put(val, index);
//        }
//
//        return true;
//    }
//
//    public boolean remove(int val) {
//        if (!map.containsKey(val)) {
//            return false;
//        }
//        int index = map.get(val);
//        removed.offer(index);
//        array.set(index, null);
//        map.remove(val);
//
//        return true;
//    }
//
//    public int getRandom() {
//        while(true) {
//            Integer nextInt = random.nextInt(array.size());
//            if (array.get(nextInt) == null) continue;
//            return array.get(nextInt);
//        }
//    }

    Set<Integer> set;
    Map<Integer, Integer> map; // val -> index
    List<Integer> list;
    Queue<Integer> removed;
    Random random;
    public RandomizedSet() {
        set = new HashSet<>();
        map = new HashMap<>();
        list = new ArrayList<>();
        removed = new LinkedList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        if (!removed.isEmpty()) {
            int index = removed.poll();
            list.set(index, val);
            map.put(val, index);
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
        }

        return true;
    }

    public boolean remove(int val) {
        if(!set.contains(val)) {
            return false;
        }

        int index = map.get(val);
        set.remove(val);
        map.remove(val);
        list.set(index, null);
        removed.offer(index);

        return true;
    }

    public int getRandom() {
        int next;
        do {
            next = random.nextInt(list.size());
        } while (list.get(next) == null);

        return list.get(next);
    }
}
