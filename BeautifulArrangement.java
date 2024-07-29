class Solution {
    private int result;
    public int countArrangement(int n) {
        if (n == 1) {
            return 1;
        }
        boolean[] isUsed = new boolean[n + 1];
        Helper(n, 1, isUsed);
        return this.result;
    }

    private void Helper(int n, int index, boolean[] isUsed) {
        if (index == n + 1) {
            System.out.println("A");
            this.result++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isUsed[i] && (i % index == 0 || index % i == 0)) {
                isUsed[i] = true;
                Helper(n, index + 1, isUsed);
                isUsed[i] = false;
            }
        }
    }
}
