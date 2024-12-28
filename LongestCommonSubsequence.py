# Use dynamic programming. DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
# DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
# Length == Index in this solution

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        len1 = len(text1)
        len2 = len(text2)
        dp = [[0 for _ in range(len2 + 1)] for _ in range(len1 + 1)]
        for i in range(0, len1):
            for j in range(0, len2):
                if (text1[i] == text2[j]):
                    dp[i + 1][j + 1] = dp[i][j] + 1
                    continue
                else:
                    dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1])
        
        return dp[len1][len2]
