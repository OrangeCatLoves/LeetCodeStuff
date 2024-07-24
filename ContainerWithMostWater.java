class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int low = 0;
        int high = len - 1;
        int largestArea = Integer.MIN_VALUE;
        while (high != low) {
            int currArea = Math.min(height[low], height[high]) * (high - low);
            if (currArea > largestArea) {
                largestArea = currArea;
            }
            if (height[low] >= height[high]) {
                high--;
            } else if (height[low] < height[high]) {
                low++;
            }
        }
        return largestArea;
    }
}