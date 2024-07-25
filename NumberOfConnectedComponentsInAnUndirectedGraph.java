/**
 * @param n: the number of vertices
 * @param edges: the edges of undirected graph
 * @return: the number of connected components
 */

public class Solution {

    // Union-Find algorithm (O(logV))
    public int countComponents(int n, int[][] edges) {
        // write your code here
        int[] parents = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            int rootA = findParent(parents, parent);
            int rootB = findParent(parents, child);
            if (rootA != rootB) {
                parents[rootA] = rootB;
                rank[rootA]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                sum++;
            }
        }
        return sum;
    }

    public int findParent(int[] parents, int child) {
        int nextParent = parents[child];
        if (nextParent == child) {
            return child;
        } else {
            return findParent(parents, nextParent);
        }
    }
}
