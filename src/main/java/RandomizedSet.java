import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
           int indexToRemove = map.get(val);
           int last = list.get(list.size() - 1);
           list.set(indexToRemove, last);
           map.put(last, indexToRemove);

           list.remove(list.size() - 1);
           map.remove(val);

           return true;
        }

        return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {

        int rnd = rand.nextInt(list.size());
        return list.get(rnd);
    }
}
