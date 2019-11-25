public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        /*
        *  0  1  2
        *  1  1  3
        *
        * */

        while (left < right) {
            maxArea = Math.max(maxArea, height[left] < height[right] ? height[left] * (right - left) : height[right] * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
