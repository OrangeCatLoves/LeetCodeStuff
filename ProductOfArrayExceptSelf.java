class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalResult = 1;
        int totalResultExcludingOneZero = 1;
        boolean justOnce = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && justOnce) {
                totalResult = totalResult * nums[i];
                justOnce = false;
            } else {
                totalResultExcludingOneZero = totalResultExcludingOneZero * nums[i];
                totalResult = totalResult * nums[i];
            }
        }
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                resultArr[i] = totalResultExcludingOneZero;
            } else {
                resultArr[i] = totalResult/nums[i];
            }
        }
        return resultArr;
    }
}