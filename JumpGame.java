class Solution {
    public boolean canJump(int[] nums) {
        int counter = 1;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (i == 0) {
                if (nums[i] < counter) {
                    return false;
                } else {
                    return true;
                }
            }
            if (nums[i] < counter) { // Means cannot reach
                counter++;
            } else { // Can Reach
                counter = 1;
            }
        }
        return true;
    }
}