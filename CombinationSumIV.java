class Solution {
    public int combinationSum4(int[] nums, int target) {
        int numsSize = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // Aim: return dp[target]
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < numsSize; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
