class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] char_counts = new int[26]; // Indicates the number of characters in my current window

        int window_start = 0;
        int max_length = 0;
        int max_count = 0; // Will always be updated with the current highest number of similar characters in a specific window
        for (int window_end = 0; window_end < len; window_end++) {
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);

            while (window_end - window_start + 1 - max_count > k) { // This condition happens only when you run out of k replacement
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end - window_start + 1);
        }
        return max_length;
    }
}