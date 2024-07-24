/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        // Convert List<Interval> to ArrayList<Interval>
        ArrayList<Interval> arrayListOfIntervals = new ArrayList<>(intervals);
        // Sort the ArrayList based on the start time
        sortIntervalsByStartTime(arrayListOfIntervals);
        for (int i = 0; i < arrayListOfIntervals.size() - 1; i++) {
            if (arrayListOfIntervals.get(i).end > arrayListOfIntervals.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }

    // Method to sort intervals by start time
    public static void sortIntervalsByStartTime(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
    }
}