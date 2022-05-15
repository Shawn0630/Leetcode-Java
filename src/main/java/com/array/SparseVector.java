package com.array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SparseVector {

//    int size;
//    Map<Integer, Integer> map; // index => value
    //  0       1       2       3       4
    // [1,      0,      0,      2,      3]
    // (0 => 1) (3 => 2), (4 => 3)
//    SparseVector(int[] nums) {
//        this.size = nums.length;
//        this.map = new HashMap<>();
//
//        for(int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) continue;
//            map.put(i, nums[i]);
//        }
//    }
//
//    // Return the dotProduct of two sparse vectors
//    public int dotProduct(SparseVector vec) {
//        if (size != vec.size) {
//            return -1;
//        }
//
//        if (vec.map.size() < this.map.size()) {
//            return docProduct(vec.map, this.map);
//        } else {
//            return docProduct(this.map, vec.map);
//        }
//    }
//
//    // a < b
//    private int docProduct(Map<Integer, Integer> a, Map<Integer, Integer> b) {
//        int sum = 0;
//        for(int index : a.keySet()) {
//            sum += a.get(index) * b.getOrDefault(index, 0);
//        }
//
//        return sum;
//    }


    //Option #2 Two pointers
    List<Pair<Integer, Integer>> list;
    int size;

    SparseVector(int[] nums) {
        this.size = nums.length;
        this.list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            list.add(new Pair<>(i, nums[i]));
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if(this.size != vec.size) return -1;

        int ap = 0;// this pointer to the list
        int bp = 0;// another pointer to the list

        int sum = 0;
        while (ap < this.list.size() && bp < vec.list.size()) {
            Pair<Integer, Integer> a = this.list.get(ap);
            Pair<Integer, Integer> b = vec.list.get(bp);
            if (a.getKey().equals(b.getKey())) {
                sum += (a.getValue() * b.getValue());
                ap++;
                bp++;
            } else if (a.getKey() > b.getKey()) {
                bp++;
            } else {
                ap++;
            }
        }

        return sum;
    }
}