class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int minRabbits = 0;
        for (int i = 0; i < answers.length; i++) {
            if (!map.containsKey(answers[i])) {
                map.put(answers[i], answers[i]);
                minRabbits = minRabbits + answers[i] + 1;
            } else {
                if (map.get(answers[i]) > 0) {
                    map.put(answers[i], map.get(answers[i]) - 1);
                } else {
                    map.put(answers[i], answers[i]);
                    minRabbits = minRabbits + answers[i] + 1;
                }
            }
        }
        return minRabbits;
    }
}