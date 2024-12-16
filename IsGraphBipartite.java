/*class Solution {
    boolean isActuallyBipartite = true;
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] colors = new int[graph.length]; // 1 vs -1
        // Starting Node will always be 0
        int currColor = 1;
        queue.add(0);
        colors[0] = -1;
        while (!queue.isEmpty()) {
            int currNode = queue.remove();
            int[] neighbors = graph[currNode];
            for (int neighbor: neighbors) {
                if (colors[neighbor] != 0) { // Neighbor has already been visited
                    continue;
                }
                colors[neighbor] = -colors[currNode];
                queue.add(neighbor);
            }
        }
        // For debugging
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 1) {
                System.out.println("node: " + i + " " + "R");
            }
            if (colors[i] == -1) {
                System.out.println("node: " + i + " " + "B");
            }
            if (colors[i] == 0) {
                System.out.println("Sum Ting Wong");
            }
        }
        dfs(colors, graph, 0, new boolean[graph.length]);
        return isActuallyBipartite;
    }

    private void dfs(int[] colors, int[][] graph, int currNode, boolean[] visited) {
        if (!visited[currNode]) {
            visited[currNode] = true;
            int[] neighbors = graph[currNode];
            for (int neighbor: neighbors) {
                if (colors[currNode] == colors[neighbor]) {
                    isActuallyBipartite = false;
                }
                dfs(colors, graph, neighbor, visited);
            }
        }
    }
}*/

/* Code above failed because only 1 BFS iteration is done from node 0. Fails test case 76 specifically
   Instead, do a BFS iteration V times => Runtime: O(V^2) This accounts for cases where there are disconnected components
   in the graph as well!
*/
class Solution {
    boolean isActuallyBipartite = true;
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] colors = new int[graph.length]; // 1 vs -1
        // Iterate through all nodes to handle disconnected components
        for (int startNode = 0; startNode < graph.length; startNode++) {
            if (colors[startNode] != 0) { // Node already visited
                continue;
            }
            queue.add(startNode);
            colors[startNode] = 1;
            while (!queue.isEmpty()) {
                int currNode = queue.remove();
                int[] neighbors = graph[currNode];
                for (int neighbor : neighbors) {
                    if (colors[neighbor] == 0) { // Neighbor not visited
                        colors[neighbor] = -colors[currNode];
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[currNode]) { // Conflict
                        return false;
                    }
                }
            }
        }
        return true; // All components are bipartite
    }
}

// Python Soluton
from queue import Queue

class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        color = [0] * n
        queue = Queue()

        for i in range (n): 
            if (color[i] != 0):
                continue
            color[i] = 1
            queue.put(i)

            while not queue.empty():
                currNode = queue.get()
                neighbors = graph[currNode]
                for neighbor in neighbors:
                    if (color[neighbor] == 0):
                        color[neighbor] = -color[currNode]
                        queue.put(neighbor)
                    elif (color[neighbor] == color[currNode]):
                        return False

        return True

