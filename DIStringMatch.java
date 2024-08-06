class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int left = 0;
        int right = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = left++; // Assigned before increment
            } else {
                result[i] = right--; // Assigned before decrement
            }
        }
        result[n] = left; // result[n] = right;  works as well!
        return result;
    }
}