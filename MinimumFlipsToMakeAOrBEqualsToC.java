class Solution {
    public int minFlips(int a, int b, int c) {
        int result = 0;
        // If the current bit position at c is 0, then both bits in a and b correspondingly
        // has to be 0 as well
        // If the current position at c is 1, then we only need 1 bit to be 1 at least
        String BinaryNumA = Integer.toBinaryString(a);
        String BinaryNumB = Integer.toBinaryString(b);
        String BinaryNumC = Integer.toBinaryString(c);
        int lenA = BinaryNumA.length();
        int lenB = BinaryNumB.length();
        int lenC = BinaryNumC.length();
        // Pad smaller number with leading zeroes
        int len = Math.max(BinaryNumA.length(), Math.max(BinaryNumB.length(), BinaryNumC.length()));
        if (len > BinaryNumA.length()) {
            for (int i = 0; i < len - lenA; i++) {
                BinaryNumA = "0" + BinaryNumA;
            }
        }
        if (len > BinaryNumB.length()) {
            for (int i = 0; i < len - lenB; i++) {
                BinaryNumB = "0" + BinaryNumB;
            }
        }
        if (len > BinaryNumC.length()) {
            for (int i = 0; i < len - lenC; i++) {
                BinaryNumC = "0" + BinaryNumC;
            }
        }
        for (int i = 0; i < len; i++) {
            if (BinaryNumC.charAt(i) == '0') {
                if (BinaryNumA.charAt(i) == '1') {
                    result++;
                }
                if (BinaryNumB.charAt(i) == '1') {
                    result++;
                }
            } else if (BinaryNumC.charAt(i) == '1') {
                if (BinaryNumA.charAt(i) == '0' && BinaryNumB.charAt(i) == '0') {
                    result++;
                }
            }
        }
        return result;
    }
}