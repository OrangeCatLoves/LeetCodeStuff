import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> finalResult = new ArrayList<>();
        HashSet hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            Arrays.sort(nums);
            int firstValNeg = -nums[i];
            int start = i + 1; // Why i + 1, previously was 0
            int end = len - 1;
            while (start < end) {
                if (start == i) {
                    start++;
                }
                if (end == i) {
                    end--;
                }
                if (nums[start] + nums[end] == firstValNeg) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[start]);
                    subList.add(nums[end]);
                    subList.add(nums[i]);
                    Collections.sort(subList);
                    hashSet.add(subList);
                    start++;
                    end--;
                }

                if (nums[start] + nums[end] > firstValNeg) {
                    end--;
                } else if (nums[start] + nums[end] < firstValNeg) {
                    start++;
                }
            }
        }
        finalResult.addAll(hashSet);
        return finalResult;
    }
}