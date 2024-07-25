class Solution {

    int[] memoizedValues;

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        this.memoizedValues = new int[n];
        memoizedValues[0] = 1;
        memoizedValues[1] = 2;
        memoizedCall(2, n);
        return this.memoizedValues[n - 1];
    }

    public void memoizedCall(int start, int n) {
        if (start == n - 1) {
            this.memoizedValues[n - 1] = this.memoizedValues[start - 1] + this.memoizedValues[start - 2];
            return;
        }
        this.memoizedValues[start] = this.memoizedValues[start - 1] + this.memoizedValues[start - 2];
        memoizedCall(start + 1, n);
    }
}