class Solution {
    public int maxProduct(int[] nums) {
        // Could pass 174/190 testcases
        /*int numOfNegs = 0;
        int len = nums.length;
        int allIntProduct = 1;
        boolean first = true;
        boolean last = true;
        int firstNegIntIdx = 0; // For odd case
        int lastNegIntIdx = len - 1; // For odd case
        int result1 = 1; // For odd case
        int result2 = 1; // For odd case
        boolean everAssigned = false;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Integer.max(nums[0] * nums[1], Integer.max(nums[0], nums[1]));
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                numOfNegs++;
            }
            allIntProduct = allIntProduct * nums[i];
        }
        int currLargest = Integer.MIN_VALUE;
        int accLargest = 1;

        for (int i = 0; i < len; i++) { // Handle Zeroes
            if (nums[i] == 0) {
                if (currLargest < accLargest) {
                    currLargest = accLargest;
                }
                accLargest = 1;
            } else {
                accLargest = accLargest * nums[i];
                if (currLargest < accLargest) {
                    currLargest = accLargest;
                }
            }
        }

        if (numOfNegs % 2 == 0) {
            return Integer.max(allIntProduct, currLargest);
        } else {
            for (int i = 0; i < len; i++) {
                if (nums[i] < 0 && first) {
                    firstNegIntIdx = i;
                    first = false;
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] < 0 && last) {
                    lastNegIntIdx = i;
                    last = false;
                }
            }
            for (int i = 0; i < lastNegIntIdx; i++) {
                result1 = result1 * nums[i];

            }
            for (int i = firstNegIntIdx + 1; i < len; i++) {
                result2 = result2 * nums[i];

            }
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(currLargest);
            return Integer.max(result1, Integer.max(result2, currLargest));
        }*/
        int prefix = 1;
        int suffix = 1;
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length-i-1];
            currMax = Math.max(currMax,Math.max(prefix,suffix));
        }
        return currMax;
    }
}