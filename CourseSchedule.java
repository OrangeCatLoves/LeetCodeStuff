import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] directedGraph = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            directedGraph[i] = new ArrayList<>();
        }
        // index 0 is the course
        // index 1 is the prereq course
        // edge goes from 1 to 0
        for (int[] prereq: prerequisites) {
            directedGraph[prereq[1]].add(prereq[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            for (int neighbour: directedGraph[i]) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // Populate the queue first with courses with in-degree of 0,
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int numOfNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            numOfNodes++;
            for (int neighbour: directedGraph[node]) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return numOfNodes == numCourses;
    }
}