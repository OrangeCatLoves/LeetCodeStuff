class Solution {
    public boolean isAnagram(String s, String t) {
        // true if t is an anagram of s
        // index = ASCII val, element = frequency of usage
        int[] histogramS = new int[128];
        int[] histogramT = new int[128];
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int index = (int) s.charAt(i);
            histogramS[index]++;
        }
        for (int i = 0; i < len; i++) {
            int index = (int) t.charAt(i);
            histogramT[index]++;
        }
        for (int i = 0; i < 128; i++) {
            if (histogramS[i] != histogramT[i]) {
                return false;
            }
        }
        return true;
    }
}