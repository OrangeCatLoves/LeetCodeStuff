class Solution {
    public int trap(int[] height) {
        int totalRainWater = 0;
        int n = height.length;
        int startPointer = 0;
        int endPointer = n - 1;
        int maxHeightLeft = height[0];
        int maxHeightRight = height[n - 1];
        while (startPointer != endPointer && startPointer < endPointer) {
            if (height[startPointer] < height[endPointer]) {
                startPointer++;
                maxHeightLeft = Math.max(maxHeightLeft, height[startPointer]);
                if (height[startPointer] < maxHeightLeft && height[startPointer] < maxHeightRight) {
                    totalRainWater += maxHeightLeft - height[startPointer];
                }
            } else if (height[startPointer] > height[endPointer]) {
                endPointer--;
                maxHeightRight = Math.max(maxHeightRight, height[endPointer]);
                if (height[endPointer] < maxHeightRight && height[endPointer] < maxHeightLeft) {
                    totalRainWater += maxHeightRight - height[endPointer];
                }
            } else {
                startPointer++;
                maxHeightLeft = Math.max(maxHeightLeft, height[startPointer]);
                if (height[startPointer] < maxHeightLeft && height[startPointer] < maxHeightRight) {
                    totalRainWater += maxHeightLeft - height[startPointer];
                }
            }
        }
        return totalRainWater;
    }
}
