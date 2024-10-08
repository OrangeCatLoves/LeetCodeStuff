class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        if (intervals.length == 0) {
            return 0;
        }
        int result = 0;
        int[] lastInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            if (currInterval[0] < lastInterval[1]) {
                result++;
                continue;
            }
            lastInterval = currInterval;
        }
        return result;
    }
}