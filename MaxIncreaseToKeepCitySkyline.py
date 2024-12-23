# Consider the min of the 2 max of the same row and column

class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if (n < 3):
            return 0
        totalSum = 0
        max_heights = [0] * n
        for i in range(0, n):
            for j in range(0, n):
                max_heights[i] = max(max_heights[i], grid[j][i])
        for i in range(0, n):
            for j in range(0, n):
                largest_height_in_row = max(grid[i])
                largest_height_in_col = max_heights[j]
                min_height = min(largest_height_in_row, largest_height_in_col)
                if (min_height > grid[i][j]):
                    totalSum += min_height - grid[i][j]

        return totalSum
                
