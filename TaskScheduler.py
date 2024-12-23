# Maintain a PriorityQueue of size 
# Consistently peek at the max-heap while altering the priorities 
# Do this until all the tasks count hit zero

from collections import Counter, deque
import heapq
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = Counter(tasks)
        heap = []
        cooldown = deque()
        timer = 0

        # Create a max heap
        for key, value in freq.items():
            heapq.heappush(heap, -value)
        
        while heap or cooldown:
            if heap:
                task = -heapq.heappop(heap)
                if task > 1:
                    cooldown.append((task - 1, timer + n + 1))
            timer += 1
            
            # The elements at the front of the queue should have a timer == cooldown[0][1]
            # When the task coolsdown eventually
            if cooldown and cooldown[0][1] == timer:
                task_count = cooldown[0][0]
                cooldown.popleft()
                heapq.heappush(heap, -task_count)
        
        return timer
        

        
