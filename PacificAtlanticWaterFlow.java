class Solution {

    int maxRow;
    int maxCol;
    boolean canReachPacific = false;
    boolean canReachAtlantic = false;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        this.maxRow = row;
        this.maxCol = col;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                initialise(visited);
                canFlowToBothOceans(heights, i, j, visited); // Should assign bool values to the fields
                if (this.canReachPacific && this.canReachAtlantic) {
                    System.out.println("Flows To Both when i = " + i + ", j = " + j);
                    List<Integer> arrList = new ArrayList<>();
                    arrList.add(i);
                    arrList.add(j);
                    result.add(arrList);
                }
                this.canReachPacific = false;
                this.canReachAtlantic = false;
            }
        }
        return result;
    }

    // You need to change some of your if conditions, Since for some cases where by i = 1, j = len - 1,
    // You have reached atlantic but could actually reach pacific and your DFS just simply terminates which is incorrect!
    public void canFlowToBothOceans(int[][] heights, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        if (row < 0 || row > this.maxRow - 1 || col < 0 || col > this.maxCol - 1) { // Out of bounds
            return;
        }
        if (this.canReachPacific && this.canReachAtlantic) {
            return;
        }
        if (row == 0 && col == this.maxCol - 1) { // Special case
            this.canReachPacific = true;
            this.canReachAtlantic = true;
            return;
        }
        if (row == this.maxRow - 1 && col == 0) { // Special case
            this.canReachPacific = true;
            this.canReachAtlantic = true;
            return;
        }
        if (row == 0 || col == 0) { // Edge of pacific
            this.canReachPacific = true;
        }
        if (row == this.maxRow - 1 || col == this.maxCol - 1) { // Edge of atlantic
            this.canReachAtlantic = true;
        }

        if (row >= 0 && row < this.maxRow - 1 && col >= 0 && col <= this.maxCol - 1) {
            if (heights[row][col] >= heights[row + 1][col] && !visited[row + 1][col]) {
                canFlowToBothOceans(heights, row + 1, col, visited);
            }
        }

        if (row > 0 && row <= this.maxRow - 1 && col >= 0 && col <= this.maxCol - 1) {
            if (heights[row][col] >= heights[row - 1][col] && !visited[row - 1][col]) {
                canFlowToBothOceans(heights, row - 1, col, visited);
            }
        }

        if (row >= 0 && row <= this.maxRow - 1 && col >= 0 && col < this.maxCol - 1) {
            if (heights[row][col] >= heights[row][col + 1] && !visited[row][col + 1]) {
                canFlowToBothOceans(heights, row, col + 1, visited);
            }
        }

        if (row >= 0 && row <= this.maxRow - 1 && col > 0 && col <= this.maxCol - 1) {
            if (heights[row][col] >= heights[row][col - 1] && !visited[row][col - 1]) {
                canFlowToBothOceans(heights, row, col - 1, visited);
            }
        }

        //System.out.println("Reached here when i = " + row + ", j = " + col);
        return;

    }

    public void initialise(boolean[][] visited) {
        int row = visited.length;
        int col = visited[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
    }
}