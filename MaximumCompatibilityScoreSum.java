class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        int questions = students[0].length;
        int[][] compatibility = new int[n][n];
        for (int i = 0; i < n; i++) { // Current student
            for (int j = 0; j < n; j++) { // Current mentor
                int score = 0;
                for (int q = 0; q < questions; q++) {
                    if (students[i][q] == mentors[j][q]) {
                        score++;
                    }
                }
                compatibility[i][j] = score;
            }
        }
        boolean[] mentorUsed = new boolean[n];
        return findMaxCompatibility(0, compatibility, n, mentorUsed);
    }

    private int findMaxCompatibility(int index, int[][] compatibility, int size, boolean[] mentorUsed) {
        if (index == size) { // All students are assigned, index refers to the student here
            return 0;
        }
        int maxScore = 0;
        for (int mentor = 0; mentor < size; mentor++) {
            if (!mentorUsed[mentor]) {
                mentorUsed[mentor] = true;
                maxScore = Math.max(maxScore, compatibility[index][mentor]
                        + findMaxCompatibility(index + 1, compatibility, size, mentorUsed));
                mentorUsed[mentor] = false;
            }
        }
        return maxScore;
    }
}