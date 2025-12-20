class Solution {
    // Edge case fiesta bro
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        long currSum = 0;
        int n = nums.length;
        System.out.println(n);
        if (k == n) {
            int [] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = -1;
            }
            return result;
        }
        if (2 * k >= n) {
            int [] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = -1;
            }
            return result;
        }
        if (k > n) {
            return new int[]{-1};
        }
        int left = 0;
        int idx = k;
        int right = 2 * k;
        int[] result = new int[n];
        for (int i = 0; i < 2 * k + 1; i++) {
            currSum += nums[i];
        }
        result[k] = (int)Math.floor((currSum / (long)(2 * k + 1)));
        for (int i = k + 1; i < n - k; i++) {
            System.out.println("1");
            currSum = currSum - nums[left] + nums[right + 1];
            result[i] = (int)Math.floor((currSum / (long)(2 * k + 1)));
            left++;
            right++;
        }
        for (int i = 0; i < k; i++) {
            result[i] = -1;
        }
        for (int i = n - 1; i > n - k - 1; i--) {
            result[i] = -1;
        }
        return result;
    }
}
