class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] DP = new int[amount + 1];
        DP[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            DP[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < amount + 1; i++) {
            for (int c = 0; c < coins.length; c++) {
                if (i - coins[c] >= 0 && DP[i - coins[c]] != Integer.MAX_VALUE) {
                    DP[i] = Math.min(DP[i], DP[i - coins[c]] + 1);
                }
            }
        }
        return DP[amount] == Integer.MAX_VALUE ? -1 : DP[amount];
    }
}