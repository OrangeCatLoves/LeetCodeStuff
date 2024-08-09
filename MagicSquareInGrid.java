class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int numOfMagicSquares = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (isMagicSquare(i, j, grid)) {
                    numOfMagicSquares++;
                }
            }
        }
        return numOfMagicSquares;
    }

    private boolean isMagicSquare(int row, int col, int[][] grid) {
        boolean[] contains = new boolean[9];
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                if (grid[i][j] > 9 || grid[i][j] <= 0) {
                    return false;
                } else {
                    contains[grid[i][j] - 1] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!contains[i]) {
                return false;
            }
        }
        int sum = grid[row - 1][col - 1] + grid[row - 1][col] + grid[row - 1][col + 1]; // Sum of the first row
        // Rows wise
        for (int i = row - 1; i < row + 2; i++) {
            int calculatedSum = 0;
            for (int j = col - 1; j < col + 2; j++) {
                calculatedSum = calculatedSum + grid[i][j];
            }
            if (calculatedSum != sum) {
                return false;
            }
            calculatedSum = 0;
        }
        // Columns wise
        for (int i = col - 1; i < col + 2; i++) {
            int calculatedSum = 0;
            for (int j = row - 1; j < row + 2; j++) {
                calculatedSum = calculatedSum + grid[j][i];
            }
            if (calculatedSum != sum) {
                return false;
            }
            calculatedSum = 0;
        }
        // Diagonal wise
        if (grid[row - 1][col - 1] + grid[row][col] + grid[row + 1][col + 1] != sum) return false;
        if (grid[row - 1][col + 1] + grid[row][col] + grid[row + 1][col - 1] != sum) return false;
        return true;
    }
}