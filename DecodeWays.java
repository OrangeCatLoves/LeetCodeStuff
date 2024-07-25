class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] res = new int[n+1];

        res[0] = 1; // Base case: one way to decode an empty string
        res[1] = s.charAt(0) == '0' ? 0 : 1; // One way to decode a non-'0' first character

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i)); // Last one digit
            int twoDigit = Integer.valueOf(s.substring(i - 2, i)); // Last two digits

            if (oneDigit >= 1) {
                res[i] += res[i - 1]; // If valid one-digit decode, add ways up to i-1
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                res[i] += res[i - 2]; // If valid two-digit decode, add ways up to i-2
            }
        }
        return res[n]; // Number of ways to decode the entire string
    }
}
