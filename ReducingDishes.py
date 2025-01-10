# satisfaction[i] (Subarray) = satisfaction[i - 1] (Subarray) + sum(satisfaction[i])
# When considering the subarrays when it is sorted in descending order
# To maximise the value added, ensure that the sum is always > 0

# class Solution:
#     def maxSatisfaction(self, satisfaction: List[int]) -> int:
#         satisfaction.sort(reverse = True)
#         _sum, result = 0, 0
#         for satis in satisfaction:
#             _sum += satis
#             if (_sum < 0):
#                 continue
#             result += _sum
#         return result

# 0/1 Knapsack problem, either you consider the dish or you don't
class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction = sorted(satisfaction)
        @cache
        def dfs(i, c):
            if i >= len(satisfaction):
                return 0
            # Consider the max of either you include the dish or you don't
            res = max(satisfaction[i] * c + dfs(i + 1, c + 1), dfs(i + 1, c))
            return res
        return dfs(0, 1) 

# Both solution works, but the commented solution is so unintuitive
