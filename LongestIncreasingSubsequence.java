class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] DP = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            DP[i] = 1;
        }
        // Inside the DP arr, the index should represent the longest increasing subsequence length starting from the index and ending at DP.length - 1
        // It's a bottom up approach, but the index starts from the end. Intuitively , you know that the longest length starting from the last index is just
        // 1 which is itself. DP[i] = Math.max(1, 1 + DP[i + 1], 1 + DP[i + 2], ... ,1 + DP[length - 1])
        // Time Complexity: O(N^2)
        DP[DP.length - 1] = 1; // Base Case
        for (int i = DP.length - 2; i >= 0; i--) {
            int longestLen = 1;
            for (int j = i + 1; j < DP.length; j++) {
                if (nums[i] < nums[j]) {
                    longestLen = Math.max(longestLen, 1 + DP[j]);
                }
            }
            DP[i] = longestLen;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < DP.length; i++) {
            ans = Math.max(DP[i], ans);
        }
        return ans;
    }
}