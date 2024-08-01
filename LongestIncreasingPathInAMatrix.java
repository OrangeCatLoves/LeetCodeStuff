/*class Solution {
    private int result = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return matrix[0][0];
        }
        int[][] DP = new int[row][col]; // Stores the current longest increasing path len at the position
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.result = Math.max(this.result, dfs(matrix, DP, i, j, i, j, 1));
            }
        }
        return this.result;
    }

    private int dfs(int[][] matrix, int[][] DP, int startRow, int startCol, int row, int col, int max) {
        if (row - 1 >= 0 && matrix[row - 1][col] > matrix[row][col]) { // Move up

            DP[startRow][startCol] = Math.max(max + 1, DP[startRow][startCol]);
            return dfs(matrix, DP, startRow, startCol, row - 1, col, DP[startRow][startCol]);
        }
        if (row + 1 <= matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) { // Move down

            DP[startRow][startCol] = Math.max(max + 1, DP[startRow][startCol]);
            return dfs(matrix, DP, startRow, startCol, row + 1, col, DP[startRow][startCol]);
        }
        if (col - 1 >= 0 && matrix[row][col - 1] > matrix[row][col]) { // Move left

            DP[startRow][startCol] = Math.max(max + 1, DP[startRow][startCol]);
            return dfs(matrix, DP, startRow, startCol, row, col, DP[startRow][startCol]);
        }
        if (col + 1 <= matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) { // Move right

            DP[startRow][startCol] = Math.max(max + 1, DP[startRow][startCol]);
            return dfs(matrix, DP, startRow, startRow, row, col + 1, DP[startRow][startCol]);
        }
        // Can't move anymore not because of out of bounds but all surroundings nums are smaller
        return DP[startRow][startCol];
    }
}*/

class Solution {
    private int result = 0;
    private int[] dirX = {-1, 1, 0, 0};
    private int[] dirY = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }

        int[][] DP = new int[row][col]; // Stores the longest increasing path length at the position

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.result = Math.max(this.result, dfs(matrix, DP, i, j));
            }
        }
        return this.result;
    }

    private int dfs(int[][] matrix, int[][] DP, int row, int col) {
        if (DP[row][col] != 0) {
            return DP[row][col];
        }
        int maxLen = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirX[i];
            int newCol = col + dirY[i];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[row][col]) {
                int len = 1 + dfs(matrix, DP, newRow, newCol);
                maxLen = Math.max(maxLen, len);
            }
        }

        DP[row][col] = maxLen;
        return DP[row][col];
    }
}
