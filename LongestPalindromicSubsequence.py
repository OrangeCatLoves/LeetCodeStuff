# Dyanmic programming
# Similar to LCS but the second string is reversed of first string

class Solution:
    def longestPalindromeSubseq(self, s1: str) -> int:
        len1 = len(s1)
        s2 = s1[::-1]
        len2 = len(s2)
        dp = [[0 for _ in range(len2 + 1)] for _ in range(len1 + 1)]
        for i in range(0, len1):
            for j in range(0, len2):
                if (s1[i] == s2[j]):
                    dp[i + 1][j + 1] = dp[i][j] + 1
                    continue
                else:
                    dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1])
        
        return dp[len1][len2]

# Space optimised to O(N) only since at every point in your calculation
# You only need the previous and current row in your dp

class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp, dpPrev = [0] * n, [0] * n
        for i in range(n - 1, -1, -1):
            dp[i] = 1
            for j in range(i+1, n):
                if s[i] == s[j]:
                    dp[j] = dpPrev[j - 1] + 2
                else:
                    dp[j] = max(dpPrev[j], dp[j - 1])
            dp, dpPrev = dpPrev, dp

        return dpPrev[n - 1]



        
