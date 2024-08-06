/*class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // TLE at 40/51
        int max = Integer.MIN_VALUE;
        int[] currMaxArr = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            currMaxArr[i] = max;
            max = Integer.MIN_VALUE;
        }
        return currMaxArr;

        // Failed [1, -1] k = 1
        currMaxArr[0] = max;
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                currMaxArr[index] = max;
            } else {
                currMaxArr[index] = max;
            }
            index++;
        }
        return currMaxArr;
    }
}*/
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements not within the sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element at the end of the deque
            deque.offerLast(i);

            // The largest element in the current window is at the front of the deque
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
