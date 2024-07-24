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

import java.util.PriorityQueue;

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */

    public int minMeetingRooms(List<Interval> intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.size() == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.size(),
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Collections.sort(
                intervals,
                new Comparator<Interval>() {
                    public int compare(final Interval a, final Interval b) {
                        return a.start - b.start;
                    }
                });

        // Add the first meeting
        allocator.add(intervals.get(0).end);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.size(); i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals.get(i).start >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals.get(i).end);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}

