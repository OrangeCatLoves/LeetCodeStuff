/** Iterate through the entire array, if the island is not visited
perform DFS while calculating area of the island. Keep doing this
until largest area is found
*/
class Solution {
public:
    inline static int largestArea = 0;
    inline static int currLargestArea = 0;
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        // 2 means land and visited. 1 means land and not visited
        currLargestArea = 0;
        largestArea = 0;
        int maxHeight = grid.size();
        int maxWidth = grid[0].size();
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (grid[i][j] == 1) { // Not visited
                    grid[i][j] = 2;
                    currLargestArea++;
                    dfs(grid, i, j, maxHeight, maxWidth);
                    largestArea = max(largestArea, currLargestArea);
                    currLargestArea = 0;
                }
            }
        }
        return largestArea;
    }

    // Updates currLargestArea var
    void dfs(vector<vector<int>>& grid, int i, int j, int maxHeight, int maxWidth) {
        // Go Up
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            currLargestArea++;
            dfs(grid, i - 1, j, maxHeight, maxWidth);
        }
        // Go Down
        if (i + 1 < maxHeight && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            currLargestArea++;
            dfs(grid, i + 1, j, maxHeight, maxWidth);
        }
        // Go Left
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            currLargestArea++;
            dfs(grid, i, j - 1, maxHeight, maxWidth);
        }
        // Go right
        if (j + 1 < maxWidth && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            currLargestArea++;
            dfs(grid, i, j + 1, maxHeight, maxWidth);
        }
        return;
    }
};
