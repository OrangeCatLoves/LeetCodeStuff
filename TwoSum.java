import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) { // Key is the element itself, value is its index in nums array
            if (hashtable.containsKey(target - nums[i])) {
                if (i > hashtable.get((target - nums[i]))) {
                    int[] result = {hashtable.get(target - nums[i]), i};
                    return result;
                } else {
                    int[] result = {i, hashtable.get(target - nums[i])};
                    return result;
                }
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}