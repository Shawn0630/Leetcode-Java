import java.util.*;

class RandomizedCollection {

    /**
     * Initialize your data structure here.
     */
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.compute(val, (key, value) -> value).add(list.size());
            list.add(val);

            return false;
        } else {
            map.put(val, new HashSet<>());
            map.compute(val, (key, value) -> value).add(list.size());
            list.add(val);

            return true;
        }

    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val).iterator().next();
            int last = list.get(list.size() - 1);
            map.get(val).remove(index);

            list.set(index, last);
            map.get(last).add(index);//first add then remove, duplicate element issue -> insert 0, remove 0
            map.get(last).remove(list.size() - 1);

            list.remove(list.size() - 1);

            if (map.get(val).size() == 0) {
                map.remove(val);
            }
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}