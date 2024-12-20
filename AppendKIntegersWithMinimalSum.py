# Use Priority Queue 
# Start from 1 (Initialise a variable)
# Commented lines only passed 85 test cases

from queue import PriorityQueue

class Solution:
    def minimalKSum(self, nums: List[int], k: int) -> int:
        pq = PriorityQueue()
        totalSum = 0
        currVal = 1
        for num in nums:
            pq.put(num)
        pq.put(sys.maxsize)
        while (k > 0):
            currNum = pq.get()
            if (currNum > currVal):
                if (currNum - currVal >= k):
                    #totalSum = totalSum + sum(range(currVal, currVal + k))
                    totalSum += (k * (2 * currVal + k - 1)) // 2
                    k = 0
                    currVal = currNum + 1
                elif (currNum - currVal < k):
                    #totalSum = totalSum + sum(range(currVal, currNum))
                    totalSum += ((currNum - currVal) * (currVal + currNum - 1)) // 2
                    k = k - (currNum - currVal)
                    currVal = currNum + 1
            else:
                currVal = currNum + 1

        return totalSum
        
