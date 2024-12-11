class Solution {
    public int findCenter(int[][] edges) {
        int node1 = 0;
        int node2 = 0;
        node1 = edges[0][0];
        node2 = edges[0][1];
        if (node1 == edges[1][0]) {
            return edges[1][0];
        }
        if (node2 == edges[1][0]) {
            return edges[1][0];
        }
        if (node1 == edges[1][1]) {
            return edges[1][1];
        }
        if (node2 == edges[1][1]) {
            return edges[1][1];
        }
        return 0;
    }
}