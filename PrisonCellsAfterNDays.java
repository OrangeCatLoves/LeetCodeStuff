import java.util.HashSet;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int len = cells.length;
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (cells[i] == 1) {
                num = num + (int)Math.pow(2, len - i - 1);
            }
        }
        Set<Integer> hash = new HashSet<>();
        int i = 0;
        for(; i < n; i++){
            // XNOR because both bits need to be on/off
            // and 126 (01111110) to turnoff endbits
            int temp = ~(num << 1 ^ num >> 1) & 126;
            if (hash.contains(temp)) break;
            hash.add(temp);
            num = temp;
        }

        if (i != n) {
            n %= i;
            i = 0;
            for(; i < n; i++){
                num = ~(num << 1 ^ num >> 1) & 126;
            }
        }

        int[] ans = new int[8];
        for (int j = 7; j>=0; j--) {
            if (num % 2 == 1) ans[j] = 1;
            else ans[j] = 0;
            num /= 2;
        }
        return ans;
    }
}