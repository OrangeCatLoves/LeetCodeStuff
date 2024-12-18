class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        size = len(nums)
        # Consider the base case first for DP
        if (size < 2): return size
        up, down = 1, 1
        for i in range(1, size):
            if nums[i] > nums[i - 1]:
                up = down + 1
            elif nums[i] < nums[i - 1]:
                down = up + 1
        return max(up, down)
