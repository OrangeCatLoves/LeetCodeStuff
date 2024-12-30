# Solution from https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solutions/5574885/python-no-more-3d-dp-1d-dinamic-programming-small-simple-code-easy-to-understand/

# Spent variable here stores the lowest price of the stocks in the subarray
# If prices[i] <= spent, it means that a newest lowest price is being discovered (You can't make a profit out of it so you can only update it)
# If prices[i] > spent, it means that there's a chance for a profit, so you can if the profit is possibly the maximum
# prefix is constantly being updated by the maximum profit in the [0, i] region of prices (i.e prefix[i] == maximum profit of [0, i])
# suffix is constantly being updated by the maximum profit in the [i + 1, n- 1] region of prices (i.e suffix[i] == maximum profit of [i + 1, n - 1])
# Max profit of 2 transactions is taken the max of [0, i] and [i + 1, n - 1]

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1: return 0

        # prefix aims to find the maximum profit in the subarray between [0, i]
        prefix = [0] * len(prices)
        ans = 0
        # spent here stores the lowest price of the stock
        spent = prices[0]
        for i in range(1, len(prices)):
            if prices[i] > spent:
                if prices[i] - spent > ans:
                    ans = prices[i] - spent
            else:
                spent = prices[i]
            prefix[i] = ans

        # suffix aims to find the maximum profit in the other half [i + 1, n - 1]
        suffix = [0] * len(prices)
        ans = 0
        sell = prices[-1] # Assigned last element of prices list
        for i in range(len(prices) - 1, -1, -1):
            if prices[i] < sell:
                if sell - prices[i] > ans:
                    ans = sell - prices[i]
            else:
                sell = prices[i]
            suffix[i] = ans

        profit = prefix[-1]
        for i in range(len(prefix) - 1):
            profit = max(profit, prefix[i] + suffix[i + 1])
        return profit
