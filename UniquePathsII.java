class Solution {

    int[][] maze;
    int r; // row
    int c; // col
    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.maze = obstacleGrid;
        this.r = obstacleGrid.length;
        this.c = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 0 && this.r == 1 && this.c == 1) { // edge case
            return 1;
        } else if (obstacleGrid[0][0] == 1) { // edge case
            return 0;
        }
        this.memo = new int[this.r][this.c];
        this.memo[0][0] = 1;
        exploreEveryPath();
        return this.memo[this.r - 1][this.c - 1];
    }

    public void exploreEveryPath() {
        /*
        4 conditions
        1) above is OOB/rock
        2) behind is OOB/rock
        3) above and behind is OOB/rock
        4) you're a rock
        */
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                if (i == 0 && j == 0) {
                    continue;
                }
                if (this.maze[i][j] == 0 && (i - 1 < 0 || this.maze[i - 1][j] == 1) && (j - 1 < 0 || this.maze[i][j - 1] == 1)) {
                    this.memo[i][j] = 0;
                } else if (this.maze[i][j] == 0 && (i - 1 < 0 || this.maze[i - 1][j] == 1)) {
                    this.memo[i][j] = this.memo[i][j - 1] + 0;
                } else if (this.maze[i][j] == 0 && (j - 1 < 0 || this.maze[i][j - 1] == 1)) {
                    this.memo[i][j] = this.memo[i - 1][j] + 0;
                } else if (this.maze[i][j] == 1) {
                    this.memo[i][j] = 0;
                } else {
                    this.memo[i][j] = this.memo[i - 1][j] + this.memo[i][j - 1];
                }
            }
        }
    }
}
