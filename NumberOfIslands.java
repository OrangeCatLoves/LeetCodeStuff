class Solution {

    int maxRowLen;
    int maxColLen;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        maxRowLen = row;
        maxColLen = col;
        boolean[][] visited = new boolean[row][col];
        int numOfIslands = 0;
        // Initialisation
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        // Actual DFS
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    DepthFirstTraversal(grid, visited, i, j);
                    numOfIslands++;
                }
            }
        }
        // For error checking
        for (int i = 0; i < row; i++) {
            System.out.print("Row" + i + " :");
            for (int j = 0; j < col; j++) {
                System.out.print(" " + visited[i][j]);
            }
            System.out.println();
        }
        return numOfIslands;
    }

    public void DepthFirstTraversal(char[][] island, boolean[][] booleanGrid, int row, int col) {
        // Check for out of array boundary
        if (row > maxRowLen - 1 || row < 0 || col > maxColLen - 1 || col < 0) {
            return;
        }
        if (booleanGrid[row][col] || island[row][col] == '0') {
            return;
        }
        booleanGrid[row][col] = true;

        DepthFirstTraversal(island, booleanGrid, row + 1, col);
        DepthFirstTraversal(island, booleanGrid, row - 1, col);
        DepthFirstTraversal(island, booleanGrid, row, col + 1);
        DepthFirstTraversal(island, booleanGrid, row, col - 1);
    }
}