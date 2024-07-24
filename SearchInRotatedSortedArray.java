class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int shape = 5; // To be reassigned. 0 indicates / shape. 1 indicates / / shape

        if (len == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        if (len == 2) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[1] == target) {
                return 1;
            } else {
                return -1;
            }
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
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] <= target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
            }
            return -1;
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
            System.out.println("Found Pivot");
            int start1 = 0;
            int end1 = pivot - 1;
            int start2 = pivot;
            int end2 = len - 1;
            while (start1 <= end1) {
                int mid = (start1 + end1) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] <= target) {
                    start1 = mid + 1;
                } else if (nums[mid] > target) {
                    end1 = mid - 1;
                }
            }
            while (start2 <= end2) {
                int mid = (start2 + end2) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] <= target) {
                    start2 = mid + 1;
                } else if (nums[mid] > target) {
                    end2 = mid - 1;
                }
            }
            return -1;
        }
        return -1; // Should not reach here
    }
}