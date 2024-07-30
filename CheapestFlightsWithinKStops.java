/*class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> directedGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            directedGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int[] flightInfo = flights[i];
            int[] flightData = {flightInfo[1], flightInfo[2]};
            directedGraph.get(flightInfo[0]).add(flightData);
        }
        Integer[] cheapestPrice = new Integer[n];
        for (int i = 0; i < n; i++) {
            cheapestPrice[i] = Integer.MAX_VALUE;
        }
        cheapestPrice[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {src, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currCost = curr[1];
            int currStops = curr[2];

            // If the current node is the destination, return the cost
            if (currNode == dst) return currCost;

            // If there are stops left, explore the neighbors
            if (currStops <= k) {
                List<int[]> edges = directedGraph.get(currNode);
                for (int[] edge : edges) {
                    int nextNode = edge[0];
                    int nextCost = edge[1];

                    // Calculate the new cost to reach the next node
                    int newCost = currCost + nextCost;
                    if (newCost < cheapestPrice[nextNode]) {
                        cheapestPrice[nextNode] = newCost;
                        pq.offer(new int[]{nextNode, newCost, currStops + 1});
                    }
                }
            }
        }
        return cheapestPrice[dst] == Integer.MAX_VALUE ? -1 : cheapestPrice[dst];
    }
}*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new List[n];
        for (int i = 0; i < n; ++ i) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adjList[flight[0]].add(new int[] {flight[1], flight[2]});
        }
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        Queue<int[]> heap = new PriorityQueue<>((left, right) -> (left[1] - right[1]));
        heap.add(new int[] {src, 0, 0});
        int kPlus = k + 1;
        while (!heap.isEmpty()) {
            int[] next = heap.poll();
            int city = next[0];
            int distance = next[1];
            int steps = next[2];
            if (steps >= stops[city] || steps > kPlus) {
                continue;
            }
            stops[city] = steps;
            if (city == dst) {
                return distance;
            }
            else {
                for (int[] adj : adjList[city]) {
                    heap.add(new int[] {adj[0], distance + adj[1], steps + 1});
                }
            }
        }
        return -1;
    }
}