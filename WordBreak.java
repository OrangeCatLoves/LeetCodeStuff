/*class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int end = s.length();
        boolean[] cache = new boolean[s.length() + 1];
        cache[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String currString : wordDict) {
                if (s.substring(i, end).equals(currString) && cache[end]) {
                    System.out.println(end);
                    cache[i] = true;
                    end = i;
                    break;
                } else {
                    System.out.println(end);
                    cache[i] = false;
                }
            }
        }
        return cache[0];
    }
}*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] cache = new boolean[n + 1];
        cache[n] = true; // The base case: an empty string is always valid

        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word) && cache[i + len]) {
                    cache[i] = true;
                    break; // No need to check further, we've found a valid segmentation
                }
            }
        }
        return cache[0];
    }
}
