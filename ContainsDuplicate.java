import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        HashSet hashtable = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (hashtable.contains(nums[i])) {
                return true;
            }
            hashtable.add(nums[i]);
        }
        return false;
    }
}