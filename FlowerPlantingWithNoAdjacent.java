/*class Solution {
    // Passed only 18/51. Testcase 23!
    public int[] gardenNoAdj(int n, int[][] paths) {
        if (n == 1) {
            return new int[]{1};
        }
        if (paths.length == 0) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = 1;
            }
            return result;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Initialisation of undirected graph
        for (int i = 0; i < paths.length; i++) {
            if (!graph.containsKey(paths[i][1])) {
                graph.put(paths[i][1], new ArrayList<>());
                graph.get(paths[i][1]).add(paths[i][0]);
            } else {
                graph.get(paths[i][1]).add(paths[i][0]);
            }
            if (!graph.containsKey(paths[i][0])) {
                graph.put(paths[i][0], new ArrayList<>());
                graph.get(paths[i][0]).add(paths[i][1]);
            } else {
                graph.get(paths[i][0]).add(paths[i][1]);
            }
        }
        int currentColor = 1;
        int[] coloured = new int[n]; // Numbered [1, 4], 0 means not visited yet
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i + 1)) { // Standalone garden with zero neighbors
                coloured[i] = 1;
                continue;
            }
            if (coloured[i] == 0) {
                queue.add(i); // Queue contains the index (starting from 0)
                coloured[i] = currentColor;
                while (!queue.isEmpty()) {
                    int currGarden = queue.poll();
                    List<Integer> neighbors = graph.get(currGarden + 1);
                    int parentColor = coloured[currGarden];
                    for (Integer neighbor : neighbors) { // At most 3 neighbors
                        if (coloured[neighbor - 1] == 0) { // Not visited
                            if (parentColor == 4) {
                                parentColor = 1;
                            } else {
                                parentColor++;
                            }
                            queue.add(neighbor - 1);
                            coloured[neighbor - 1] = parentColor;
                        }
                    }
                }
            }
            currentColor = 1;
        }
        return coloured;
    }
}*/

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        // Create an array to store the colors of each garden
        int[] colors = new int[N];

        // Create an array of lists to store the neighbors of each garden
        List<Integer>[] neighbors = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            neighbors[i] = new ArrayList<>();
        }

        // Populate the neighbors list with paths information
        for (int[] path : paths) {
            neighbors[path[0] - 1].add(path[1] - 1);
            neighbors[path[1] - 1].add(path[0] - 1);
        }

        // Iterate through each garden and assign a color
        for (int i = 0; i < N; i++) {
            // Boolean array to check if a color is already used by neighbors
            boolean[] usedColors = new boolean[5];  // We have 4 colors

            // Check the colors of the neighbors
            for (int neighbor : neighbors[i]) {
                usedColors[colors[neighbor]] = true;
            }

            // Assign the first available color
            for (int c = 1; c <= 4; c++) {
                if (!usedColors[c]) {
                    colors[i] = c;
                    break;
                }
            }
        }

        return colors;
    }
}     