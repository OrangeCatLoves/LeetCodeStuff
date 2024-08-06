class Solution {
    public int minimumCoins(int[] prices) {
        int length = prices.length;
        Integer[][] dp = new Integer[length][length + 1];
        int ans = function(0, 0, prices, dp);
        return ans;
    }

    public int function(int ind, int free_fruits, int[] prices, Integer[][] dp) {

        if (ind == prices.length) return 0;

        if (dp[ind][free_fruits] != null) return dp[ind][free_fruits];

        int take_fruit = Integer.MAX_VALUE;
        if (free_fruits >= 1) {
            take_fruit = Math.min(prices[ind] + function(ind + 1, ind + 1, prices, dp), 0 + function(ind + 1, free_fruits - 1, prices, dp));
        } else {
            take_fruit = prices[ind] + function(ind + 1, ind + 1, prices, dp);
        }
        return dp[ind][free_fruits] = take_fruit;
    }
}