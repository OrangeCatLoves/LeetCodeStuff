class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // Initialize the DP table
        int[][] dp = new int[m + 1][n + 1];

        // Iterate over each string in the input array
        for (String str : strs) {
            // Count the number of 0s and 1s in the current string
            int[] count = countZerosOnes(str);
            int zeros = count[0];
            int ones = count[1];

            // Update the DP table in reverse order
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        // The answer is at dp[m][n]
        return dp[m][n];
    }

    // Helper method to count the number of 0s and 1s in a string
    private int[] countZerosOnes(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                count[0]++;
            } else if (c == '1') {
                count[1]++;
            }
        }
        return count;
    }
}
