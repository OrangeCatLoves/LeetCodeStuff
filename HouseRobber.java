class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] DP = new int[nums.length];
        // Each index in DP will store the maximum amount of money robbber can steal starting from that index and ending at DP.length - 1
        // Constrain is that you cannot rob adjacent houses
        DP[DP.length - 1] = nums[nums.length - 1]; // Base Case 1
        DP[DP.length - 2] = nums[nums.length - 2]; // Base Case 2
        for (int i = DP.length - 3; i >= 0; i--) {
            int largestAmt = 0;
            for (int j = i + 2; j < DP.length; j++) {
                largestAmt = Math.max(largestAmt, DP[j]);
                // Initially: largestAmt = Math.max(largestAmt + nums[i], DP[j] + nums[i]);
            }
            // Initially: DP[i] = largestAmt;
            DP[i] = largestAmt + nums[i];
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < DP.length; i++) {
            if (DP[i] > result) {
                result = DP[i];
            }
        }
        return result;
    }
}