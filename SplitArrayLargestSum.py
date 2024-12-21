# Elements are non-negative
# The largest one of m sums ranges between (max(nums) to sum(nums))
# Use binary search to find minimal possible value of sum
# This question is similar to load-balancing question

class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        # If you need more "cuts" (partitions + 1) than the given input m, you can't split the array
        def cannot_split(max_sum, m):
            cuts, curr_sum  = 0, 0
            for x in nums:
                curr_sum += x
                if curr_sum > max_sum:
                    cuts += 1
                    curr_sum = x
            subs = cuts + 1
            return (subs > m)
        
        low, high = max(nums), sum(nums)
        while low < high:
            guess = low + (high - low) // 2
            if cannot_split(guess, m):
                low = guess + 1
            else:
                high = guess
        return low
