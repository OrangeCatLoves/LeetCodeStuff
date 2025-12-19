class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, piles[i]);
        }
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (canEatFinishInTime(mid, n, piles, h)) {
                right = mid - 1;
                mid = left + (right - left) / 2;
            } else {
                left = mid + 1;
                mid = left + (right - left) / 2;
            }
        }
        return left;
    }

    private boolean canEatFinishInTime(int speed, int n, int[] piles, long h) {
        long time = 0;
        for (int i = 0; i < n; i++) {
            time += (piles[i] + speed - 1) / speed;
        }
        return time <= h;
    }
}
