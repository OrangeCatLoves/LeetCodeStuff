/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/** Build the graph as you perform a DFS from the starting node
 Establish a HashMap<Integer, Node> for each node
 Recurse on all the neighbors
 Ensure to keep track of each visited nodes
 Runtime: O(V + E) */
class Solution {
    private Node firstNode;
    private Node currNodeInDfs;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> uniqueNodes = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        dfs(node, uniqueNodes, visited);
        return firstNode;
    }

    private void dfs(Node node, HashMap<Integer, Node> uniqueNodes, HashSet<Integer> visited) {
        System.out.println("1");
        if (!visited.contains(node.val)) {
            visited.add(node.val);
            if (!uniqueNodes.containsKey(node.val)) {
                currNodeInDfs = new Node(node.val);
                uniqueNodes.put(node.val, currNodeInDfs);
            } else {
                currNodeInDfs = uniqueNodes.get(node.val);
            }
            List<Node> neighbors = node.neighbors;
            for (Node neighbor: neighbors) {
                if (!uniqueNodes.containsKey(neighbor.val)) {
                    Node n = new Node(neighbor.val);
                    uniqueNodes.put(neighbor.val, n);
                    currNodeInDfs.neighbors.add(n);
                } else {
                    Node n = uniqueNodes.get(neighbor.val);
                    currNodeInDfs.neighbors.add(n);
                }
            }
            if (node.val == 1) {
                firstNode = uniqueNodes.get(1);
            }
            List<Node> neighborss = new CopyOnWriteArrayList<>(neighbors);
            for (Node neighbor: neighborss) {
                dfs(neighbor, uniqueNodes, visited);
            }
        }
    }
}