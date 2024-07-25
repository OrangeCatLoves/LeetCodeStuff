class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        int[] firstRow = new int[n];
        int[] nextRow = new int[n];
        nextRow[n - 1] = 1; // Base Case
        for (int i = m - 1; i >= 0; i--) { // Current row
            for (int j = n - 1; j >= 0; j--) { // Current column
                if (j + 1 < n) {
                    nextRow[j] = nextRow[j] + firstRow[j] + nextRow[j + 1];
                } else {
                    nextRow[j] = nextRow[j] + firstRow[j];
                }
            }
            firstRow = nextRow;
            nextRow = new int[n];
        }
        return firstRow[0];
    }
}