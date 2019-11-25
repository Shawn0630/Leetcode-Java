public class ArrayPartition {

    public int arrayPartition(int[] array, int k) {
        if (array == null) {
             return 0;
        }

        int left = 0;
        int right = array.length - 1;

        // consider [], [a]
        while (left < right) {
            while (left < right && array[right] >= k) right--;
            while (left < right && array[left] < k) left++;
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        return left;
    }
}
