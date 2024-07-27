class Solution {
    public int hammingWeight(int n) {
        String bits = "";
        int remainder = 0;
        int nextNum = n;
        while (nextNum > 0) {
            remainder = nextNum % 2;
            bits = bits + remainder;
            nextNum = (nextNum - remainder) / 2;
            System.out.println(nextNum + " " + bits);
        }
        int result = 0;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
    /*6 => 110
    6 % 2 = 0 // Remainder
    0
    (6 - 0) / 2 = 3;
    3 % 2 = 1
    01
    (3 - 1) / 2 = 1;
    1 % 2 = 1;
    011
    (1 - 1) / 2 = 0;*/
}