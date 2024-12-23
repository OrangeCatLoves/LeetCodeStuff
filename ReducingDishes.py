# satisfaction[i] (Subarray) = satisfaction[i - 1] (Subarray) + sum(satisfaction[i])
# To maximise the value added, ensure that the sum is always > 0

class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort(reverse = True)
        _sum, result = 0, 0
        for satis in satisfaction:
            _sum += satis
            if (_sum < 0):
                continue
            result += _sum
        
        return result
