class Solution {

    private int maxDisparity = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        Helper(cookies, 0, new int[k], Integer.MIN_VALUE);
        return this.maxDisparity;
    }

    private void Helper(int[] cookies, int index, int[] distribution, int max) {
        if (index == cookies.length) {
            this.maxDisparity = Math.min(this.maxDisparity, max);
            return;
        }
        for (int i = 0; i < distribution.length; i++) {
            distribution[i] = distribution[i] + cookies[index];
            Helper(cookies, index + 1, distribution, Math.max(distribution[i], max));
            distribution[i] = distribution[i] - cookies[index];
        }
    }
}