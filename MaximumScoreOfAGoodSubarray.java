/*class Solution {
    public int maximumScore(int[] nums, int k) {
        // Look at container with water leetcode qn first
        // How to find min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) in O(1) ?
        // Expand from index k
        // Passed only 40/73
        int len = nums.length;
        int start = k;
        int end = k;
        int largestArea = 1 * nums[k];
        int minHeight = nums[k];
        while (start > 0 || end < len - 1) {
            if (end != len - 1 && nums[end + 1] > minHeight) {
                end++;
                largestArea = Math.max(largestArea, (end - start + 1) * minHeight);
                continue;
            }
            if (start != 0 && nums[start - 1] > minHeight) {
                start--;
                largestArea = Math.max(largestArea, (end - start + 1) * minHeight);
                continue;
            }
            if (end != len - 1) {
                end++;
                minHeight = Math.min(minHeight, nums[end]);
                largestArea = Math.max(largestArea, (end - start + 1) * nums[end]);
                continue;
            }
            if (start != 0) {
                start--;
                minHeight = Math.min(minHeight, nums[start]);
                largestArea = Math.max(largestArea, (end - start + 1) * nums[start]);
                continue;
            }
        }
        return largestArea;
    }
}*/

public class Solution {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int min_val = nums[k];
        int max_score = min_val;

        while (left > 0 || right < nums.length - 1) {
            if (left == 0 || (right < nums.length - 1 && nums[right + 1] > nums[left - 1])) {
                right++;
            } else {
                left--;
            }
            min_val = Math.min(min_val, Math.min(nums[left], nums[right]));
            max_score = Math.max(max_score, min_val * (right - left + 1));
            System.out.println(left + " " + right);
        }

        return max_score;
    }
}