class Solution {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if ((s.charAt(j) == s.charAt(i) && (i == j + 1))|| i == j)
                    dp[i][j] = true;
                else if (s.charAt(j) == s.charAt(i) && dp[i-1][j+1])
                    dp[i][j] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j])
                    count++;
            }
        }
        return count;
    }
}