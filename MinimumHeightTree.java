/*class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, HashSet<Integer>> undirectedGraph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!undirectedGraph.containsKey(edges[i][0])) {
                undirectedGraph.put(edges[i][0], new ArrayList<>());
                undirectedGraph.get(edges[i][0]).add(edges[i][1]);
            } else {
                undirectedGraph.get(edges[i][0]).add(edges[i][1]);
            }
            if (!undirectedGraph.containsKey(edges[i][1])) {
                undirectedGraph.put(edges[i][1], new ArrayList<>());
                undirectedGraph.get(edges[i][1]).add(edges[i][0]);
            } else {
                undirectedGraph.get(edges[i][1]).add(edges[i][0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // Add leaf nodes into the queue first
        for (Integer node : undirectedGraph.keySet()) {
            if (undirectedGraph.get(node).size() == 1) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            HashSet<Integer> neighbours = undirectedGraph.get(currNode);
            for (Integer neighbour : neighbours) {
                queue.add(neighbours);
            }
            undirectedGraph.get(currNode).remove(neighbour);
            undirectedGraph.get(neighbour).remove(currNode);
        }
    }
}*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        // Create the adjacency list
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize the first layer of leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        // If the diameter of the tree is odd => 2 center nodes
        // If the diameter of the tree is even => 1 center node
        // On each iteration, when we remove the leaf node, it is guaranteed that
        // We will create a new leaf node because if there is no leaf node being formed
        // The graph is not even a tree, it is actually a cyclic graph
        // Hence, whenever we remove a leaf node, we need to check if its neighbour
        // Has become a leaf node, because whenever we remove a node, we essentially
        // Decrease its neighbour's degree by one

        // Trim the leaves until reaching the centroids
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                // Get the only neighbor directly
                int neighbor = -1;
                for (int nei : adj.get(leaf)) {
                    neighbor = nei;
                    break;
                }

                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
