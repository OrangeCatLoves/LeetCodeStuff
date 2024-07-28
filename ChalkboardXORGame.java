public class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        return nums.length % 2 == 0 || xor == 0;
    }
}