class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int shape = 5; // To be reassigned. 0 indicates / shape. 1 indicates / / shape

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if (nums[start] > nums[end]) {
            shape = 1;
        } else if (nums[start] < nums[end]) {
            shape = 0;
        }

        boolean stillTrue = true;
        int pivot = 0; // To be reassigned

        if (shape == 0) {
            System.out.println("Case 0");
            return nums[0];
        } else if (shape == 1) {
            System.out.println("Case 1");
            while (stillTrue) { // To find pivot index
                int mid = 1 + (start + end) / 2;
                if (nums[mid] < nums[mid - 1]) {
                    pivot = mid;
                    stillTrue = false;
                } else if (nums[mid - 1] >= nums[mid]) {
                    pivot = mid + 1;
                    stillTrue = false;
                }

                if (nums[mid] > nums[start]) { // Recurse right
                    start = mid;
                } else if (nums[mid] <= nums[end]) { // Recurse left
                    end = mid - 1;
                }
            }
            return nums[pivot];
        }
        return -1;
    }
}