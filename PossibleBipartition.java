/*class Solution {
    // Cycle detection is incorrect!
    private boolean canSplit = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<int[]>> undirectedGraph = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        boolean[] visitedEdge = new boolean[dislikes.length];
        // Do a BFS down the graph of dislikes
        for (int i = 1; i <= n; i++) {
            undirectedGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            undirectedGraph.get(dislikes[i][0]).add(new int[] {dislikes[i][1], i});
            undirectedGraph.get(dislikes[i][1]).add(new int[] {dislikes[i][0], i});
        }
        for (int i = 1; i <= n; i++) {
            bfs(i, visited, visitedEdge, undirectedGraph);
        }
        return this.canSplit;
    }

    private void bfs(int node, boolean[] visited, boolean[] visitedEdge, Map<Integer, List<int[]>> graph) {
        if (visited[node]) {
            return;
        }
        List<int[]> neighbours = graph.get(node);
        Queue<Integer> currFrontier = new LinkedList<>();
        currFrontier.add(node);
        visited[node] = true;
        while (!currFrontier.isEmpty()) {
            int currNode = currFrontier.poll();
            neighbours = graph.get(currNode);
            for (int[] neighbour : neighbours) {
                int edgeIndex = neighbour[1];
                if (!visitedEdge[edgeIndex]) {
                    visitedEdge[edgeIndex] = true;
                    if (visited[neighbour[0]]) {
                        this.canSplit = false;
                        return;
                    } else {
                        currFrontier.add(neighbour[0]);
                        visited[neighbour[0]] = true;
                    }
                }
            }
        }
    }
}*/

import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Create an adjacency list for the graph
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        // Array to store the color of each node (0: uncolored, 1: red, -1: blue)
        int[] colors = new int[n + 1];

        // Use BFS to color the graph
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!bfs(i, graph, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int node, List<Integer>[] graph, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1; // Start coloring the node with red

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (colors[neighbor] == 0) {
                    // Color the neighbor with the opposite color
                    colors[neighbor] = -colors[current];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    // Found a conflict
                    return false;
                }
            }
        }

        return true;
    }
}
