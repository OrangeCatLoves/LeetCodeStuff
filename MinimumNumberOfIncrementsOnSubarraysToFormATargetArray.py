# Used an increasing monotonic stack
# But why did it work ?

class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        Stack = list()
        Stack.append(0)
        totalIncrements = 0
        for currTarget in target:
            if (Stack[-1] < currTarget):
                totalIncrements += currTarget - Stack[-1]
                Stack.append(currTarget)
            else:
                while (Stack[-1] >= currTarget):
                    Stack.pop()
                Stack.append(currTarget)
        
        return totalIncrements
        
