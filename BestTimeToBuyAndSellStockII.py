# Greedy algorithm (Overthinking too much for this question)
# Just sell and buy the same stock itself on the same day if the stock is more expensive
# On the next day

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if (n == 1):
            return 0
        
        totalProfit = 0
        for i in range(1, n):
            if (prices[i] > prices[i - 1]):
                totalProfit += prices[i] - prices[i - 1]
        
        return totalProfit
        
