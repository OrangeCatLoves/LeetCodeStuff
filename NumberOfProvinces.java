class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numOfCities = isConnected.length;
        boolean[] visited = new boolean[numOfCities];
        int numOfProvinces = 0;
        for (int i = 0; i < numOfCities; i++) {
            if (!visited[i]) {
                numOfProvinces++;
                dfs(isConnected, visited, i);
            }
        }
        return numOfProvinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
        return;
    }
}