/*
class Solution {
    public int findRotateSteps(String ring, String key) {
        int r = key.length();
        int c = ring.length();
        int[][] dp = new int[r + 1][c];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < c; i++) {
            if (ring.charAt(i) == key.charAt(r - 1)) {
                dp[r - 1][i] = 1;
            }
        }

        int distance;
        int minSteps;

        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                char currChar = ring.charAt(j);
                if (currChar != key.charAt(i)) {
                    continue;
                }
                for (int futureChar = 0; futureChar < c; futureChar++) {
                    if (ring.charAt(futureChar) == key.charAt(i + 1)) {
                        distance = Math.abs(futureChar - j);
                        minSteps = Math.min(distance, c - distance) + 1;
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][futureChar] + minSteps);
                    }
                }
            }
        }

        for (int i = 0; i < c; i++) {
            if (ring.charAt(i) == key.charAt(0)) {
                distance = Math.abs(i);
                minSteps = Math.min(distance, c - distance);
                dp[0][0] = Math.min(dp[0][0], dp[0][i] + minSteps);
            }
        }
        return dp[0][0];
    }
}
*/


class Solution {
public:
    int findRotateSteps(string ring, string key) {
        int r = key.length();
        int c = ring.length();
        vector<vector<int>> dp(r + 1, vector<int>(c, INT_MAX));

        for (int i = 0; i < c; i++) {
            if (ring[i] == key[r - 1]) {
                dp[r - 1][i] = 1;
            }
        }

        int distance;
        int minSteps;

        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                char currChar = ring[j];
                if (currChar != key[i]) {
                    continue;
                }
                for (int futureChar = 0; futureChar < c; futureChar++) {
                    if (ring[futureChar] == key[i + 1]) {
                        distance = abs(futureChar - j);
                        minSteps = min(distance, c - distance) + 1;
                        dp[i][j] = min(dp[i][j], dp[i + 1][futureChar] + minSteps);
                    }
                }
            }
        }

        for (int i = 0; i < c; i++) {
            if (ring[i] == key[0]) {
                distance = abs(i);
                minSteps = min(distance, c - distance);
                dp[0][0] = min(dp[0][0], dp[0][i] + minSteps);
            }
        }
        return dp[0][0];
    }
};
