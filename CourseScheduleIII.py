# Sort the courses based on their close time
# Try to fit the courses in
# If the course time > deadline, unlearn the course that is most time consuming
# If time < deadline, learn the course (Add to the pq)

class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key = lambda c: c[1])
        A, curr = [], 0
        for dur, ld in courses:
            heapq.heappush(A, -dur)
            curr += dur
            if curr > ld: curr += heapq.heappop(A)
        return len(A)
