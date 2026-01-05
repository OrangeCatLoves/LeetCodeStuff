class Solution {
    // They want twice of it!
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 2) {
            return n;
        }
        int prevPointer = 0;
        int nextPointer = 1;
        int arrayBuilder = 0;
        int size = 0;
        while (nextPointer < n) {
            if (nums[prevPointer] != nums[nextPointer]) {
                nums[arrayBuilder] = nums[prevPointer];
                prevPointer++;
                nextPointer++;
                arrayBuilder++;
                size++;
            } else {
                while (nextPointer < n && nums[prevPointer] == nums[nextPointer]) {
                    nextPointer++;
                }
                nums[arrayBuilder] = nums[prevPointer];
                arrayBuilder++;
                prevPointer++;
                nums[arrayBuilder] = nums[prevPointer];
                arrayBuilder++;
                
                prevPointer = nextPointer;
                nextPointer++;
                size++; size++;
            }
        }
        if (prevPointer < n && nums[n - 1] != nums[n - 2]) {
            nums[arrayBuilder] = nums[prevPointer];
            size++;
        }
        return size;
    }
}
