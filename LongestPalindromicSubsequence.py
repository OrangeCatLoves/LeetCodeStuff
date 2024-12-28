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



        
