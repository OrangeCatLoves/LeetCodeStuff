class Solution {
    public int minPatches(int[] nums, int n) {
        int idx = 0;
        int patch = 0;
        long r = 0;
        while (r < n) {
            if (idx < nums.length && nums[idx] <= r + 1) {
                r += nums[idx];
                idx++;
            } else {
                patch++;
                r += r + 1;
            }
        }
        return patch;
    }
}