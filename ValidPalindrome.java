class Solution {
    public boolean isPalindrome(String s) {
        String result = "";
        int len = s.length();
        // uppercase ASCII range: 65-90 inclsuive
        // lowercase ASCII range: 97-122 inclusive
        // numbers ASCII range: 48-57 inclusive
        for (int i = 0; i < len; i++) {
            int value = (int) s.charAt(i);
            if (65 <= value && value <= 90) {
                result = result + s.substring(i , i + 1).toLowerCase();
            } else if (97 <= value && value <= 122 || 48 <= value && value <= 57) {
                result = result + s.substring(i , i + 1);
            }
        }
        int newLen = result.length();
        int start = 0;
        int end = newLen - 1;
        while (start < end) {
            if (result.charAt(start) != result.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}