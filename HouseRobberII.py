'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        if (len(nums) == 1): return nums[0]
        if (len(nums) == 2): return max(nums[0], nums[1])
        n = len(nums)
        dp_skip_first = [0] * n
        dp_skip_last = [0] * n
        dp_skip_first[n - 1] = nums[n - 1]
        dp_skip_last[0] = nums[0]
        # Skip last house, rob first house
        for i in range(2, n - 1):
            max_stolen = 0
            for j in range(i - 2, -1, -1):
                max_stolen = max(max_stolen, dp_skip_last[j])
            dp_skip_last[i] = max_stolen + nums[i]

        result_skip_last = 0
        for i in range(n):
            result_skip_last = max(result_skip_last, dp_skip_last[i])

        # Skip first house, rob last house
        for i in range(n - 3, 0, -1):
            max_stolen = 0
            for j in range(i + 2, n):
                max_stolen = max(max_stolen, dp_skip_first[j])
            dp_skip_first[i] = max_stolen + nums[i]

        result_skip_first = 0
        for i in range(n):
            result_skip_first = max(result_skip_first, dp_skip_first[i])
        
        return max(dp_skip_last[0], dp_skip_first[n - 1])
'''

# Skip the last house, rob the first house
# Skip the first house, rob the last house
# Find the maximum of these 2 cases

class Solution:
    def rob(self, nums: List[int]) -> int:
        if (len(nums) == 1): return nums[0]
        if (len(nums) == 2): return max(nums[0], nums[1])
        n = len(nums)
        dp_skip_first = [0] * n
        dp_skip_last = [0] * n
        
        # Skip first house (use nums[1] to nums[n-1])
        dp_skip_first[1] = nums[1]
        dp_skip_first[2] = max(nums[1], nums[2])
        for i in range(3, n):
            dp_skip_first[i] = max(dp_skip_first[i - 1], dp_skip_first[i - 2] + nums[i])
        
        # Skip last house (use nums[0] to nums[n-2])
        dp_skip_last[0] = nums[0]
        dp_skip_last[1] = max(nums[0], nums[1])
        for i in range(2, n - 1):
            dp_skip_last[i] = max(dp_skip_last[i - 1], dp_skip_last[i - 2] + nums[i])
        
        return max(dp_skip_first[n - 1], dp_skip_last[n - 2])
        
