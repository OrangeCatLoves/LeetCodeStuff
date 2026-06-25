class Solution {
    int M = 1000000007;
    int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return recurse(m, n, maxMove, startRow, startColumn);
    }

    private int recurse(int m, int n, int maxMove, int currRow, int currCol) {
        System.out.println("r => " + currRow + " c => " + currCol + " maxMove => " + maxMove);
        if (currRow == m || currCol == n || currRow < 0 || currCol < 0) {
            return 1;
        } else if (maxMove == 0) {
            return 0;
        } else if (this.dp[currRow][currCol][maxMove] >= 0) {
            return this.dp[currRow][currCol][maxMove];
        } else {
            this.dp[currRow][currCol][maxMove] = ((recurse(m, n, maxMove - 1, currRow + 1, currCol) + recurse(m, n, maxMove - 1, currRow - 1, currCol)) % M + (recurse(m, n, maxMove - 1, currRow, currCol + 1) + recurse(m, n, maxMove - 1, currRow, currCol - 1)) % M) % M;

            return this.dp[currRow][currCol][maxMove];
        }
    }
}
