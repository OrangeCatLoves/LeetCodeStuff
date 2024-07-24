class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}