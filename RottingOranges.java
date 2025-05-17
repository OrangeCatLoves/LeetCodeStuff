// Multi-sourced BFS solution in Java
class Solution {
    public int orangesRotting(int[][] grid) {
        int maxWidth = grid[0].length;
        int maxHeight = grid.length;
        Queue<int[]> currFrontier = new LinkedList<>();
        Queue<int[]> nextFrontier = new LinkedList<>();
        Queue<int[]> temp;
        int counter = 0; // To be returned
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (grid[i][j] == 2) {
                    currFrontier.add(new int[] {i, j});
                }
            }
        }
        int currHeight;
        int currWidth;
        while (!currFrontier.isEmpty()) {
            int[] currOrange = currFrontier.poll();
            currHeight = currOrange[0];
            currWidth = currOrange[1];
            int y = currHeight;
            int x = currWidth;
            // Look upwards
            if (currHeight - 1 >= 0 && grid[currHeight - 1][currWidth] == 1) {
                nextFrontier.offer(new int[] {currHeight - 1, currWidth});
                grid[y - 1][x] = 2;
            }
            // Look downwards
            if (currHeight + 1 < maxHeight && grid[currHeight + 1][currWidth] == 1) {
                nextFrontier.offer(new int[] {currHeight + 1, currWidth});
                grid[y + 1][x] = 2;
            }
            // Look left
            if (currWidth - 1 >= 0 && grid[currHeight][currWidth - 1] == 1) {
                nextFrontier.offer(new int[] {currHeight, currWidth - 1});
                grid[y][x - 1] = 2;
            }
            // Look right
            if (currWidth + 1 < maxWidth && grid[currHeight][currWidth + 1] == 1) {
                nextFrontier.offer(new int[] {currHeight, currWidth + 1});
                grid[y][x + 1] = 2;
            }
            if (currFrontier.isEmpty() && !nextFrontier.isEmpty()) {
                temp = currFrontier;
                currFrontier = nextFrontier;
                nextFrontier = temp;
                counter++;
            }
        }
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return counter;
    }
}

