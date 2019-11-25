import java.util.*;

public class IDsOfPackage {




    ArrayList<Integer> IDsOfPackages(int truckSpace, List<Integer> packagesSpace) {
        if (truckSpace - 30 <= 0 || packagesSpace == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < packagesSpace.size(); i++) {
            map.put(packagesSpace.get(i), i);
        }

        packagesSpace.sort(Comparator.comparingInt(o -> o));

        int target = truckSpace - 30;

        int left = 0;
        int right = packagesSpace.size() - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int sum = packagesSpace.get(left) + packagesSpace.get(right);
            if (sum > target) {
                right--;
            } else {
                if (max < sum) {
                    max = sum;
                }
                left++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer aPackagesSpace : packagesSpace) {
            if (map.keySet().contains(max - aPackagesSpace)) {
                res.add(map.get(aPackagesSpace));
                res.add(map.get(max - aPackagesSpace));
                break;
            }
        }

        return res;
    }
}
