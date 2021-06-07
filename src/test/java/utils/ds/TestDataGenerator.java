package utils.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDataGenerator {
    private static final int MAX_RAND_NUM = 250;

    // Generate a list of random numbers
    static List<Integer> genRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add((int) (Math.random() * MAX_RAND_NUM));
        Collections.shuffle(lst);
        return lst;
    }

    // Generate a list of random numbers with null
    static List<Integer> genRandList(int sz, int nullSz) {
        List<Integer> lst = new ArrayList<>(sz + nullSz);
        for (int i = 0; i < sz; i++) lst.add((int) (Math.random() * MAX_RAND_NUM));
        for (int i = 0; i < nullSz; i++) lst.add(null);
        Collections.shuffle(lst);
        return lst;
    }

    // Generate a list of unique random numbers
    static List<Integer> genUniqueRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(i);
        Collections.shuffle(lst);
        return lst;
    }

    // Generate a list of unique random numbers with null
    static List<Integer> genUniqueRandList(int sz, int nullSz) {
        List<Integer> lst = new ArrayList<>(sz + nullSz);
        for (int i = 0; i < sz; i++) lst.add(i);
        for (int i = 0; i < nullSz; i++) lst.add(null);
        Collections.shuffle(lst);
        return lst;
    }
}
