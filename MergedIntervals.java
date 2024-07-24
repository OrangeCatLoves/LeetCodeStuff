class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int pointer = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[pointer][1]) {
                intervals[pointer][0] = Math.min(intervals[pointer][0], intervals[i][0]);
                intervals[pointer][1] = Math.max(intervals[pointer][1], intervals[i][1]);
            } else {
                pointer++;
                intervals[pointer][0] = intervals[i][0];
                intervals[pointer][1] = intervals[i][1];
            }
        }
        // Removes old values which were not reassigned in modified intervals array
        return Arrays.copyOf(intervals, pointer + 1);
    }
}