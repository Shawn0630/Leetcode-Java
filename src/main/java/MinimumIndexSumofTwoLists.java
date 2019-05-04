import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null ||
            list1.length == 0 || list2.length == 0) {
            return new String[]{};
        }
        if (list1.length < list2.length) {
            return findRestaurant(list2, list1);
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i], i);
        }

        int minimum = Integer.MAX_VALUE;

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            if (map.containsKey(list1[i])) {
                if (i + map.get(list1[i]) < minimum) {
                    res.clear();
                    minimum = i + map.get(list1[i]);
                    res.add(list1[i]);
                } else if (i + map.get(list1[i]) == minimum) {
                    res.add(list1[i]);
                }
            }
        }

        String[] resArray = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}
