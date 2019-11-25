import java.util.*;

public class AmazonPrimeAir {
    public List<List<Integer>> solution(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {

        if (forwardRouteList == null || forwardRouteList.size() == 0 ||
            returnRouteList == null || returnRouteList.size() == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> forwardMap = new HashMap<>();
        Map<Integer, List<Integer>> returnMap = new HashMap<>();
        for(List<Integer> forward : forwardRouteList) {
            forwardMap.computeIfAbsent(forward.get(1), ignore -> new ArrayList<>());
            forwardMap.get(forward.get(1)).add(forward.get(0));
        }
        for(List<Integer> returnRoute : returnRouteList) {
            returnMap.computeIfAbsent(returnRoute.get(1), ignore -> new ArrayList<>());
            returnMap.get(returnRoute.get(1)).add(returnRoute.get(0));
        }

        forwardRouteList.sort(Comparator.comparingInt(o -> o.get(1)));
        returnRouteList.sort(Comparator.comparingInt(o -> o.get(1)));

        int start = 0;
        int end = returnRouteList.size() - 1;

        int maxDist = Integer.MIN_VALUE;

        while (start < forwardRouteList.size() && end >= 0) {
            int sum = forwardRouteList.get(start).get(1) + returnRouteList.get(end).get(1);
            if (sum <= maxTravelDist && sum > maxDist) {
                maxDist = sum;
            } else if (sum > maxTravelDist) {
                end--;
            } else {
                start++;
            }
        }

        while (start < forwardRouteList.size()) {
            int sum = forwardRouteList.get(start).get(1) + returnRouteList.get(0).get(1);
            if (sum <= maxTravelDist && sum > maxDist) {
                maxDist = sum;
                start++;
            } else {
                break;
            }
        }

        while (end >= 0) {
            int sum = forwardRouteList.get(forwardRouteList.size() - 1).get(1) + returnRouteList.get(end).get(1);
            if (sum > maxTravelDist) {
                end--;
            } else if (sum <= maxTravelDist) {
                maxDist = sum;
                break;
            }
        }

        for(Map.Entry<Integer, List<Integer>> forwardMapEntry : forwardMap.entrySet()) {
            if (returnMap.containsKey(maxDist - forwardMapEntry.getKey())) {
                for(Integer forwardId : forwardMapEntry.getValue()) {
                    for(Integer returnId : returnMap.get(maxDist - forwardMapEntry.getKey())) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(forwardId);
                        pair.add(returnId);
                        list.add(pair);
                    }
                }
            }
        }

        return list;
    }
}
