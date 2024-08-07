class Solution {
    int M = (int) Math.pow(10,6), N = (int) Math.pow(10,6);
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String> walls = new HashSet<>();
        for (int[] b : blocked) {
            walls.add(b[0] + "," + b[1]);
        }
        int R = 2 * blocked.length; // Maximum blocked radius
        return bfs(R, source, target, blocked, walls) && bfs(R, target, source, blocked, walls);
    }

    private boolean bfs(int R , int[] p, int[] target, int[][] mat, HashSet<String> walls) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // E, W, S, N

        HashSet<String> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(p);
        vis.add(p[0] + "," + p[1]);
        int len = 1;
        int level = 0;

        //The len variable keeps track of the number of nodes to process at the current BFS level.
        //len_ keeps track of the number of nodes to process at the next BFS level.
        //level keeps track of the depth of the BFS traversal. If level exceeds R, it indicates that we can move beyond the maximum possible
        //blocked area, and thus escape is possible.

        while (!q.isEmpty()) {
            int len_ = 0;
            while (len --> 0) {
                int arr[] = q.poll();
                if (arr[0] == target[0] && arr[1] == target[1]) return true;
                // Add neighbors
                for (int[] dir : dirs) {
                    int r_ = arr[0] + dir[0];
                    int c_ = arr[1] + dir[1];
                    String val = r_ + "," + c_;
                    if (r_ < 0 || r_ >= M || c_ < 0 || c_ >= N || vis.contains(val) || walls.contains(val)) continue;
                    vis.add(val);
                    q.add(new int[]{r_, c_});
                    len_++;
                }
            }
            len = len_;
            if (++level > R) return true;
        }
        return false;
    }
}